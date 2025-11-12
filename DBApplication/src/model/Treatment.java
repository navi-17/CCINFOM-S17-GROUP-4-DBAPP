package model;

public class Treatment {
    private int treatment_id;
    private int nurseAssignment_id;
    private int diagnosis_id;
    private int medicine_id;
    private java.sql.Date treatment_date;
    private String treatment_procedure;
    private String remarks;
    private Integer assignedPhysician_id;
    private String performed_by;

    public Treatment(int naID, int dID, int mID, java.sql.Date date, String procedure, String remarks, Integer apID, String performedBy)
    {
        nurseAssignment_id = naID;
        diagnosis_id = dID;
        medicine_id = mID;
        treatment_date = date;
        treatment_procedure = procedure;
        this.remarks = remarks;
        assignedPhysician_id = apID;
        performed_by = performedBy;
    }

    public void setTreatmentID(int id)
    {
        treatment_id = id;
    }

    public void setAssignedPhysician_id(Integer id)
    {
        assignedPhysician_id = id;
    }

    public int getTreatmentID()
    {
        return treatment_id;
    }

    public int getNurseAssignment_id()
    {
        return nurseAssignment_id;
    }

    public int getDiagnosisID()
    {
        return diagnosis_id;
    }

    public int getMedicineID()
    {
        return medicine_id;
    }

    public java.sql.Date getTreatmentDate()
    {
        return treatment_date;
    }

    public String getProcedure()
    {
        return treatment_procedure;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public Integer getAssignedPhysician()
    {
        return assignedPhysician_id;
    }

    public String getPerformedBy()
    {
        return performed_by;
    }
}
