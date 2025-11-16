package controller;
import model.*;
import view.ASGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

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

            asgui.createTable(data, attributes, 2, 0, -1, colWidths);
        }
        else if(e.getSource() == asgui.getnShiftButton())
        {
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

            asgui.createTable(data, attributes, -1, 0, -1, colWidths);
        }
    }
}
