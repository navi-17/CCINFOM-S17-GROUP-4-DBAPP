package model;

import java.sql.*;

public class NurseManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean registerNurse(Nurse nurse) //create
    {
        try{
            //This is where we will put codes that will interact w/ database
            //1. connect to database
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            //2. Prepare SQL Statement --> store in PreparedStatement (dont forget to put alias for column name so u can fetch the value)
            String sql = "INSERT INTO nurse (n_lastname, n_firstname, contact_no) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, nurse.getLastName());
            pstmt.setString(2, nurse.getFirstName());
            pstmt.setString(3, nurse.getContactNo());

            pstmt.executeUpdate();
            System.out.println("Record inserted successfully!");


            //3. After executing query, store result in ResultSet
            //4. To get result, use while(rst.next)

            pstmt.close();
            conn.close();
            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewNurseRecords()
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM nurse";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int nurseID = rs.getInt("nurse_id");
                String ln = rs.getString("n_lastname");
                String fn = rs.getString("n_firstname");
                String no = rs.getString("contact_no");

                System.out.println(nurseID + ", " + ln + ", " + fn + ", " + no);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
//        Nurse nurse = new Nurse("Marta", "Lualdi", "+63 9645138314");
        NurseManagement nurseMgmt = new NurseManagement();
//        nurseMgmt.registerNurse(nurse);
        nurseMgmt.viewNurseRecords();
    }
}
