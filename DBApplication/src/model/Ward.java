package model;

public class Ward {
    private int ward_id;
    private String floor;

    public Ward(String floor){
        this.floor = floor;
    }

    public int getWard_id() {
        return ward_id;
    }

    public String getFloor() {
        return floor;
    }
}