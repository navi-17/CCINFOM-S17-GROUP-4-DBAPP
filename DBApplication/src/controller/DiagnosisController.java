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
            asgui.setButtonValue(8);
            asgui.setCreateButtonText("Add Diagnosis");
            asgui.setTableLabel("Diagnosis Records");
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
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			System.out.println("Delete Button clicked for Diagnosis!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;

			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);
			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " diagnosis record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					try {
						// Assuming the delete method takes the ID (Integer)
						if (diagnosisManagement.deleteDiagnosisRecord((int) id)) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting Diagnosis ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " diagnosis record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				asgui.getDiagnosisButton().doClick(); // Refresh
			}
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			JOptionPane.showMessageDialog(asgui, "Update functionality for Diagnosis is not yet implemented.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
		}
    }
}
