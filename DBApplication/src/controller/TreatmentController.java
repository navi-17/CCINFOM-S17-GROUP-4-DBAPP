package controller;
import model.Treatment;
import model.TreatmentManagement;

import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class TreatmentController implements ActionListener{
    private TreatmentManagement treatmentManagement;
    private ASGui asgui;

    public TreatmentController(ASGui gui)
    {
        treatmentManagement = new TreatmentManagement();
        this.asgui = gui;
        asgui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getTreatmentButton())
        {
            System.out.println("Treatment Button clicked!");
            List<Treatment> treatments = treatmentManagement.viewTreatmentRecords();
            Object[][] data = new Object[treatments.size()][10];
            for(int i = 0; i < treatments.size(); i++)
            {
                Treatment t = treatments.get(i);
                data[i][0] = false;
                data[i][1] = t.getTreatmentID();
                data[i][2] = t.getNurseAssignment_id();
                data[i][3] = t.getDiagnosisID();
                data[i][4] = t.getMedicineID();
                data[i][5] = t.getAssignedPhysician();
                data[i][6] = t.getPerformedBy();
                data[i][7] = t.getTreatmentDate();
                data[i][8] = t.getProcedure();
                data[i][9] = t.getRemarks();
            }

            String[] attributes = {" ", "Treatment ID", "Nurse Assignment ID", "Diagnosis ID", "Medicine ID", "AP ID", "Performed by", "Treatment Date", "Treatment Procedure", "Remarks"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 120,  // Admission ID
                    2, 120,  // Patient ID
                    3, 120,  //Ward ID
                    4, 120,
                    5, 120,
                    6, 120,
                    7, 120,
                    8, 200,
                    9, 200

            ); //1226 total = 106 checkbox, 150 ID, 970 left

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
    }
}
