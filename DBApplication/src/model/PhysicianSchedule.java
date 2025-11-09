package model;

public class PhysicianSchedule {
    private int physicianSchedule_id;
    private int physician_id;
    private String schedule_day;
    private String start_time;
    private String end_time;

    public PhysicianSchedule(int physicianID, String day, String start, String end)
    {
        physician_id = physicianID;
        schedule_day = day;
        start_time = start;
        end_time = end;
    }

    public void setPhysicianID(int phID)
    {
        physician_id = phID;
    }

    public int getPhysicianScheduleID()
    {
        return physicianSchedule_id;
    }

    public int getPhysicianID()
    {
        return physician_id;
    }

    public String getDay()
    {
        return schedule_day;
    }

    public String getStartTime()
    {
        return start_time;
    }

    public String getEndTime()
    {
        return end_time;
    }
}
