package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class IllnessManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/DB";
    private static final String USER = "root";
    private static final String PASSWORD = "KC379379";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createIllness(Illness illness) //create
    {
        try {
            //This is where we will put codes that will interact w/ database
            //1. connect to database
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            //2. Prepare SQL Statement --> store in PreparedStatement (dont forget to put alias for column name so u can fetch the value)
            String sql = "INSERT INTO illness (illness_name, category, illness_description) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, illness.getIllness_name());
            pstmt.setString(2, illness.getCategory());
            pstmt.setString(3, illness.getIllness_description());


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
        public List<Illness> viewIllnessRecords () // read
        {
            List<Illness> illnesses = new ArrayList<>();

            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                System.out.println("Connection to database successful!");

                String sql = "SELECT * FROM illness";
                pstmt = conn.prepareStatement(sql);

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Illness illness = new Illness(rs.getInt("illness_id"));
                    illness.setIllnessName(rs.getString("illness_name"));
                    illness.setCategory(rs.getString("category"));
                    illness.setIllness_description(rs.getString("illness_description"));
                    illnesses.add(illness);

                    int illness_id = rs.getInt("illness_id");
                    String illness_name = rs.getString("illness_name");
                    String category = rs.getString("category");
                    String illness_description = rs.getString("illness_description");

                    System.out.println(illness_id + " " + illness_name + " " + category + " " + illness_description);
                }

                pstmt.close();
                rs.close();
                conn.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return illnesses;
        }

        public boolean updateIllness (Illness illness){
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE illness SET illness_name = ?, category = ?, illness_description = ? WHERE illness_id = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, illness.getIllness_name());
            pstmt.setString(2, illness.getCategory());
            pstmt.setString(3, illness.getIllness_description());
            pstmt.setInt(4, illness.getIllness_id());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Illness updated successfully!");
                pstmt.close();
                conn.close();
                return true;
            } else {
                System.out.println("Illness ID not found.");
                pstmt.close();
                conn.close();
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

        public boolean deleteIllness (Illness illness){
        String delete_sql = "DELETE FROM illness  WHERE illness_id = ?";


        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            pstmt = conn.prepareStatement(delete_sql);
            pstmt.setInt(1, illness.getIllness_id());
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Illness deleted successfully!");
                pstmt.close();
                return true;
            } else {
                System.out.println("Illness ID not found.");
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
        IllnessManagement  illnessManagement = new IllnessManagement();

        Illness illness = new Illness("Pneumonia", "Infectious Disease", "Severe inflammation of the lungs");
        illnessManagement.createIllness(illness);
        illnessManagement.viewIllnessRecords();
    }

}
