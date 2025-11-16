package controller;

import model.Patient;
import model.PatientManagement;
import view.ASGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PatientController{
    private PatientManagement patientManagement; //model
    private ASGui asgui; //view

    public PatientController()
    {
        patientManagement = new PatientManagement();
        asgui = new ASGui();
    }

//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        if(e.getSource() == asgui.getPatientButton())
//        {
//            List<Patient> patients = patientManagement.viewPatientRecords();
//            JTable table = asgui.createPatientTable(patients);
//        }
//    }


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
