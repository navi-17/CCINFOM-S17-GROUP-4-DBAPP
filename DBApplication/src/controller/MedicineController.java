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
            System.out.println("Ailment Button clicked!");
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

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);

        }
    }
}
