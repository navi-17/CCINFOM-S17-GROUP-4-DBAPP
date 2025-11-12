package model;

public class Diagnosis {
    private int diagnosis_id;
    private int physicianSchedule_id;
    private int patient_id;
    private int illness_id;
    private java.sql.Date diagnosis_date;
    private String notes;

    public Diagnosis(int phySchedID, int pID, int illID, java.sql.Date diagnosis_date, String notes) {
        this.physicianSchedule_id = phySchedID;
        this.patient_id = pID;
        this.illness_id = illID;
        this.diagnosis_date = diagnosis_date;
        this.notes = notes;
    }

    public void setDiagnosis_id(int diagnosis_id) {
        this.diagnosis_id = diagnosis_id;
    }

    public int getDiagnosis_id() {
        return diagnosis_id;
    }

    public int getPhysicianSchedule_id() {
        return physicianSchedule_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getIllness_id() {
        return illness_id;
    }

    public java.sql.Date getDiagnosis_date() {
        return diagnosis_date;
    }

    public String getNotes() {
        return notes;
    }
}
