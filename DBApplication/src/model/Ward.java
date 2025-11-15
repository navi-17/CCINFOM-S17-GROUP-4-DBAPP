package model;

public class Ward {
        private int ward_id;
        private String floor;
        private int ward_no;
        private String ward_status;

        public Ward(String floor, int wn){
            this.floor = floor;
            ward_no = wn;
        }

        public void setWard_id(int id)
        {
            ward_id = id;
        }

        public int getWard_id() {
            return ward_id;
        }

        public String getFloor() {
            return floor;
        }

        public int getWardNo()
        {
            return ward_no;
        }

        public String getStatus()
        {
            return ward_status;
        }



    }
