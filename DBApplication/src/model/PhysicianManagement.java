package model;

import java.sql.*;

public class PhysicianManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createPhysicianRecord(Physician physician)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "INSERT INTO physician (ph_firstname, ph_lastname, contact_no, specialization) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, physician.getFirstName());
            pstmt.setString(2, physician.getLastName());
            pstmt.setString(3, physician.getContact());
            pstmt.setString(4, physician.getSpecialization());

            pstmt.executeUpdate();
            System.out.println("Physician Record inserted successfully!");

            pstmt.close();
            conn.close();
            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewPhysicianRecords() //READ
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM physician";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result
            while(rs.next())
            {
                int physicianID = rs.getInt("physician_id");
                String ln = rs.getString("ph_lastname");
                String fn = rs.getString("ph_firstname");
                String no = rs.getString("contact_no");
                String sp = rs.getString("specialization");

                System.out.println(physicianID + ", " + ln + ", " + fn + ", " + no + ", " + sp);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updatePhysicianRecord(Physician physician)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE physician SET ph_firstname = ?, ph_lastname = ?, contact_no = ?, specialization = ? WHERE physician_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, physician.getFirstName());
            pstmt.setString(2, physician.getLastName());
            pstmt.setString(3, physician.getContact());
            pstmt.setString(4, physician.getSpecialization());
            pstmt.setInt(5, physician.getPhysicianID());

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected > 0)
            {
                System.out.println("Physician with id = " + physician.getPhysicianID() + " has been updated!");
                pstmt.close();
                conn.close();
                return true;
            }
            else
            {
                System.out.println("Physician record update failed.");
                pstmt.close();
                conn.close();
                return false;
            }


        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deletePhysicianRecord(int physicianID) //DELETE
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "DELETE FROM physician WHERE physician_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, physicianID); //1 is position placeholder of ? in sql variable. since 1 lang ung ?, it starts at 1

            int rowsAffected = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            if(rowsAffected > 0)
            {
                System.out.println("physician with id = " + physicianID + " deleted successfully!");
                return true;
            }
            else
            {
                System.out.println("Physician deletion failed");
                return false;
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args)
    {
        Physician ph = new Physician("Meredith", "Gray", "+63 9166825678", "General");
        PhysicianManagement pm = new PhysicianManagement();

        Physician updatedPh = new Physician("Meredith", "Grey", "+63 9116685678", "General");
        updatedPh.setPhysician_id(2002);

//        pm.createPhysicianRecord(ph);
//        pm.updatePhysicianRecord(updatedPh);
        pm.deletePhysicianRecord(2002);
        pm.viewPhysicianRecords();
    }
}
