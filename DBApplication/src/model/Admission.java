package model;

public class Admission {
    private int admission_id;
    private int patient_id;
    private int ward_id;
    private String admission_date;

    public Admission(int pID, int wID, String date)
    {
        patient_id = pID;
        ward_id = wID;
        admission_date = date;
    }

    public void setAdmissionID(int id)
    {
        admission_id = id;
    }

    public int getAdmissionID()
    {
        return admission_id;
    }

    public int getPatientID()
    {
        return patient_id;
    }

    public int getWardID()
    {
        return ward_id;
    }

    public String getAdmissionDate()
    {
        return admission_date;
    }

}
