package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicineManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createMedicineRecord(Medicine medicine)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "INSERT INTO medicine (medicine_name, stock_qty) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, medicine.getMedicineName());
            pstmt.setInt(2, medicine.getStockQty());


            pstmt.executeUpdate();
            System.out.println("Medicine Record inserted successfully!");

            pstmt.close();
            conn.close();
            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewMedicineRecord()
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM medicine";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result
            while(rs.next())
            {
                int mID = rs.getInt("medicine_id");
                String mName = rs.getString("medicine_name");
                int stock = rs.getInt("stock_qty");

                System.out.println(mID + ", " + mName + ", " + stock);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean updateMedicineRecord(Medicine medicine)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE medicine SET medicine_name = ?, stock_qty = ? WHERE medicine_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, medicine.getMedicineName());
            pstmt.setInt(2, medicine.getStockQty());
            pstmt.setInt(3,medicine.getMedicineID());


            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected > 0)
            {
                System.out.println("\n Medicine with id = " + medicine.getMedicineID() + " has been updated!");
                pstmt.close();
                conn.close();
                return true;
            }
            else
            {
                System.out.println("Nurse record update failed.");
                pstmt.close();
                conn.close();
                return false;
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteMedicineRecord(int medicineID) //DELETE
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "DELETE FROM medicine WHERE medicine_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, medicineID);

            int rowsAffected = pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            if(rowsAffected > 0)
            {
                System.out.println("Medicine with id = " + medicineID + " deleted successfully!");
                return true;
            }
            else
            {
                System.out.println("Medicine deletion failed");
                return false;
            }

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }





    public static void main(String[] args)
    {
        Medicine medicine = new Medicine("Biogesic", 50);
        MedicineManagement mm = new MedicineManagement();

        Medicine updatedMed = new Medicine("Paracetamol", 100);
        updatedMed.setMedicineID(4002);

//        mm.createMedicineRecord(medicine);
//        mm.updateMedicineRecord(updatedMed);
//        mm.deleteMedicineRecord(4002);
        mm.viewMedicineRecord();
    }
}


