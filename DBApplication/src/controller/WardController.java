package controller;

import model.Ward;
import model.WardManagement;

import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class WardController implements ActionListener {
    private WardManagement wardManagement;
    private ASGui asgui;

    public WardController(ASGui gui)
    {
        wardManagement = new WardManagement();
        this.asgui = gui;
        gui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getWardButton())
        {
            asgui.setButtonValue(3);
            asgui.setCreateButtonText("Add Ward");
            asgui.setTableLabel("Ward Records");
            System.out.println("Ward Button clicked!");
            List<Ward> wards = wardManagement.viewWardRecords();
            Object[][] data = new Object[wards.size()][5];
            for(int i = 0; i < wards.size(); i++)
            {
                Ward w = wards.get(i);

                data[i][0] = false;
                data[i][1] = w.getWard_id();
                data[i][2] = w.getWardNo();
                data[i][3] = w.getFloor();
                data[i][4] = w.getStatus();
            }

            String[] attributes = {" ", "Ward ID", "Ward number", "Floor", "Status"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // ID
                    2, 323,  // Name
                    3, 323,  //contact
                    4, 323 //specialization
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			System.out.println("Delete Button clicked for Ward!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;

			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);
			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " ward record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					try {
						// Create a dummy Ward object just to pass the ID for deletion
						Ward wardToDelete = new Ward((int) id); 
						if (wardManagement.deleteWard(wardToDelete)) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting Ward ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " ward record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				asgui.getWardButton().doClick(); // Refresh
			}
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			JOptionPane.showMessageDialog(asgui, "Update functionality for Ward is not yet implemented.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
		}
    }
}
