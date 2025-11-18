package controller;
import model.*;
import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import view.UpdateNurseDialog;

public class NurseController implements ActionListener{
    private NurseManagement nurseManagement;
    private NurseShiftManagement nurseShiftManagement;
    private ASGui asgui; //view

    public NurseController(ASGui gui)
    {
        nurseManagement = new NurseManagement();
        nurseShiftManagement = new NurseShiftManagement();
        this.asgui = gui;
        gui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getNurseButton())
        {
            asgui.setButtonValue(2);
            asgui.setCreateButtonText("Add Nurse");
            asgui.showOnlyTabs("Nurse", "Nurse Related Records");
            asgui.setTableLabel("Nurse Records");
            System.out.println("Nurse Button clicked!");
            List<Nurse> nurses = nurseManagement.viewNurseRecords();
            Object[][] data = new Object[nurses.size()][4];
            for(int i = 0; i < nurses.size(); i++)
            {
                Nurse n = nurses.get(i);

                data[i][0] = false;
                data[i][1] = n.getNurseID();
                data[i][2] = new Object[]{ asgui.getProfileIcon(), n.getLastName() + ", " + n.getFirstName()};
                data[i][3] = n.getContactNo();
            }

            String[] attributes = {" ", "Nurse ID", "Nurse name", "Contact number"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 373,  // ID
                    2, 373,  // Name
                    3, 373  // Contact
            ); //1226 total: (1226-106) / 3 attributes =

            JTable nurseTable = asgui.createTable(data, attributes, 2, 0, -1, colWidths);
            JScrollPane nurseScrollPane = new JScrollPane(nurseTable);

            int tabIndex = asgui.getTabIndex("Nurse");
            if(tabIndex != -1) {
                asgui.getTabbedPane().setComponentAt(tabIndex, nurseScrollPane);
                asgui.getTabbedPane().setSelectedIndex(tabIndex);
            } else {
                System.err.println("Tab 'Physician' not found!");
            }
        }
        else if(e.getSource() == asgui.getnShiftButton())
        {
            asgui.setButtonValue(12);
            asgui.setCreateButtonText("Add Nurse Shift");
            asgui.showOnlyTabs("Nurse Shifts");
            asgui.setTableLabel("Nurse Shift Records");
            System.out.println("NurseShift Button clicked!");
            List<NurseShift> nurseShifts = nurseShiftManagement.viewNurseShifts();
            Object[][] data = new Object[nurseShifts.size()][6];
            for(int i = 0; i < nurseShifts.size(); i++)
            {
                NurseShift ns = nurseShifts.get(i);

                data[i][0] = false;
                data[i][1] = ns.getNurseShiftID();
                data[i][2] = ns.getNurseID();
                data[i][3] = ns.getShiftDay();
                data[i][4] = ns.getStartTime();
                data[i][5] = ns.getEndTime();
            }

            String[] attributes = {" ", "NurseShift ID", "Nurse ID", "Day", "Start time", "End time"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // ID
                    2, 242,
                    3, 242,
                    4, 242,
                    5, 242
            ); //1226 total: (1226-106) / 3 attributes =

            JTable nurseShiftTable = asgui.createTable(data, attributes, 2, 0, -1, colWidths);
            JScrollPane nurseShiftScrollPane = new JScrollPane(nurseShiftTable);

            int tabIndex = asgui.getTabIndex("Nurse Shifts");
            if(tabIndex != -1) {
                asgui.getTabbedPane().setComponentAt(tabIndex, nurseShiftScrollPane);
                asgui.getTabbedPane().setSelectedIndex(tabIndex);
            } else {
                System.err.println("Tab 'Nurse Shifts' not found!");
            }
        }
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			System.out.println("Delete Button clicked for Nurses!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) {
				JOptionPane.showMessageDialog(asgui, "No table data visible to delete.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);

			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " nurse record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					try {
						if (nurseManagement.deleteNurseRecord((int) id)) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting nurse ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " nurse record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				
				// Refresh the table display
				asgui.getNurseButton().doClick();
			}
		}
        else if(e.getSource() == asgui.getUpdateButton())
        {
            JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
            if (table == null) return;

            List<Object> selectedData = asgui.getSelectedRowData(table);

            if (selectedData != null) {
                // Check if the current table is the Nurse table (column count 4)
                if (table.getModel().getColumnCount() != 4) {
                    JOptionPane.showMessageDialog(asgui, "Update is only supported for Nurse records on this page.", "Update Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    int nurseID = (int) selectedData.get(1); // Column 1 is ID
                    Object[] nameObj = (Object[]) selectedData.get(2); // Column 2 is {ImageIcon, "LastName, FirstName"}
                    String fullName = (String) nameObj[1];
                    String[] names = fullName.split(", ");
                    String lastName = names[0];
                    String firstName = names.length > 1 ? names[1] : "";
                    String contact = (String) selectedData.get(3);
                    
                    Nurse selectedNurse = new Nurse(lastName, firstName, contact);
                    selectedNurse.setNurse_id(nurseID); 

                    // Open the Update Dialog
                    UpdateNurseDialog updateDialog = new UpdateNurseDialog(asgui, selectedNurse);
                    updateDialog.setVisible(true);

                    // After the dialog closes, refresh the table
                    asgui.getNurseButton().doClick();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(asgui, "Error processing selected Nurse data: " + ex.getMessage(), "Data Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        }
    }
}
