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
    }



}
