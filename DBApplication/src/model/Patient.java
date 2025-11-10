package model;

public class Patient {
    private int patient_id;
    private String p_lastname;
    private String p_firstname;
    private String contact_no;

    public Patient(String ln, String fn, String contact)
    {
        p_lastname = ln;
        p_firstname = fn;
        contact_no = contact;
    }

    public void setPatientID(int pID)
    {
        patient_id = pID;
    }

    public int getPatientID()
    {
        return patient_id;
    }

    public String getLastName()
    {
        return p_lastname;
    }

    public String getFirstName()
    {
        return p_firstname;
    }

    public String getContact()
    {
        return contact_no;
    }
}
