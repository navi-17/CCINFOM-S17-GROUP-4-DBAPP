package model;

public class NurseShift {
    private int nurseShift_id;
    private int nurse_id;
    private String shift_day;
    private String start_time;
    private String end_time;

    public NurseShift(int nurseID, String day, String start, String end)
    {
        nurse_id = nurseID;
        shift_day = day;
        start_time = start;
        end_time = end;
    }

    public void setNurseShiftID(int nsID)
    {
        nurseShift_id = nsID;
    }


    public int getNurseShiftID()
    {
        return nurseShift_id;
    }

    public int getNurseID()
    {
        return nurse_id;
    }

    public String getShiftDay()
    {
        return this.shift_day;
    }

    public String getStartTime()
    {
        return this.start_time;
    }

    public String getEndTime()
    {
        return this.end_time;
    }

}
