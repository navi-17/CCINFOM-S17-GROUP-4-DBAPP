package controller;
import model.NurseAssignment;
import model.NurseAssignmentManagement;

import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class NurseAssignmentController implements ActionListener{
    private NurseAssignmentManagement nurseAssignmentManagement;
    private ASGui asgui;

    public NurseAssignmentController(ASGui gui)
    {
        nurseAssignmentManagement = new NurseAssignmentManagement();
        this.asgui = gui;
        asgui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getnAssignmentButton())
        {
            System.out.println("Nurse Assignment Button clicked!");
            List<NurseAssignment> nurseAssignments = nurseAssignmentManagement.viewNurseAssignments();
            Object[][] data = new Object[nurseAssignments.size()][6];
            for(int i = 0; i < nurseAssignments.size(); i++)
            {
                NurseAssignment na = nurseAssignments.get(i);
                data[i][0] = false;
                data[i][1] = na.getNurseAssignmentID();
                data[i][2] = na.getNurseShiftID();
                data[i][3] = na.getPatientID();
                data[i][4] = na.getDateAssigned();
                data[i][5] = na.getAssignedUntil();
            }

            String[] attributes = {" ", "Nurse Assignment ID", "Nurse Shift ID", "Patient ID", "Date Assigned", "Assigned Until"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // nurse assignment ID
                    2, 242,  // nurse shift ID
                    3, 242,  //patient ID
                    4, 242, //date assigned
                    5, 242//assigned until
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
    }
}
