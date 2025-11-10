package model;

public class Discharge {
    private int discharge_id;
    private int admission_id;
    private String discharge_date;

    public Discharge(int discharge_id, int admission_id, String discharge_date) {
        this.discharge_id = discharge_id;
        this.admission_id = admission_id;
        this.discharge_date = discharge_date;
    }

    public int getDischarge_id() {
        return discharge_id;
    }

    public void setDischarge_id(int discharge_id) {
        this.discharge_id = discharge_id;
    }

    public int getAdmission_id() {
        return admission_id;
    }

    public String getDischarge_date() {
        return discharge_date;
    }
}
