package model;
import java.sql.*;

public class AdmissionManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createAdmissionRecord(int pID, int wID, String admissionDate)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "INSERT INTO admission (patient_id, ward_id, admission_date) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, pID);
            pstmt.setInt(2, wID);
            pstmt.setString(3, admissionDate);

            pstmt.executeUpdate();
            System.out.println("Admission Record inserted successfully!");

            pstmt.close();
            conn.close();
            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewPatientAdmission() //READ
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM admission";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result
            while(rs.next())
            {
                int admissionID = rs.getInt("admission_id");
                int pID = rs.getInt("patient_id");
                int wID = rs.getInt("ward_id");
                String admissionDate = rs.getString("admission_date");

                System.out.println(admissionID + ", " + pID + ", " + wID + ", " + admissionDate);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updateAdmissionRecord(Admission admission)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE admission SET patient_id = ?, ward_id = ?, admission_date = ? WHERE admission_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, admission.getPatientID());
            pstmt.setInt(2, admission.getWardID());
            pstmt.setString(3, admission.getAdmissionDate());
            pstmt.setInt(4, admission.getAdmissionID());

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected > 0)
            {
                System.out.println("Admission with id = " + admission.getAdmissionID() + " has been updated!");
                pstmt.close();
                conn.close();
                return true;
            }
            else
            {
                System.out.println("Admission record update failed.");
                pstmt.close();
                conn.close();
                return false;
            }


        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteAdmissionRecord(int admissionID) //DELETE
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "DELETE FROM admission WHERE admission_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, admissionID); //1 is position placeholder of ? in sql variable. since 1 lang ung ?, it starts at 1

            int rowsAffected = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            if(rowsAffected > 0)
            {
                System.out.println("Admission record with id = " + admissionID + " deleted successfully!");
                return true;
            }
            else
            {
                System.out.println("Admission deletion failed");
                return false;
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public static void main(String[] args)
    {
        AdmissionManagement am = new AdmissionManagement();
//        Admission a = new Admission(103, 502, "2025-11-11");

//        am.createAdmissionRecord(103, 502, "2025-11-10");
//        a.setAdmissionID(8003);
//        am.updateAdmissionRecord(a);
        am.deleteAdmissionRecord(8003);
        am.viewPatientAdmission();
    }
}
