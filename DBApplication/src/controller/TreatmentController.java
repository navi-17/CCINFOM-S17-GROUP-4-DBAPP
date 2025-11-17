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
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			System.out.println("Delete Button clicked for Treatment!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;

			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);
			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " treatment record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					try {
						if (treatmentManagement.deleteTreatmentRecord((int) id)) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting Treatment ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " treatment record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				asgui.getTreatmentButton().doClick(); // Refresh
			}
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			JOptionPane.showMessageDialog(asgui, "Update functionality for Treatment is not yet implemented.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
		}
    }
}
