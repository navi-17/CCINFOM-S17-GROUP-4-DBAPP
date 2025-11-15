package model;

import java.sql.*;

public class WardManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/DB";
    private static final String USER = "root";
    private static final String PASSWORD = "KC379379";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createWard(Ward ward) //create
    {
        try {
            //This is where we will put codes that will interact w/ database
            //1. connect to database
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            //2. Prepare SQL Statement --> store in PreparedStatement (dont forget to put alias for column name so u can fetch the value)
            String sql = "INSERT INTO ward (floor, ward_no) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ward.getFloor());
            pstmt.setInt(2, ward.getWardNo());

            pstmt.executeUpdate();
            System.out.println("Record inserted successfully!");


            //3. After executing query, store result in ResultSet
            //4. To get result, use while(rst.next)

            pstmt.close();
            conn.close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewWardRecords() // read
    {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM ward";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                int ward_id = rs.getInt("ward_id");
                int ward_no = rs.getInt("ward_no");
                String floor = rs.getString("floor");
                String status = rs.getString("ward_status");

                System.out.println(ward_id + " " + ward_no + " " + floor + " " + status);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updateWard(Ward ward) {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE ward SET floor = ?, ward_number = ? WHERE ward_id = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ward.getFloor()); // new floor
            pstmt.setInt(2, ward.getWardNo());
            pstmt.setInt(3, ward.getWard_id()); // new ward id
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("model.Ward updated successfully!");
                pstmt.close();
                conn.close();
                return true;
            } else {
                System.out.println("model.Ward ID not found.");
                pstmt.close();
                conn.close();
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteWard(Ward ward) {
        // SQL commands (check and delete)

        // business rule: check first if there are pateints in the ward
        String check_sql = "SELECT COUNT(*) AS patientCount FROM admission WHERE ward_id = ?";
        String delete_sql = "DELETE FROM ward  WHERE ward_id = ?";


        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");
            pstmt = conn.prepareStatement(check_sql);

            pstmt.setInt(1, ward.getWard_id());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt("patientCount") > 0) {
                System.out.println("There is a patient assigned. This ward cannot be deleted.");
                return false;
            }

            // close the check before the delete
            pstmt.close();

            // if no patients
            pstmt = conn.prepareStatement(delete_sql);
            pstmt.setInt(1, ward.getWard_id());
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("model.Ward deleted successfully!");
                pstmt.close();
                return true;
            } else {
                System.out.println("Ward_ID not found.");
                pstmt.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            // close everything so no leak
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }

        public static void main(String[] args){
        WardManagement wardManagement = new WardManagement();

       // Test create ward
//       model.Ward ward = new model.Ward("2nd floor");
//       wardManagement.createWard(ward); // put ward in the database

       // Test update ward
//        wardManagement.updateWard(3, "1st Floor");

       // Test delete ward
//       wardManagement.deleteWard(3);
//        // model.Ward record
//        wardManagement.viewWardRecords();
    }


}
