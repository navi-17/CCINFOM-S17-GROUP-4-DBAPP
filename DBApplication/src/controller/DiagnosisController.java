package controller;
import jdk.jshell.Diag;
import model.Diagnosis;
import model.DiagnosisManagement;

import model.NurseAssignment;
import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class DiagnosisController implements ActionListener{
    private DiagnosisManagement diagnosisManagement;
    private ASGui asgui;

    public DiagnosisController(ASGui gui)
    {
        diagnosisManagement = new DiagnosisManagement();
        this.asgui = gui;
        asgui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getDiagnosisButton())
        {
            System.out.println("Diagnosis Button clicked!");
            List<Diagnosis> diagnoses = diagnosisManagement.viewPatientDiagnosis();
            Object[][] data = new Object[diagnoses.size()][7];
            for(int i = 0; i < diagnoses.size(); i++)
            {
                Diagnosis d = diagnoses.get(i);
                data[i][0] = false;
                data[i][1] = d.getDiagnosis_id();
                data[i][2] = d.getPatient_id();
                data[i][3] = d.getPhysicianSchedule_id();
                data[i][4] = d.getIllness_id();
                data[i][5] = d.getDiagnosis_id();
                data[i][6] = d.getNotes();
            }

            String[] attributes = {" ", "Diagnosis ID", "Patient ID", "Physician Schedule ID", "Illness ID", "Diagnosis Date", "Notes"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // nurse assignment ID
                    2, 194,  // nurse shift ID
                    3, 194,  //patient ID
                    4, 194, //date assigned
                    5, 194,//assigned until
                    6, 194
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
    }
}
