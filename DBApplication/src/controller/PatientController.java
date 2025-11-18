package controller;

import model.*;
import view.ASGui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class PatientController implements ActionListener{
    private PatientManagement patientManagement; //model
    private ASGui asgui; //view

    public PatientController(ASGui gui)
    {
        patientManagement = new PatientManagement();
        this.asgui = gui;
        asgui.setActionListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == asgui.getPatientButton())
        {
            asgui.showOnlyTabs("Patients", "Patient Related Records");
            asgui.setTableLabel("Patient Records");
            System.out.println("Patient Button clicked!");
            //---------Creating the table for viewing record
            List<Patient> patients = patientManagement.viewPatientRecords();
            Object[][] data = new Object[patients.size()][7];
            for(int i = 0; i < patients.size(); i++)
            {
                Patient p = patients.get(i);
                data[i][0] = false;
                data[i][1] = p.getPatientID();
                data[i][2] = new Object[]{ asgui.getProfileIcon(), p.getLastName() + ", " + p.getFirstName()};
                data[i][3] = p.getSex();
                data[i][4] = p.getBirthDate();
                data[i][5] = p.getContact();
                data[i][6] = p.getStatus();
            }

            String[] attributes = {" ", "ID", "Patient Name", "Sex", "Birthdate", "Contact Number",
                    "Status"};

            Map<Integer, Integer> colWidths = Map.of(
                    0, 106,  // checkbox
                    1, 150,  // ID
                    2, 260,  // Name
                    3, 120,  // Sex
                    4, 220,  // Birthdate
                    5, 220,  // Contact
                    6, 150  // Status
            ); //1226 total = 106 checkbox, 150 ID

            JTable patientTable = asgui.createTable(data, attributes, 2, 0, 6, colWidths);
            JScrollPane patientScrollPane = new JScrollPane(patientTable);

            int tabIndex = asgui.getTabIndex("Patients");
            if(tabIndex != -1) {
                asgui.getTabbedPane().setComponentAt(tabIndex, patientScrollPane);
                asgui.getTabbedPane().setSelectedIndex(tabIndex);
            } else {
                System.err.println("Tab 'Patient' not found!");
            }

        }
		else if(e.getSource() == asgui.getDeleteButton()) // DELETE LOGIC
        {
            System.out.println("Delete Button clicked for Patients!");
            // current table from the scroll pane
            JTable table = (JTable) asgui.getScrollPane().getViewport().getView();
            if (table == null) {
                JOptionPane.showMessageDialog(asgui, "No table data visible to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // get selected row IDs
            List<Object> selectedIDs = asgui.getSelectedRowIDs(table);

            if (selectedIDs.isEmpty()) {
                JOptionPane.showMessageDialog(asgui, "No rows selected for deletion.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(asgui, 
                "Are you sure you want to delete the selected " + selectedIDs.size() + " patient record(s)?", 
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                int deletedCount = 0;
                for (Object id : selectedIDs) {
                    try {
                        if (patientManagement.deletePatientRecord((int) id)) {
                            deletedCount++;
                        }
                    } catch (Exception ex) {
                        System.err.println("Error deleting patient ID " + id + ": " + ex.getMessage());
                    }
                }

                JOptionPane.showMessageDialog(asgui, deletedCount + " patient record(s) deleted successfully.", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);
                
                // refresh the table display
                asgui.getPatientButton().doClick();
            }
        }
    }


    public List<Patient> getAllPatients() {
        return patientManagement.viewPatientRecords();
    }

    public boolean addPatient(Patient patient) {
        return patientManagement.createPatientRecord(patient);
    }

    public boolean updatePatient(Patient patient) {
        return patientManagement.updatePatientRecord(patient);
    }

    public boolean deletePatient(int patientID) {
        return patientManagement.deletePatientRecord(patientID);
    }


    /**
     * Search patients by name or other criteria
     */
//    public List<Patient> searchPatients(String keyword) {
//        return patientManagement.searchPatients(keyword);
//    }
}
