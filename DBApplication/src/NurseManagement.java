import java.util.*;
import java.sql.*;

class Nurse{
    private int nurse_id;
    private String n_lastname;
    private String n_firstname;
    private String contact_no;

    public Nurse(String ln, String fn, String contact_no)
    {
        n_lastname = ln;
        n_firstname = fn;
        this.contact_no = contact_no;
    }

    public int getNurseID()
    {
        return nurse_id;
    }

    public String getLastName()
    {
        return n_lastname;
    }

    public String getFirstName()
    {
        return n_firstname;
    }

    public  String getContactNo()
    {
        return contact_no;
    }

}

public class NurseManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";

    public boolean registerNurse(Nurse nurse) //create
    {
        try{
            //This is where we will put codes that will interact w/ database
            //1. connect to database
            Connection conn;
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            //2. Prepare SQL Statement --> store in PreparedStatement (dont forget to put alias for column name so u can fetch the value)
            String sql = "INSERT INTO nurse (n_lastname, n_firstname, contact_no) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

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

    public static void main(String[] args){
        Nurse nurse = new Nurse("Marta", "Lualdi", "+63 9645138314");
        NurseManagement nurseMgmt = new NurseManagement();
        nurseMgmt.registerNurse(nurse);
    }
}
