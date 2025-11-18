package controller;
import model.Treatment;
import model.TreatmentManagement;

import view.ASGui;
import view.UpdateTreatmentDialog;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.sql.Date;

public class TreatmentController implements ActionListener{
    private TreatmentManagement treatmentManagement;
    private ASGui asgui;

    public TreatmentController(ASGui gui)
    {
        treatmentManagement = new TreatmentManagement();
        this.asgui = gui;
        gui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getTreatmentButton())
        {
            asgui.setButtonValue(10);
            asgui.setCreateButtonText("Add Treatment");
            asgui.showOnlyTabs("Treatments");
            asgui.setTableLabel("Treatment Records");
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
                    0, 106, 1, 120, 2, 120, 3, 120, 4, 120, 5, 120, 6, 120, 7, 120, 8, 200, 9, 200
            );

            JTable treatmentTable = asgui.createTable(data, attributes, -1, 0, -1, colWidths);
            JScrollPane treatmentScrollPane = new JScrollPane(treatmentTable);

            int tabIndex = asgui.getTabIndex("Treatments");
            if(tabIndex != -1) {
                asgui.getTabbedPane().setComponentAt(tabIndex, treatmentScrollPane);
                asgui.getTabbedPane().setSelectedIndex(tabIndex);
            } else {
                System.err.println("Tab 'Treatments' not found!");
            }
        }
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			if (!asgui.getTableLabel().getText().equals("Treatment Records")) return;
			
			// ... (Delete logic) ...
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			if (!asgui.getTableLabel().getText().equals("Treatment Records")) return;
            
            //  IMPLEMENTED UPDATE LOGIC 
			System.out.println("Update Button clicked for Treatment!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;

			List<Object> selectedData = asgui.getSelectedRowData(table);

			if (selectedData != null) {
				if (table.getModel().getColumnCount() != 10) {
					JOptionPane.showMessageDialog(asgui, "Update function available only for Treatment Records view.", "Update Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				try {
					// Extract data: [0:Chk] [1:T ID] [2:NA ID] [3:D ID] [4:M ID] [5:AP ID] [6:Perf By] [7:Date] [8:Proc] [9:Remarks]
					int treatmentID = (int) selectedData.get(1);
					int nurseAssignmentID = Integer.parseInt(selectedData.get(2).toString());
					int diagnosisID = Integer.parseInt(selectedData.get(3).toString());
					int medicineID = Integer.parseInt(selectedData.get(4).toString());
					
                    // Handle Optional Assigned Physician ID (AP ID)
					Integer assignedPhysicianID = null;
                    if (selectedData.get(5) != null && selectedData.get(5).toString().trim().length() > 0) {
                        // Check if the column is a non-null integer.
                        try {
                            assignedPhysicianID = Integer.parseInt(selectedData.get(5).toString());
                        } catch (NumberFormatException nfe) {
                            // If it fails parsing (e.g., empty string or non-numeric), keep it null
                            assignedPhysicianID = null;
                        }
                    }

                    String performedBy = (String) selectedData.get(6);
                    Date treatmentDate = Date.valueOf(selectedData.get(7).toString());
                    String procedure = (String) selectedData.get(8);
                    String remarks = (String) selectedData.get(9);
					
					// Create Treatment object
					Treatment selectedTreatment = new Treatment(nurseAssignmentID, diagnosisID, medicineID, treatmentDate, procedure, remarks, assignedPhysicianID, performedBy);
					selectedTreatment.setTreatmentID(treatmentID);
					
					// Open the Update Dialog
					UpdateTreatmentDialog updateDialog = new UpdateTreatmentDialog(asgui, selectedTreatment);
					updateDialog.setVisible(true);

					// Refresh the table
					asgui.getTreatmentButton().doClick();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(asgui, "Error processing selected Treatment data.", "Data Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		}
    }
}