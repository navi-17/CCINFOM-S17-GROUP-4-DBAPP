package controller;
import model.Illness;
import model.IllnessManagement;


import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class IllnessController implements ActionListener {
    private IllnessManagement illnessManagement;
    private ASGui asgui;

    public IllnessController(ASGui gui)
    {
        illnessManagement = new IllnessManagement();
        this.asgui = gui;
        gui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getAilmentButton())
        {
            asgui.setButtonValue(5);
            asgui.setCreateButtonText("Add Illness");
            asgui.setTableLabel("Illness Records");
            System.out.println("Ailment Button clicked!");
            List<Illness> illnesses = illnessManagement.viewIllnessRecords();
            Object[][] data = new Object[illnesses.size()][5];
            for(int i = 0; i < illnesses.size(); i++)
            {
                Illness ill = illnesses.get(i);

                data[i][0] = false;
                data[i][1] = ill.getIllness_id();
                data[i][2] = ill.getIllness_name();
                data[i][3] = ill.getCategory();
                data[i][4] = ill.getIllness_description();
            }

            String[] attributes = {" ", "Illness ID", "Illness name", "Category", "Description"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // ID
                    2, 323,  // Name
                    3, 323,  //Category
                    4, 323 //Description
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			System.out.println("Delete Button clicked for Ailment!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;

			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);
			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " ailment record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					try {
						// Create a dummy Illness object just to pass the ID for deletion
						Illness illnessToDelete = new Illness((int) id); 
						if (illnessManagement.deleteIllness(illnessToDelete)) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting Illness ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " ailment record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				asgui.getAilmentButton().doClick(); // Refresh
			}
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			JOptionPane.showMessageDialog(asgui, "Update functionality for Ailment is not yet implemented.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
		}
    }
}

