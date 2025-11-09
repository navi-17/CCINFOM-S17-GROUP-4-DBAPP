package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PhysicianScheduleManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dbhospital";
    private static final String USER = "root";
    private static final String PASSWORD = "infom123";
    private Connection conn;
    PreparedStatement pstmt;

    public boolean createPhysicianSchedule(PhysicianSchedule ps)
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "INSERT INTO physician_schedule (physician_id, schedule_day, start_time, end_time) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, ps.getPhysicianID());
            pstmt.setString(2, ps.getDay());
            pstmt.setString(3, ps.getStartTime());
            pstmt.setString(4, ps.getEndTime());

            pstmt.executeUpdate();
            System.out.println("Physician Schedule Record inserted successfully!");

            pstmt.close();
            conn.close();
            return true;

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void viewNurseShifts()
    {
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connection to database successful!");

            String sql = "SELECT * FROM nurse_shift";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();// used for queries that returns result
            while(rs.next())
            {
                int nsID = rs.getInt("nurseShift_id");
                String nID = rs.getString("nurse_id");
                String sday = rs.getString("shift_day");
                String sTime = rs.getString("start_time");
                String eTime = rs.getString("end_time");

                System.out.println(nsID + ", " + nID + ", " + sday + ", " + sTime + ", " + eTime);
            }

            pstmt.close();
            rs.close();
            conn.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
