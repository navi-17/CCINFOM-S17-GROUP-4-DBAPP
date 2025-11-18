package controller;
import model.Admission;
import model.AdmissionManagement;


import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;


public class AdmissionController implements ActionListener{
    private AdmissionManagement admissionManagement;
    private ASGui asgui;

    public AdmissionController(ASGui gui)
    {
        admissionManagement = new AdmissionManagement();
        this.asgui = gui;
        gui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getAdmissionButton())
        {
            asgui.setButtonValue(6);
            asgui.setCreateButtonText("Add Admission");
            asgui.setTableLabel("Admission Records");
            System.out.println("Admission Button clicked!");
            List<Admission> admissions = admissionManagement.viewPatientAdmission();
            Object[][] data = new Object[admissions.size()][5];
            for(int i = 0; i < admissions.size(); i++)
            {
                Admission a = admissions.get(i);
                data[i][0] = false;
                data[i][1] = a.getAdmissionID();
                data[i][2] = a.getPatientID();
                data[i][3] = a.getWardID();
                data[i][4] = a.getAdmissionDate();
            }

            String[] attributes = {" ", "Admission ID", "Patient ID", "Ward ID", "Admission Date"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // Admission ID
                    2, 323,  // Patient ID
                    3, 323,  //Ward ID
                    4, 323 //Date
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
    }


}
