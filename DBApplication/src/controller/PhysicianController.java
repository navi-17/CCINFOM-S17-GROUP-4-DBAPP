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
            System.out.println("Physician Button clicked!");
            List<Physician> physicians = physicianManagement.viewPhysicianRecords();
            Object[][] data = new Object[physicians.size()][5];
            for(int i = 0; i < physicians.size(); i++)
            {
                Physician p = physicians.get(i);

                data[i][0] = false;
                data[i][1] = p.getPhysicianID();
                data[i][2] = new Object[]{ asgui.getProfileIcon(), p.getLastName() + ", " + p.getFirstName()};
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

            asgui.createTable(data, attributes, 2, 0, -1, colWidths);
        }
        else if(e.getSource() == asgui.getpScheduleButton())
        {
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
    }

}
