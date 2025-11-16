package controller;

import model.*;
import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class PatientController implements ActionListener{
    private PatientManagement patientManagement; //model
    private ASGui asgui; //view

    public PatientController(ASGui gui)
    {
        patientManagement = new PatientManagement();
        this.asgui = gui;
        asgui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getPatientButton())
        {
            System.out.println("Patient Button clicked!");
            List<Patient> patients = patientManagement.viewPatientRecords();
            Object[][] data = new Object[patients.size()][7];
            for(int i = 0; i < patients.size(); i++)
            {
                Patient p = patients.get(i);

                data[i][0] = false;
                data[i][1] = p.getPatientID();
                data[i][2] = new Object[]{ asgui.getProfileIcon(), p.getLastName() + ", " + p.getFirstName()};
                data[i][3] = p.getSex();
                data[i][4] = p.getBirthDate();
                data[i][5] = p.getContact();
                data[i][6] = p.getStatus();
            }

            String[] attributes = {" ", "ID", "Patient Name", "Sex", "Birthdate", "Contact Number",
                    "Status"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // ID
                    2, 260,  // Name
                    3, 120,  // Sex
                    4, 220,  // Birthdate
                    5, 220,  // Contact
                    6, 150  // Status
            ); //1226 total = 106 checkbox, 150 ID

            asgui.createTable(data, attributes, 2, 0, 6, colWidths);
        }

    }


    public List<Patient> getAllPatients() {
        return patientManagement.viewPatientRecords();
    }

    public boolean addPatient(Patient patient) {
        return patientManagement.createPatientRecord(patient);
    }

    public boolean updatePatient(Patient patient) {
        return patientManagement.updatePatientRecord(patient);
    }

    public boolean deletePatient(int patientID) {
        return patientManagement.deletePatientRecord(patientID);
    }


    /**
     * Search patients by name or other criteria
     */
//    public List<Patient> searchPatients(String keyword) {
//        return patientManagement.searchPatients(keyword);
//    }
}
