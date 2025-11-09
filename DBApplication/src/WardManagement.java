import java.sql.*;

class Ward{
    private int ward_id;
    private String  floor;

    public Ward(String floor){
        this.floor = floor;
    }

    public int getWard_id() {
        return ward_id;
    }

    public String getFloor() {
        return floor;
    }

}

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
            String sql = "INSERT INTO ward (floor) VALUES (?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ward.getFloor());

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

                int ward_number = rs.getInt("ward_id");
                String floor = rs.getString("floor");

                System.out.println(ward_number + " " + floor);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updateWard(int ward_id, String newFloor) {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE ward SET floor = ? WHERE ward_id = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, newFloor); // new floor
            pstmt.setInt(2, ward_id); // new ward id
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ward updated successfully!");
                pstmt.close();
                conn.close();
                return true;
            } else {
                System.out.println("Ward ID not found.");
                pstmt.close();
                conn.close();
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteWard(int ward_id) {
        // SQL commands (check and delete)

        // business rule: check first if there are pateints in the ward
        String check_sql = "SELECT COUNT(*) AS patientCount FROM admission WHERE ward_id = ?";
        String delete_sql = "DELETE FROM ward  WHERE ward_id = ?";


        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");
            pstmt = conn.prepareStatement(check_sql);

            pstmt.setInt(1, ward_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() && rs.getInt("patientCount") > 0) {
                System.out.println("There is a patient assigned. This ward cannot be deleted.");
                return false;
            }

            // close the check before the delete
            pstmt.close();

            // if no patients
            pstmt = conn.prepareStatement(delete_sql);
            pstmt.setInt(1, ward_id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ward deleted successfully!");
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

       // Test ward
       Ward ward = new Ward("3rd floor");
       wardManagement.createWard(ward); // put ward in the database

        // Ward record
        wardManagement.viewWardRecords();
    }


}
