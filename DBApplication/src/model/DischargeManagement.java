package model;

import java.sql.*;

public class DischargeManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/DB";
    private static final String USER = "root";
    private static final String PASSWORD = "KC379379";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createDischargeRecord(int admission_id, String discharge_date)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            // no discahrge id since it auto increments
            String sql = "INSERT INTO discharge (admission_id, discharge_date) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, admission_id);
            pstmt.setString(2, discharge_date);

            pstmt.executeUpdate();
            System.out.println("Discharge Record inserted successfully!");

            pstmt.close();
            conn.close();
            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewDischargeRecord() //READ
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM discharge";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result
            while(rs.next())
            {
                int discharge_id = rs.getInt("discharge_id");
                int admission_id = rs.getInt("admission_id");
                String discharge_date = rs.getString("discharge_date");

                System.out.println(discharge_id + ", " + admission_id + ", " + discharge_date);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updateDischargeRecord(Discharge discharge)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE discharge SET admission_id = ?, discharge_date = ? WHERE discharge_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, discharge.getAdmission_id());
            pstmt.setString(2, discharge.getDischarge_date());
            pstmt.setInt(3, discharge.getDischarge_id());

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected > 0)
            {
                System.out.println("Discharge with id = " + discharge.getDischarge_id() + " has been updated!");
                pstmt.close();
                conn.close();
                return true;
            }
            else
            {
                System.out.println("Discharge record update failed.");
                pstmt.close();
                conn.close();
                return false;
            }


        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteDischargeRecord(int discharge_id) //DELETE
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "DELETE FROM discharge WHERE discharge_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, discharge_id); //1 is position placeholder of ? in sql variable. since 1 lang ung ?, it starts at 1

            int rowsAffected = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            if(rowsAffected > 0)
            {
                System.out.println("Discharge record with id = " + discharge_id + " deleted successfully!");
                return true;
            }
            else
            {
                System.out.println("Discharge record deletion failed");
                return false;
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args)
    {
        DischargeManagement dischargeManagement = new DischargeManagement();

//        dischargeManagement.createDischargeRecord();
//        dischargeManagement.viewDischargeRecord();

    }
}
