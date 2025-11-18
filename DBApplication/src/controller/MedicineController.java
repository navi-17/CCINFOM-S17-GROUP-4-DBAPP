package controller;
import model.Medicine;
import model.MedicineManagement;

import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class MedicineController implements ActionListener{
    private MedicineManagement medicineManagement;
    private ASGui asgui;

    public MedicineController(ASGui gui)
    {
        medicineManagement = new MedicineManagement();
        this.asgui = gui;
        gui.setActionListeners(this);
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getMedicineButton())
        {
            asgui.setButtonValue(4);
            asgui.setCreateButtonText("Add Medicine");
            asgui.showOnlyTabs("Medicines", "Medicine Related Records");
            asgui.setTableLabel("Medicine Records");
            System.out.println("Medicine button clicked!");
            List<Medicine> medicines = medicineManagement.viewMedicineRecord();
            Object[][] data = new Object[medicines.size()][4];
            for(int i = 0; i < medicines.size(); i++)
            {
                Medicine m = medicines.get(i);

                data[i][0] = false;
                data[i][1] = m.getMedicineID();
                data[i][2] = m.getMedicineName();
                data[i][3] = m.getStockQty();
            }

            String[] attributes = {" ", "Medicine ID", "Medicine name", "Stock_qty"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 373,  // ID
                    2, 373,  // Name
                    3, 373  //stock
            ); //1226 total = 106 checkbox, 150 ID, 970 left

            JTable medicineTable = asgui.createTable(data, attributes, -1, 0, -1, colWidths);
            JScrollPane medicineScrollPane = new JScrollPane(medicineTable);

            int tabIndex = asgui.getTabIndex("Medicines");
            if(tabIndex != -1) {
                asgui.getTabbedPane().setComponentAt(tabIndex, medicineScrollPane);
                asgui.getTabbedPane().setSelectedIndex(tabIndex);
            } else {
                System.err.println("Tab 'Medicines' not found!");
            }
        }
		else if(e.getSource() == asgui.getDeleteButton()) 
		{
			System.out.println("Delete Button clicked for Medicine!");
			JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
			if (table == null) return;

			List<Object> selectedIDs = asgui.getSelectedRowIDs(table);
			if (selectedIDs.isEmpty()) {
				JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
				return;
			}

			int confirm = JOptionPane.showConfirmDialog(asgui, 
				"Are you sure you want to delete the selected " + selectedIDs.size() + " medicine record(s)?", 
				"Confirm Deletion", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				int deletedCount = 0;
				for (Object id : selectedIDs) {
					try {
						// Assuming the delete method takes the ID (Integer)
						if (medicineManagement.deleteMedicineRecord((int) id)) {
							deletedCount++;
						}
					} catch (Exception ex) {
						System.err.println("Error deleting Medicine ID " + id + ": " + ex.getMessage());
					}
				}

				JOptionPane.showMessageDialog(asgui, deletedCount + " medicine record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
				asgui.getMedicineButton().doClick(); // Refresh
			}
		}
		else if(e.getSource() == asgui.getUpdateButton()) 
		{
			JOptionPane.showMessageDialog(asgui, "Update functionality for Medicine is not yet implemented.", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
		}
    }
}
