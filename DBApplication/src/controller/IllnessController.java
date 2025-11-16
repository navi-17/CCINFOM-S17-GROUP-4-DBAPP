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
    }
}

