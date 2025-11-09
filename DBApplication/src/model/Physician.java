package model;

public class Physician {
    private int physician_id;
    private String ph_firstname;
    private String ph_lastname;
    private String contact_no;
    private String specialization;

    public Physician(String fn, String ln, String contact, String specialization)
    {
        ph_firstname = fn;
        ph_lastname = ln;
        contact_no = contact;
        this.specialization = specialization;
    }

    public void setPhysician_id(int id)
    {
        physician_id = id;
    }

    public int getPhysicianID()
    {
        return physician_id;
    }

    public String getFirstName()
    {
        return ph_firstname;
    }

    public String getLastName()
    {
        return ph_lastname;
    }

    public String getContact()
    {
        return contact_no;
    }

    public String getSpecialization()
    {
        return specialization;
    }
}
