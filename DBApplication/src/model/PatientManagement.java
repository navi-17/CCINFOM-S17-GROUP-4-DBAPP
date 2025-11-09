package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createPatientRecord(Patient patient)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "INSERT INTO patient (p_lastname, p_firstname, contact_no) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, patient.getLastName());
            pstmt.setString(2, patient.getFirstName());
            pstmt.setString(3, patient.getContact());

            pstmt.executeUpdate();
            System.out.println("Patient Record inserted successfully!");

            pstmt.close();
            conn.close();
            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewPatientRecords() //READ
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM patient";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result
            while(rs.next())
            {
                int patientID = rs.getInt("patient_id");
                String ln = rs.getString("p_lastname");
                String fn = rs.getString("p_firstname");
                String no = rs.getString("contact_no");

                System.out.println(patientID + ", " + ln + ", " + fn + ", " + no);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updatePatientRecord(Patient patient)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE patient SET p_lastname = ?, p_firstname = ?, contact_no = ? WHERE patient_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patient.getLastName());
            pstmt.setString(2, patient.getFirstName());
            pstmt.setString(3, patient.getContact());
            pstmt.setInt(4, patient.getPatientID());

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected > 0)
            {
                System.out.println("Patient with id = " + patient.getPatientID() + " has been updated!");
                pstmt.close();
                conn.close();
                return true;
            }
            else
            {
                System.out.println("Patient record update failed.");
                pstmt.close();
                conn.close();
                return false;
            }


        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletePatientRecord(int patientID) //DELETE
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "DELETE FROM patient WHERE patient_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, patientID); //1 is position placeholder of ? in sql variable. since 1 lang ung ?, it starts at 1

            int rowsAffected = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            if(rowsAffected > 0)
            {
                System.out.println("Patient with id = " + patientID + " deleted successfully!");
                return true;
            }
            else
            {
                System.out.println("Patient deletion failed");
                return false;
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args)
    {
        Patient p = new Patient("Yeager","Eren","+63 9184398952");
        PatientManagement pm = new PatientManagement();

        Patient updateP = new Patient("Braun", "Reiner", "+63 9184398951");
        updateP.setPatientID(102);
//        pm.createPatientRecord(p);
//        pm.updatePatientRecord(updateP);
        pm.deletePatientRecord(updateP.getPatientID());
        pm.viewPatientRecords();
    }
}
