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
            asgui.setButtonValue(9);
            asgui.setCreateButtonText("Add Assignment");
            asgui.showOnlyTabs("Nurse Assignments");
            asgui.setTableLabel("Nurse Assignment Records");
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

            JTable nurseAssignmentTable = asgui.createTable(data, attributes, -1, 0, -1, colWidths);
            JScrollPane nurseAssignmentScrollPane = new JScrollPane(nurseAssignmentTable);

            int tabIndex = asgui.getTabIndex("Nurse Assignments");
            if(tabIndex != -1) {
                asgui.getTabbedPane().setComponentAt(tabIndex, nurseAssignmentScrollPane);
                asgui.getTabbedPane().setSelectedIndex(tabIndex);
            } else {
                System.err.println("Tab 'Nurse Assignments' not found!");
            }
        }
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			System.out.println("Delete Button clicked for Nurse Assignment!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;

			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);
			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " nurse assignment record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					try {
						if (nurseAssignmentManagement.deleteNurseAssignment((int) id)) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting Nurse Assignment ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " nurse assignment record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				asgui.getnAssignmentButton().doClick(); // Refresh
			}
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			JOptionPane.showMessageDialog(asgui, "Update functionality for Nurse Assignment is not yet implemented.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
		}
    }
}
