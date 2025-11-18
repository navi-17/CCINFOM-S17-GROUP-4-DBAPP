package controller;
import model.PhysicianManagement;
import model.Physician;
import model.PhysicianSchedule;
import model.PhysicianScheduleManagement;

import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class PhysicianController implements ActionListener{
    private PhysicianManagement physicianManagement;
    private PhysicianScheduleManagement physicianScheduleManagement;
    private ASGui asgui;
    public PhysicianController(ASGui gui)
    {
        physicianManagement = new PhysicianManagement();
        physicianScheduleManagement = new PhysicianScheduleManagement();
        this.asgui = gui;
        gui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getPhysicianButton())
        {
            asgui.showOnlyTabs("Physician", "Physician Related Records");
            asgui.setTableLabel("Physician Records");
            System.out.println("Physician Button clicked!");
            List<Physician> physicians = physicianManagement.viewPhysicianRecords();
            Object[][] data = new Object[physicians.size()][5];
            for(int i = 0; i < physicians.size(); i++)
            {
                Physician p = physicians.get(i);

                data[i][0] = false;
                data[i][1] = p.getPhysicianID();
                data[i][2] = new Object[]{asgui.getProfileIcon(), p.getLastName() + ", " + p.getFirstName()};
                data[i][3] = p.getContact();
                data[i][4] = p.getSpecialization();
            }

            String[] attributes = {" ", "Physician ID", "Physician name", "Contact number", "Specialization"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // ID
                    2, 323,  // Name
                    3, 323,  //contact
                    4, 323 //specialization
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            JTable physicianTable = asgui.createTable(data, attributes, 2, 0, -1, colWidths);
            JScrollPane physicianScrollPane = new JScrollPane(physicianTable);

            int tabIndex = asgui.getTabIndex("Physician");
            if(tabIndex != -1) {
                asgui.getTabbedPane().setComponentAt(tabIndex, physicianScrollPane);
                asgui.getTabbedPane().setSelectedIndex(tabIndex);
            } else {
                System.err.println("Tab 'Physician' not found!");
            }
        }
        else if(e.getSource() == asgui.getpScheduleButton())
        {
            asgui.setTableLabel("Physician Schedule Records");
            System.out.println("Physician Schedule Button clicked!");
            List<PhysicianSchedule> schedules = physicianScheduleManagement.viewPhysicianSchedule();
            Object[][] data = new Object[schedules.size()][6];
            for(int i = 0; i < schedules.size(); i++)
            {
                PhysicianSchedule s = schedules.get(i);

                data[i][0] = false;
                data[i][1] = s.getPhysicianScheduleID();
                data[i][2] = s.getPhysicianID();
                data[i][3] = s.getDay();
                data[i][4] = s.getStartTime();
                data[i][5] = s.getEndTime();
            }

            String[] attributes = {" ", "PhysicianSchedule ID", "Physician ID", "Day", "Start time", "End time"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // ID
                    2, 242,  // Name
                    3, 242,
                    4, 242,
                    5, 242// Contact
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;
			
			String entityType = (table.getModel().getColumnCount() == 5) ? "Physician" : "Physician Schedule";
			System.out.println("Delete Button clicked for " + entityType + "!");
			
			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);
			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " " + entityType + " record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					int entityID = (int) id;
					boolean success = false;
					
					try {
						if (entityType.equals("Physician")) {
							success = physicianManagement.deletePhysicianRecord(entityID);
						} else if (entityType.equals("Physician Schedule")) {
							success = physicianScheduleManagement.deletePhysicianSchedule(entityID);
						}
						
						if (success) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting " + entityType + " ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " " + entityType + " record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				
				// Refresh the current table display
				if (entityType.equals("Physician")) {
					asgui.getPhysicianButton().doClick();
				} else {
					asgui.getpScheduleButton().doClick();
				}
			}
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			JOptionPane.showMessageDialog(asgui, "Update functionality for Physician is not yet implemented.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
		}
    }

}
