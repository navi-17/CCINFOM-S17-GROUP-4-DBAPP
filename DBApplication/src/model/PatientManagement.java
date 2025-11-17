package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital_final";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createPatientRecord(Patient patient)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "INSERT INTO patient (p_lastname, p_firstname, birth_date, contact_no, sex, p_status) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, patient.getLastName());
            pstmt.setString(2, patient.getFirstName());
            pstmt.setString(3, patient.getBirthDate());
            pstmt.setString(4, patient.getContact());
            pstmt.setString(5, patient.getSex());
            pstmt.setString(6, patient.getStatus());

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

    public List<Patient> viewPatientRecords() //READ
    {
        List<Patient> patients = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM patient";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result
            while(rs.next())
            {
                Patient p = new Patient(rs.getInt("patient_id"));
                p.setLastName(rs.getString("p_lastname"));
                p.setFirstName(rs.getString("p_firstname"));
                p.setBirthDate(rs.getString("birth_date"));
                p.setContact(rs.getString("contact_no"));
                p.setSex(rs.getString("sex"));
                p.setStatus(rs.getString("p_status"));
                patients.add(p);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return patients;
    }

    public boolean updatePatientRecord(Patient patient)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "UPDATE patient SET p_lastname = ?, p_firstname = ?, birth_date = ?, contact_no = ?, sex = ?, status = ? WHERE patient_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, patient.getLastName());
            pstmt.setString(2, patient.getFirstName());
            pstmt.setString(3, patient.getBirthDate());
            pstmt.setString(4, patient.getContact());
            pstmt.setString(5, patient.getSex());
            pstmt.setString(6, patient.getStatus());
            pstmt.setInt(7, patient.getPatientID());

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
        Patient p = new Patient("Yeager","Eren", "2000-01-01","+63 9184398952", "Male", "Pending");
        PatientManagement pm = new PatientManagement();

//        Patient updateP = new Patient("Braun", "Reiner", "+63 9184398951");
//        updateP.setPatientID(102);
//        pm.createPatientRecord(p);
//        pm.updatePatientRecord(updateP);
//        pm.deletePatientRecord(updateP.getPatientID());
        List<Patient> patients = new ArrayList<>();
        patients = pm.viewPatientRecords();

        for(Patient pt : patients)
        {
            System.out.println(pt.getPatientID() + ", " + pt.getLastName());
        }
    }
}
