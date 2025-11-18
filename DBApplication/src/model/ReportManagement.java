package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/DB";
    private static final String USER = "root";
    private static final String PASSWORD = "KC379379";
    private Connection conn;
    PreparedStatement pstmt;

    public int getPhysiciansWorkloadReport(String type, int physicianID, String dateOrMonth, Integer year)
    {
        int totalPatients = 0;

        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");
            String sql = "";


            if(type.equalsIgnoreCase("day"))
            {
                sql = "SELECT COUNT(DISTINCT d.patient_id) AS Total_Patients " +
                        "FROM treatment t " +
                            "LEFT JOIN diagnosis d ON t.diagnosis_id = d.diagnosis_id "+
                            "LEFT JOIN physician_schedule ps ON d.physicianSchedule_id = ps.physicianSchedule_id " +
                        "WHERE t.treatment_date = ? " +
                            "AND ((t.performed_by = 'Diagnosing Physician' AND ps.physician_id = ?) " +
                            "OR (t.performed_by = 'Assigned Physician' AND t.assignedPhysician_id = ?))";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, dateOrMonth);
                pstmt.setInt(2, physicianID);
                pstmt.setInt(3, physicianID);

            }
            else if(type.equalsIgnoreCase("month"))
            {
                sql = "SELECT COUNT(DISTINCT d.patient_id) AS Total_Patients " +
                        "FROM treatment t " +
                            "LEFT JOIN diagnosis d ON t.diagnosis_id = d.diagnosis_id "+
                            "LEFT JOIN physician_schedule ps ON d.physicianSchedule_id = ps.physicianSchedule_id " +
                        "WHERE MONTH(t.treatment_date) = ? " +
                            "AND YEAR(t.treatment_date) = ? " +
                            "AND ((t.performed_by = 'Diagnosing Physician' AND ps.physician_id = ?) " +
                            "OR (t.performed_by = 'Assigned Physician' AND t.assignedPhysician_id = ?))";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(dateOrMonth));
                pstmt.setInt(2, year);
                pstmt.setInt(3, physicianID);
                pstmt.setInt(4, physicianID);
            }
            else
            {
                sql = "SELECT COUNT(DISTINCT d.patient_id) AS Total_Patients " +
                        "FROM treatment t " +
                            "LEFT JOIN diagnosis d ON t.diagnosis_id = d.diagnosis_id "+
                            "LEFT JOIN physician_schedule ps ON d.physicianSchedule_id = ps.physicianSchedule_id " +
                        "WHERE YEAR(t.treatment_date) = ? " +
                        "AND ((t.performed_by = 'Diagnosing Physician' AND ps.physician_id = ?) " +
                            "OR (t.performed_by = 'Assigned Physician' AND t.assignedPhysician_id = ?))";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, year);
                pstmt.setInt(2, physicianID);
                pstmt.setInt(3, physicianID);
            }

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result

            if(rs.next())
            {
                totalPatients = rs.getInt("Total_Patients");
                System.out.println(totalPatients);

            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return totalPatients;
    }

    public int getIllnessOccurenceReport (String type, String illness, String dateOrMonth, Integer year){
        int totalPatients = 0;

        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");
            String sql = "";


            if(type.equalsIgnoreCase("day"))
            {
                sql = "SELECT COUNT(DISTINCT p.patient_id) AS Total_Patients " +
                        "FROM patient p " +
                        "JOIN diagnosis d ON p.patient_id = d.patient_id " +
                        "JOIN treatment t ON d.diagnosis_id = t.diagnosis_id " +
                        "WHERE d.illness = ? " +
                        "AND t.treatment_date = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, illness);
                pstmt.setString(2, dateOrMonth);


            }
            else if(type.equalsIgnoreCase("month"))
            {
                sql = "SELECT COUNT(DISTINCT p.patient_id) AS Total_Patients " +
                        "FROM patient p " +
                        "JOIN diagnosis d ON p.patient_id = d.patient_id " +
                        "JOIN treatment t ON d.diagnosis_is = t.diagnosis_id " +
                        "WHERE d.illness = ? " +
                        "AND MONTH(t.treatment_date) = ? " +
                        "AND YEAR(t.treatment_date) = ? ";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, illness);
                pstmt.setInt(2, Integer.parseInt(dateOrMonth));
                pstmt.setInt(3, year);
            }
            else
            {
                sql = "SELECT COUNT(DISTINCT p.patient_id) AS Total_Patients " +
                        "FROM patient p " +
                        "JOIN diagnosis d ON p.patient_id = d.patient_id " +
                        "JOIN treatment t ON d.diagnosis_is = t.diagnosis_id " +
                        "WHERE d.illness = ? " +
                        "AND YEAR(t.treatment_date) = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, illness);
                pstmt.setInt(2, year);
            }

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result

            if(rs.next())
            {
                totalPatients = rs.getInt("Total_Patients");
                System.out.println(totalPatients);

            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return totalPatients;
    }

    public int getTreatmentStatistics(String type, int treatmentID, String dateOrMonth, Integer year)
    {
        int totalPatients = 0;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "";

            if (type.equalsIgnoreCase("day"))
            {
                sql = "SELECT COUNT(DISTINCT d.patient_id) AS Total_Patients " +
                        "FROM treatment t " +
                        "LEFT JOIN diagnosis d ON t.diagnosis_id = d.diagnosis_id" +
                        "WHERE t.treatment_id = ? " +
                        "AND t.treatment_date = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, treatmentID);
                pstmt.setString(2, dateOrMonth);

            }
            else if (type.equalsIgnoreCase("month"))
            {
                sql = "SELECT COUNT(DISTINCT d.patient_id) AS Total_Patients " +
                        "FROM treatment t " +
                        "LEFT JOIN diagnosis d ON t.diagnosis_id = d.diagnosis_id " +
                        "WHERE t.treatment_id = ? " +
                        "AND MONTH(t.treatment_date) = ? " +
                        "AND YEAR(t.treatment_date) = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, treatmentID);
                pstmt.setInt(2, Integer.parseInt(dateOrMonth)); // month
                pstmt.setInt(3, year);

            }
            else
            {
                sql = "SELECT COUNT(DISTINCT d.patient_id) AS Total_Patients " +
                        "FROM treatment t " +
                        "LEFT JOIN diagnosis d ON t.diagnosis_id = d.diagnosis_id " +
                        "WHERE t.treatment_id = ? " +
                        "AND YEAR(t.treatment_date) = ?";

                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, treatmentID);
                pstmt.setInt(2, year);
            }

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                totalPatients = rs.getInt("Total_Patients");
                System.out.println(totalPatients);
            }


            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return totalPatients;
    }
}
