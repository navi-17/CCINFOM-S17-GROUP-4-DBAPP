//package view;
//import java.util.*;
//import java.io.*;
//import java.awt.*;
//import java.awt.image.*;
//import javax.swing.*;
//import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.table.JTableHeader;
//import javax.swing.table.TableColumn;
//
//public class ASGui1 extends JFrame{
//
//    private Dimension screenSize;
//    private int screenWidth;
//    private int screenHeight;
//    private int mainWidth;
//    private int sideWidth;
//    private String placeholder = "Search...";
//
//    private JLayeredPane wholeScreen;
//    private JLayeredPane mainPanel;
//    private JLayeredPane sidePanel;
//    private JPanel topPanel;
//    private JPanel topPanel2;
//    private JPanel listBGPanel;
//    private JPanel listPanel[] = new JPanel[11];
//    private JPanel listAttributesPanel;
//
//    private JLabel logoLabel;
//    private JLabel mainMenuLabel;
//    private JLabel transactionsLabel;
//    private JLabel recordsLabel;
//    private JLabel patientListLabel;
//    private JLabel profileLabel;
//    private JLabel profileNameLabel;
//    private JLabel profileJobLabel;
//    private JLabel pathLabel;
//    private JLabel searchBarLabel;
//    private JLabel searchTextLabel;
//    private JLabel sortByLabel;
//    private JLabel sortByTextLabel;
//    private JLabel entriesLabel;
//    private JLabel backgroundLabel;
//    private JLabel backgroundLabel2;
//
//    private JButton dashboardButton;
//    private JButton patientButton;
//    private JButton physicianButton;
//    private JButton nurseButton;
//    private JButton wardButton;
//    private JButton medicineButton;
//    private JButton ailmentButton;
//
//    private JButton admissionButton;
//    private JButton dischargeButton;
//    private JButton pAssignmentButton;
//    private JButton nAssignmentButton;
//    private JButton treatmentButton;
//    private JButton recordsButton;
//
//    private JButton settingsButton;
//    private JButton notificationButton;
//    private JButton searchButton;
//    private JButton cancelButton;
//    private JButton dropdownButton;
//    private JButton dropdownButton2;
//    private JButton filterByButton;
//    private JButton listViewButton;
//    private JButton tileViewButton;
//    private JButton createButton;
//    private JButton updateButton;
//    private JButton deleteButton;
//
//    private JButton previousPageButton;
//    private JButton firstPageButton;
//    private JButton secondPageButton;
//    private JButton thirdPageButton;
//    private JButton fourthPageButton;
//    private JButton lastPageButton;
//    private JButton nextPageButton;
//
//    JTextField searchTextField;
//
//    private ImageIcon backgroundImage = new ImageIcon("backgroundImage.png");
//    private ImageIcon logoImage = new ImageIcon("globeIcon.png");
//    private ImageIcon houseIcon = new ImageIcon("houseIcon.png");
//    private ImageIcon personIcon = new ImageIcon("personIcon.png");
//    private ImageIcon profileIcon = new ImageIcon("profileIcon.png");
//    private ImageIcon settingsIcon = new ImageIcon("settingsIcon.png");
//    private ImageIcon bellIcon = new ImageIcon("bellIcon.png");
//    private ImageIcon dropdownIcon = new ImageIcon("dropdownIcon.png");
//    private ImageIcon dropdownIcon2 = new ImageIcon("dropdownIcon2.png");
//    private ImageIcon searchIcon = new ImageIcon("searchIcon.png");
//    private ImageIcon cancelIcon = new ImageIcon("cancelIcon.png");
//
//    private Font RobotoRegular;
//    private Font RobotoBold;
//    private Font MontserratBold;//package view;
////
////import controller.PatientController;
////import model.Patient;
////
////import java.io.*;
////import java.awt.*;
////import javax.swing.*;
////import javax.swing.table.DefaultTableCellRenderer;
////import javax.swing.table.JTableHeader;
////import javax.swing.table.TableColumn;
////import java.util.List;
////
////public class ASGui extends JFrame{
////    private PatientController patientController;
////    private Dimension screenSize;
////    private int screenWidth;
////    private int screenHeight;
////    private int mainWidth;
////    private int sideWidth;
////    private String placeholder = "Search...";
////
////    private JLayeredPane wholeScreen;
////    private JLayeredPane mainPanel;
////    private JLayeredPane sidePanel;
////    private JPanel topPanel;
////    private JPanel topPanel2;
////    private JPanel listBGPanel;
////    private JPanel listPanel[] = new JPanel[11];
////    private JPanel listAttributesPanel;
////
////    private JLabel logoLabel;
////    private JLabel mainMenuLabel;
////    private JLabel transactionsLabel;
////    private JLabel recordsLabel;
////    private JLabel patientListLabel;
////    private JLabel profileLabel;
////    private JLabel profileNameLabel;
////    private JLabel profileJobLabel;
////    private JLabel pathLabel;
////    private JLabel searchBarLabel;
////    private JLabel searchTextLabel;
////    private JLabel sortByLabel;
////    private JLabel sortByTextLabel;
////    private JLabel entriesLabel;
////    private JLabel backgroundLabel;
////    private JLabel backgroundLabel2;
////
////    private JButton dashboardButton;
////    private JButton patientButton;
////    private JButton physicianButton;
////    private JButton nurseButton;
////    private JButton wardButton;
////    private JButton medicineButton;
////    private JButton ailmentButton;
////
////    private JButton admissionButton;
////    private JButton dischargeButton;
////    private JButton pAssignmentButton;
////    private JButton nAssignmentButton;
////    private JButton treatmentButton;
////    private JButton recordsButton;
////
////    private JButton settingsButton;
////    private JButton notificationButton;
////    private JButton searchButton;
////    private JButton cancelButton;
////    private JButton dropdownButton;
////    private JButton dropdownButton2;
////    private JButton filterByButton;
////    private JButton listViewButton;
////    private JButton tileViewButton;
////    private JButton createButton;
////    private JButton updateButton;
////    private JButton deleteButton;
////
////    private JButton previousPageButton;
////    private JButton firstPageButton;
////    private JButton secondPageButton;
////    private JButton thirdPageButton;
////    private JButton fourthPageButton;
////    private JButton lastPageButton;
////    private JButton nextPageButton;
////
////    JTextField searchTextField;
////
////    private ImageIcon backgroundImage = new ImageIcon("backgroundImage.png");
////    private ImageIcon logoImage = new ImageIcon("globeIcon.png");
////    private ImageIcon houseIcon = new ImageIcon("houseIcon.png");
////    private ImageIcon personIcon = new ImageIcon("personIcon.png");
////    private ImageIcon profileIcon = new ImageIcon("profileIcon.png");
////    private ImageIcon settingsIcon = new ImageIcon("settingsIcon.png");
////    private ImageIcon bellIcon = new ImageIcon("bellIcon.png");
////    private ImageIcon dropdownIcon = new ImageIcon("dropdownIcon.png");
////    private ImageIcon dropdownIcon2 = new ImageIcon("dropdownIcon2.png");
////    private ImageIcon searchIcon = new ImageIcon("searchIcon.png");
////    private ImageIcon cancelIcon = new ImageIcon("cancelIcon.png");
////
////    private Font RobotoRegular;
////    private Font RobotoBold;
////    private Font MontserratBold;
////
////    ASGui()
////    {
////        createFonts();
////        this.patientController = new PatientController();
////
////        // Columns and Data --------------------------------------
////        JTable patientTable = createPatientTable();
////
////
////        // JTable ------------------------------------------------
////
////        JTable table = new JTable(data, attributes){
////            @Override
////            public Class<?> getColumnClass(int column) {
////                if (column == 0) return Boolean.class;
////                return String.class;
////            }
////        };
////            table.setBounds(0,50,1226,680);
////            table.setFont(RobotoRegular.deriveFont(Font.PLAIN,14f));
////            table.setForeground(new Color(0x2e582e));
////            table.setRowHeight(68);
////            table.setShowVerticalLines(false);
////            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
////            table.setIntercellSpacing(new Dimension(0, 0));
////            table.getColumnModel().setColumnMargin(0);
////
////            table.setRowSelectionAllowed(false);
////            table.setColumnSelectionAllowed(false);
////            table.setCellSelectionEnabled(true);
////
////        // Header ------------------------------------------------
////
////        JTableHeader header = table.getTableHeader();
////            header.setPreferredSize(new Dimension(1226, 48));
////            header.setBorder(BorderFactory.createEmptyBorder());
////            header.setResizingAllowed(false);
////
////        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer()
////        {
////            @Override
////            public Component getTableCellRendererComponent(JTable table, Object value,
////                                                        boolean isSelected, boolean hasFocus,
////                                                        int row, int column) {
////                JLabel label = (JLabel) super.getTableCellRendererComponent(
////                        table, value, isSelected, hasFocus, row, column);
////                label.setHorizontalAlignment(SwingConstants.LEFT);
////                label.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
////                // label.setBackground(new Color(0xd5e3d5));
////                label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
////                // label.setOpaque(true);
////                return label;
////            }
////        };
////
////        for (int i = 0; i < table.getColumnCount(); i++) {
////            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
////        }
////
////        // Checkbox ----------------------------------------------
////
////        TableColumn selectCol = table.getColumnModel().getColumn(0);
////            selectCol.setCellRenderer(new DefaultTableCellRenderer()
////            {
////                @Override
////                public Component getTableCellRendererComponent(JTable table, Object value,
////                                                            boolean isSelected, boolean hasFocus,
////                                                            int row, int column) {
////                    JCheckBox checkBox = new JCheckBox();
////                    if (value instanceof Boolean) {
////                        checkBox.setSelected((Boolean) value);
////                    }
////                    checkBox.setHorizontalAlignment(SwingConstants.CENTER);
////                    checkBox.setBackground(table.getBackground());
////
////                    JPanel panel = new JPanel(new BorderLayout());
////                    panel.add(checkBox, BorderLayout.CENTER);
////                    panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, table.getGridColor())); // horizontal line only
////                    if (isSelected) panel.setBackground(table.getSelectionBackground());
////
////                    return panel;
////                    }
////            });
////
////        // Name --------------------------------------------------
////
////        TableColumn nameCol = table.getColumnModel().getColumn(2);
////            nameCol.setCellRenderer(new DefaultTableCellRenderer()
////            {
////                @Override
////                public Component getTableCellRendererComponent(JTable table, Object value,
////                                                            boolean isSelected, boolean hasFocus,
////                                                            int row, int column) {
////                    JPanel panel = new JPanel(new BorderLayout());
////                        panel.setOpaque(true);
////                        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
////
////                    if (value instanceof Object[]) {
////                        Object[] arr = (Object[]) value;
////                        ImageIcon profileIcon = (ImageIcon) arr[0];
////                        String name = (String) arr[1];
////
////                        JLabel label = new JLabel(name);
////                        label.setIcon(profileIcon);
////                        label.setIconTextGap(10);
////                        label.setFont(RobotoRegular.deriveFont(Font.PLAIN, 14f));
////                        label.setForeground(new Color(0x2e582e));
////                        label.setHorizontalAlignment(SwingConstants.LEFT);
////
////                        panel.add(label, BorderLayout.CENTER);
////
////                        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, table.getGridColor()));
////                    }
////                    return panel;
////                }
////            });
////
////        // Status ------------------------------------------------
////
////        TableColumn statusCol = table.getColumnModel().getColumn(6);
////            statusCol.setCellRenderer(new DefaultTableCellRenderer()
////            {
////                @Override
////                public Component getTableCellRendererComponent(JTable table, Object value,
////                                                            boolean isSelected, boolean hasFocus,
////                                                            int row, int column) {
////                    JLabel label = (JLabel) super.getTableCellRendererComponent(
////                            table, value, isSelected, hasFocus, row, column);
////
////                    // Set text color based on status
////                    if (value != null) {
////                        String status = value.toString();
////                        if (status.equalsIgnoreCase("Admitted")) {
////                            label.setForeground(new Color(0, 128, 0)); // green
////                        } else if (status.equalsIgnoreCase("Discharged")) {
////                            label.setForeground(Color.RED);
////                        } else {
////                            label.setForeground(Color.BLACK);
////                        }
////                    }
////                    return label;
////                }
////            });
////
////        // Column Width ------------------------------------------
////
////        table.getColumnModel().getColumn(0).setPreferredWidth(104); // Checkbox
////        table.getColumnModel().getColumn(1).setPreferredWidth(120); // ID
////        table.getColumnModel().getColumn(2).setPreferredWidth(125); // Last Name
////        table.getColumnModel().getColumn(3).setPreferredWidth(125); // First Name
////        table.getColumnModel().getColumn(4).setPreferredWidth(100); // Sex
////        table.getColumnModel().getColumn(5).setPreferredWidth(160); // Birthdate
////        table.getColumnModel().getColumn(6).setPreferredWidth(160); // Contact
////        table.getColumnModel().getColumn(7).setPreferredWidth(120); // Status
////
////        // Scroll Pane -------------------------------------------
////
////        JScrollPane scrollPane = new JScrollPane(table);
////            scrollPane.setBounds(0,0,1226,750);
////
////        // Select Button -----------------------------------------
////
////        JButton selectAllBtn = new JButton("Select All");
////        selectAllBtn.setBounds(10, 760, 120, 30);
////        selectAllBtn.addActionListener(e -> {
////            for (int i = 0; i < table.getRowCount(); i++) {
////                table.setValueAt(true, i, 0); // check all checkboxes
////            }
////        });
////
////        // Deselect Button ---------------------------------------
////
////        JButton deselectAllBtn = new JButton("Deselect All");
////        deselectAllBtn.setBounds(140, 760, 120, 30);
////        deselectAllBtn.addActionListener(e -> {
////            for (int i = 0; i < table.getRowCount(); i++) {
////                table.setValueAt(false, i, 0); // uncheck all checkboxes
////            }
////        });
////
////        // Frames ------------------------------------------------
////
////        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
////
////        screenWidth = screenSize.width;
////        screenHeight = screenSize.height;
////        mainWidth = 1346;
////        sideWidth = 300;
////
////        System.out.println("Screen Width: " + screenWidth + " pixels");
////        System.out.println("Screen Height: " + screenHeight + " pixels");
////
////        this.setTitle("AdmitSys");
////        this.setLayout(null);
////        this.setSize(screenWidth, screenHeight);
////        this.setResizable(false);
////        this.setExtendedState(Frame.MAXIMIZED_BOTH);
////        this.setUndecorated(true);
////        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        this.setVisible(true);
////
////        this.getContentPane().setBackground(Color.WHITE);
////
////
////        wholeScreen = new JLayeredPane();
////            wholeScreen.setLayout(null);
////            wholeScreen.setBounds(0,0, screenWidth, screenHeight);
////            wholeScreen.setBackground(new Color(0x749ee2));
////            // wholeScreen.setOpaque(true);
////
////        mainPanel = new JLayeredPane();
////            mainPanel.setLayout(null);
////            mainPanel.setBounds(300,0,mainWidth,screenHeight);
////            mainPanel.setBackground(Color.WHITE);
////            mainPanel.setOpaque(false);
////
////        sidePanel = new JLayeredPane();
////            sidePanel.setLayout(null);
////            sidePanel.setBounds(0,0,sideWidth,screenHeight);
////            sidePanel.setBackground(Color.WHITE);
////            sidePanel.setOpaque(true);
////
////        topPanel = new JPanel();
////            topPanel.setLayout(null);
////            topPanel.setBounds(0,0,mainWidth,64);
////            topPanel.setBackground(new Color(0x2e582e));
////            topPanel.setOpaque(true);
////
////        topPanel2 = new JPanel();
////            topPanel2.setLayout(null);
////            topPanel2.setBounds(0,64,mainWidth,50);
////            topPanel2.setBackground(Color.WHITE);
////            topPanel2.setOpaque(true);
////
////        listBGPanel = new JPanel();
////            listBGPanel.setLayout(null);
////            listBGPanel.setBounds(60,184,1226,730); //(1346) lr60, t70&b100
////            listBGPanel.setBackground(Color.WHITE);
////            listBGPanel.setOpaque(true);
////
////            listAttributesPanel = new JPanel();
////                listAttributesPanel.setLayout(null);
////                listAttributesPanel.setBounds(0,0,1226,50);
////                listAttributesPanel.setBackground(new Color(0xd5e3d5));
////                listAttributesPanel.setOpaque(true);
////
////            // int y = 50;
////
////            // for(int i = 0; i < 11; i++)
////            // {
////            //     listPanel[i] = new JPanel();
////
////            //     listPanel[i].setLayout(null);
////            //     listPanel[i].setBounds(0,y,1226,68);
////            //     listPanel[i].setOpaque(true);
////
////            //     if (i % 2 == 0)
////            //         listPanel[i].setBackground(Color.WHITE);
////            //     else
////            //         listPanel[i].setBackground(new Color(0xd5e3d5));
////
////            //     listBGPanel.add(listPanel[i]);
////            //     y += 68;
////            // }
////
////        // Labels ------------------------------------------------
////
////        logoLabel = new JLabel();
////            logoLabel.setIcon(logoImage);
////            logoLabel.setBounds(45,0,240,64);
////            logoLabel.setText("AdmitSys");
////            logoLabel.setFont(MontserratBold.deriveFont(Font.BOLD,28f));
////            logoLabel.setVerticalTextPosition(JLabel.CENTER);
////            logoLabel.setHorizontalTextPosition(JLabel.RIGHT);
////            logoLabel.setForeground(new Color(0x2e582e));
////            logoLabel.setBackground(Color.BLUE);
////
////        mainMenuLabel = new JLabel();
////            mainMenuLabel.setBounds(50,64,240,50);
////            mainMenuLabel.setText("Main Menu");
////            mainMenuLabel.setFont(MontserratBold.deriveFont(Font.BOLD,20f));
////            mainMenuLabel.setForeground(new Color(0x2e582e));
////            mainMenuLabel.setBackground(Color.BLUE);
////
////        transactionsLabel = new JLabel();
////            transactionsLabel.setBounds(50,490,240,50);
////            transactionsLabel.setText("Transactions");
////            transactionsLabel.setFont(MontserratBold.deriveFont(Font.BOLD,20f));
////            transactionsLabel.setForeground(new Color(0x2e582e));
////            transactionsLabel.setBackground(Color.BLUE);
////
////        recordsLabel = new JLabel();
////            recordsLabel.setBounds(50,812,240,50);
////            recordsLabel.setText("Records");
////            recordsLabel.setFont(MontserratBold.deriveFont(Font.BOLD,20f));
////            recordsLabel.setForeground(new Color(0x2e582e));
////            recordsLabel.setBackground(Color.BLUE);
////
////        patientListLabel = new JLabel();
////            patientListLabel.setBounds(60,0,240,64);
////            patientListLabel.setText("Patient List");
////            patientListLabel.setFont(MontserratBold.deriveFont(Font.BOLD,28f));
////            patientListLabel.setForeground(Color.WHITE);
////            patientListLabel.setBackground(Color.BLUE);
////
////        profileLabel = new JLabel();
////            profileLabel.setIcon(profileIcon);
////            profileLabel.setBounds(1166,0,180,64);
////            profileLabel.setForeground(new Color(0x2e582e));
////            profileLabel.setBackground(Color.BLUE);
////
////        profileNameLabel = new JLabel();
////            profileNameLabel.setBounds(50,16,120,20);
////            profileNameLabel.setText("Ian Lopez");
////            profileNameLabel.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
////            profileNameLabel.setForeground(Color.WHITE);
////            profileNameLabel.setBackground(Color.WHITE);
////
////        profileJobLabel = new JLabel();
////            profileJobLabel.setBounds(50,28,120,20);
////            profileJobLabel.setText("Physician");
////            profileJobLabel.setFont(RobotoBold.deriveFont(Font.BOLD,10f));
////            profileJobLabel.setForeground(Color.WHITE);
////            profileJobLabel.setBackground(Color.RED);
////            // profileJobLabel.setOpaque(true);
////
////        searchBarLabel = new JLabel();
////            searchBarLabel.setBounds(736,10,300,30);
////            searchBarLabel.setForeground(new Color(0x2e582e));
////            searchBarLabel.setBackground(new Color(0xd5e3d5));
////            searchBarLabel.setBorder(BorderFactory.createEtchedBorder());
////            searchBarLabel.setOpaque(true);
////
////        sortByLabel = new JLabel();
////            sortByLabel.setBounds(1046,10,190,30);
////            sortByLabel.setForeground(new Color(0x2e582e));
////            sortByLabel.setBackground(new Color(0xd5e3d5));
////            sortByLabel.setBorder(BorderFactory.createEtchedBorder());
////            sortByLabel.setOpaque(true);
////
////        sortByTextLabel = new JLabel();
////            sortByTextLabel.setBounds(20,0,140,30);
////            sortByTextLabel.setText("Sort By: Name");
////            sortByTextLabel.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
////            sortByTextLabel.setForeground(new Color(0x2e582e));
////
////        pathLabel = new JLabel();
////            pathLabel.setIcon(houseIcon);
////            pathLabel.setBounds(60,0,240,50);
////            pathLabel.setText("Home   /   Patient   /");
////            pathLabel.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            pathLabel.setVerticalTextPosition(JLabel.CENTER);
////            pathLabel.setHorizontalTextPosition(JLabel.RIGHT);
////            pathLabel.setIconTextGap(10);
////            pathLabel.setForeground(new Color(0x2e582e));
////            pathLabel.setBackground(Color.BLUE);
////            // pathLabel.setOpaque(true);
////
////        entriesLabel = new JLabel();
////            entriesLabel.setBounds(60,940,240,40);
////            entriesLabel.setText("Showing 1-10 of 246 entries");
////            entriesLabel.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
////            entriesLabel.setHorizontalAlignment(JLabel.CENTER);
////            entriesLabel.setForeground(new Color(0x2e582e));
////            entriesLabel.setBackground(Color.WHITE);
////            entriesLabel.setBorder(BorderFactory.createEtchedBorder());
////            entriesLabel.setOpaque(true);
////
////        backgroundLabel = new JLabel();
////            backgroundLabel.setIcon(backgroundImage);
////            backgroundLabel.setBounds(0,114,mainWidth,915);
////            backgroundLabel.setBackground(Color.WHITE);
////            backgroundLabel.setOpaque(true);
////
////        // Text Field --------------------------------------------
////
////        searchTextField = new JTextField();
////            searchTextField.setBounds(50,0,210,30);
////            // searchTextField.setText("Search...");
////            searchTextField.setText(placeholder);
////            searchTextField.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
////            searchTextField.setBorder(null);
////            searchTextField.setForeground(new Color(0x2e582e));
////            searchTextField.setBackground(new Color(0xd5e3d5));
////
////            searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
////                @Override
////                public void focusGained(java.awt.event.FocusEvent e) {
////                    if (searchTextField.getText().equals(placeholder)) {
////                        searchTextField.setText("");
////                        searchTextField.setForeground(new Color(0x2e582e)); // normal text color
////                    }
////                }
////
////                @Override
////                public void focusLost(java.awt.event.FocusEvent e) {
////                    if (searchTextField.getText().isEmpty()) {
////                        searchTextField.setText(placeholder);
////                        searchTextField.setForeground(Color.GRAY);
////                    }
////                }
////            });
////
////        // Buttons -----------------------------------------------
////
////        dashboardButton = new JButton();
////            dashboardButton.setBounds(30,126,240,40);
////            dashboardButton.setIcon(personIcon);
////            dashboardButton.setText("Dashboard");
////            dashboardButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            dashboardButton.setHorizontalAlignment(JLabel.LEFT);
////            dashboardButton.setIconTextGap(10);
////            dashboardButton.setForeground(new Color(0x2e582e));
////            dashboardButton.setBackground(new Color(0xd5e3d5));
////            dashboardButton.setBorder(BorderFactory.createEtchedBorder());
////            // dashboardButton.setBorder(BorderFactory.createLineBorder(new Color(0x9cb39c),2));
////            dashboardButton.setFocusable(false);
////
////        patientButton = new JButton();
////            patientButton.setBounds(30,178,240,40);
////            patientButton.setIcon(personIcon);
////            patientButton.setText("Patient");
////            patientButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            patientButton.setHorizontalAlignment(JLabel.LEFT);
////            patientButton.setIconTextGap(10);
////            patientButton.setForeground(new Color(0x2e582e));
////            patientButton.setBackground(new Color(0xd5e3d5));
////            patientButton.setBorder(BorderFactory.createEtchedBorder());
////            patientButton.setFocusable(false);
////
////        physicianButton = new JButton();
////            physicianButton.setBounds(30,230,240,40);
////            physicianButton.setIcon(personIcon);
////            physicianButton.setText("Physician");
////            physicianButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            physicianButton.setHorizontalAlignment(JLabel.LEFT);
////            physicianButton.setIconTextGap(10);
////            physicianButton.setForeground(new Color(0x2e582e));
////            physicianButton.setBackground(new Color(0xd5e3d5));
////            physicianButton.setBorder(BorderFactory.createEtchedBorder());
////            physicianButton.setFocusable(false);
////
////        nurseButton = new JButton();
////            nurseButton.setBounds(30,282,240,40);
////            nurseButton.setIcon(personIcon);
////            nurseButton.setText("Nurse");
////            nurseButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            nurseButton.setHorizontalAlignment(JLabel.LEFT);
////            nurseButton.setIconTextGap(10);
////            nurseButton.setForeground(new Color(0x2e582e));
////            nurseButton.setBackground(new Color(0xd5e3d5));
////            nurseButton.setBorder(BorderFactory.createEtchedBorder());
////            nurseButton.setFocusable(false);
////
////        wardButton = new JButton();
////            wardButton.setBounds(30,334,240,40);
////            wardButton.setIcon(personIcon);
////            wardButton.setText("Ward");
////            wardButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            wardButton.setHorizontalAlignment(JLabel.LEFT);
////            wardButton.setIconTextGap(10);
////            wardButton.setForeground(new Color(0x2e582e));
////            wardButton.setBackground(new Color(0xd5e3d5));
////            wardButton.setBorder(BorderFactory.createEtchedBorder());
////            wardButton.setFocusable(false);
////
////        medicineButton = new JButton();
////            medicineButton.setBounds(30,386,240,40);
////            medicineButton.setIcon(personIcon);
////            medicineButton.setText("Medicine");
////            medicineButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            medicineButton.setHorizontalAlignment(JLabel.LEFT);
////            medicineButton.setIconTextGap(10);
////            medicineButton.setForeground(new Color(0x2e582e));
////            medicineButton.setBackground(new Color(0xd5e3d5));
////            medicineButton.setBorder(BorderFactory.createEtchedBorder());
////            medicineButton.setFocusable(false);
////
////        ailmentButton = new JButton();
////            ailmentButton.setBounds(30,438,240,40);
////            ailmentButton.setIcon(personIcon);
////            ailmentButton.setText("Ailment");
////            ailmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            ailmentButton.setHorizontalAlignment(JLabel.LEFT);
////            ailmentButton.setIconTextGap(10);
////            ailmentButton.setForeground(new Color(0x2e582e));
////            ailmentButton.setBackground(new Color(0xd5e3d5));
////            ailmentButton.setBorder(BorderFactory.createEtchedBorder());
////            ailmentButton.setFocusable(false);
////
////        admissionButton = new JButton();
////            admissionButton.setBounds(30,552,240,40);
////            admissionButton.setIcon(personIcon);
////            admissionButton.setText("Admission");
////            admissionButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            admissionButton.setHorizontalAlignment(JLabel.LEFT);
////            admissionButton.setIconTextGap(10);
////            admissionButton.setForeground(new Color(0x2e582e));
////            admissionButton.setBackground(new Color(0xd5e3d5));
////            admissionButton.setBorder(BorderFactory.createEtchedBorder());
////            admissionButton.setFocusable(false);
////
////        dischargeButton = new JButton();
////            dischargeButton.setBounds(30,604,240,40);
////            dischargeButton.setIcon(personIcon);
////            dischargeButton.setText("Discharge");
////            dischargeButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            dischargeButton.setHorizontalAlignment(JLabel.LEFT);
////            dischargeButton.setIconTextGap(10);
////            dischargeButton.setForeground(new Color(0x2e582e));
////            dischargeButton.setBackground(new Color(0xd5e3d5));
////            dischargeButton.setBorder(BorderFactory.createEtchedBorder());
////            dischargeButton.setFocusable(false);
////
////        pAssignmentButton = new JButton();
////            pAssignmentButton.setBounds(30,656,240,40);
////            pAssignmentButton.setIcon(personIcon);
////            pAssignmentButton.setText("Physician Assignment");
////            pAssignmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
////            pAssignmentButton.setHorizontalAlignment(JLabel.LEFT);
////            pAssignmentButton.setIconTextGap(10);
////            pAssignmentButton.setForeground(new Color(0x2e582e));
////            pAssignmentButton.setBackground(new Color(0xd5e3d5));
////            pAssignmentButton.setBorder(BorderFactory.createEtchedBorder());
////            pAssignmentButton.setFocusable(false);
////
////        nAssignmentButton = new JButton();
////            nAssignmentButton.setBounds(30,708,240,40);
////            nAssignmentButton.setIcon(personIcon);
////            nAssignmentButton.setText("Nurse Assignment");
////            nAssignmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
////            nAssignmentButton.setHorizontalAlignment(JLabel.LEFT);
////            nAssignmentButton.setIconTextGap(10);
////            nAssignmentButton.setForeground(new Color(0x2e582e));
////            nAssignmentButton.setBackground(new Color(0xd5e3d5));
////            nAssignmentButton.setBorder(BorderFactory.createEtchedBorder());
////            nAssignmentButton.setFocusable(false);
////
////        treatmentButton = new JButton();
////            treatmentButton.setBounds(30,760,240,40);
////            treatmentButton.setIcon(personIcon);
////            treatmentButton.setText("Treatment Diagnosis");
////            treatmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
////            treatmentButton.setHorizontalAlignment(JLabel.LEFT);
////            treatmentButton.setIconTextGap(10);
////            treatmentButton.setForeground(new Color(0x2e582e));
////            treatmentButton.setBackground(new Color(0xd5e3d5));
////            treatmentButton.setBorder(BorderFactory.createEtchedBorder());
////            treatmentButton.setFocusable(false);
////
////        recordsButton = new JButton();
////            recordsButton.setBounds(30,874,240,40);
////            recordsButton.setIcon(personIcon);
////            recordsButton.setText("Records");
////            recordsButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
////            recordsButton.setHorizontalAlignment(JLabel.LEFT);
////            recordsButton.setIconTextGap(10);
////            recordsButton.setForeground(new Color(0x2e582e));
////            recordsButton.setBackground(new Color(0xd5e3d5));
////            recordsButton.setBorder(BorderFactory.createEtchedBorder());
////            recordsButton.setFocusable(false);
////
////        settingsButton = new JButton();
////            settingsButton.setBounds(1086,22,20,20);
////            settingsButton.setIcon(settingsIcon);
////            settingsButton.setContentAreaFilled(false);
////            // settingsButton.setBorderPainted(false);
////            settingsButton.setFocusable(false);
////
////        notificationButton = new JButton();
////            notificationButton.setBounds(1126,22,20,20);
////            notificationButton.setIcon(bellIcon);
////            notificationButton.setContentAreaFilled(false);
////            // notificationButton.setBorderPainted(false);
////            notificationButton.setFocusable(false);
////
////        searchButton = new JButton();
////            searchButton.setBounds(10,5,20,20);
////            searchButton.setIcon(searchIcon);
////            searchButton.setContentAreaFilled(false);
////            // searchButton.setBorderPainted(false);
////            searchButton.setFocusable(false);
////
////        cancelButton = new JButton();
////            cancelButton.setBounds(270,5,20,20);
////            cancelButton.setIcon(cancelIcon);
////            cancelButton.setContentAreaFilled(false);
////            // cancelButton.setBorderPainted(false);
////            cancelButton.setFocusable(false);
////
////        dropdownButton = new JButton();
////            dropdownButton.setBounds(140,20,20,20);
////            dropdownButton.setIcon(dropdownIcon);
////            dropdownButton.setContentAreaFilled(false);
////            // dropdownButton.setBorderPainted(false);
////            dropdownButton.setFocusable(false);
////
////        dropdownButton2 = new JButton();
////            dropdownButton2.setBounds(160,5,20,20);
////            dropdownButton2.setIcon(dropdownIcon2);
////            dropdownButton2.setContentAreaFilled(false);
////            // dropdownButton2.setBorderPainted(false);
////            dropdownButton2.setFocusable(false);
////
////        filterByButton = new JButton();
////            filterByButton.setBounds(1246,10,40,30);
////            filterByButton.setText("F");
////            filterByButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            filterByButton.setHorizontalAlignment(JButton.CENTER);
////            filterByButton.setForeground(new Color(0x2e582e));
////            filterByButton.setBackground(new Color(0xd5e3d5));
////            filterByButton.setBorder(BorderFactory.createEtchedBorder());
////            filterByButton.setFocusable(false);
////            filterByButton.setOpaque(true);
////
////        listViewButton = new JButton();
////            listViewButton.setBounds(60,129,40,40);
////            listViewButton.setText("L");
////            listViewButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            listViewButton.setHorizontalAlignment(JButton.CENTER);
////            listViewButton.setForeground(Color.WHITE);
////            listViewButton.setBackground(new Color(0x2e582e));
////            listViewButton.setBorder(BorderFactory.createEtchedBorder());
////            listViewButton.setFocusable(false);
////
////        tileViewButton = new JButton();
////            tileViewButton.setBounds(110,129,40,40);
////            tileViewButton.setText("T");
////            tileViewButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            tileViewButton.setHorizontalAlignment(JButton.CENTER);
////            tileViewButton.setForeground(Color.WHITE);
////            tileViewButton.setBackground(new Color(0x2e582e));
////            tileViewButton.setBorder(BorderFactory.createEtchedBorder());
////            tileViewButton.setFocusable(false);
////
////        createButton = new JButton();
////            createButton.setBounds(1046,129,140,40);
////            createButton.setText("+ Add Patient");
////            createButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            createButton.setHorizontalAlignment(JButton.CENTER);
////            createButton.setForeground(Color.WHITE);
////            createButton.setBackground(new Color(0x2e582e));
////            createButton.setBorder(BorderFactory.createEtchedBorder());
////            createButton.setFocusable(false);
////
////        updateButton = new JButton();
////            updateButton.setBounds(1196,129,40,40);
////            updateButton.setText("U");
////            updateButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            updateButton.setHorizontalAlignment(JButton.CENTER);
////            updateButton.setForeground(Color.WHITE);
////            updateButton.setBackground(new Color(0x2e582e));
////            updateButton.setBorder(BorderFactory.createEtchedBorder());
////            updateButton.setFocusable(false);
////
////        deleteButton = new JButton();
////            deleteButton.setBounds(1246,129,40,40);
////            deleteButton.setText("D");
////            deleteButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            deleteButton.setHorizontalAlignment(JButton.CENTER);
////            deleteButton.setForeground(Color.WHITE);
////            deleteButton.setBackground(new Color(0x2e582e));
////            deleteButton.setBorder(BorderFactory.createEtchedBorder());
////            deleteButton.setFocusable(false);
////
////        previousPageButton = new JButton();
////            previousPageButton.setBounds(946,940,40,40);
////            previousPageButton.setText("<");
////            previousPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            previousPageButton.setHorizontalAlignment(JButton.CENTER);
////            previousPageButton.setForeground(new Color(0x2e582e));
////            previousPageButton.setBackground(Color.WHITE);
////            previousPageButton.setBorder(BorderFactory.createEtchedBorder());
////            previousPageButton.setFocusable(false);
////
////        firstPageButton = new JButton();
////            firstPageButton.setBounds(996,940,40,40);
////            firstPageButton.setText("1");
////            firstPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            firstPageButton.setHorizontalAlignment(JButton.CENTER);
////            firstPageButton.setForeground(new Color(0x2e582e));
////            firstPageButton.setBackground(Color.WHITE);
////            firstPageButton.setBorder(BorderFactory.createEtchedBorder());
////            firstPageButton.setFocusable(false);
////
////        secondPageButton = new JButton();
////            secondPageButton.setBounds(1046,940,40,40);
////            secondPageButton.setText("2");
////            secondPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            secondPageButton.setHorizontalAlignment(JButton.CENTER);
////            secondPageButton.setForeground(new Color(0x2e582e));
////            secondPageButton.setBackground(Color.WHITE);
////            secondPageButton.setBorder(BorderFactory.createEtchedBorder());
////            secondPageButton.setFocusable(false);
////
////        thirdPageButton = new JButton();
////            thirdPageButton.setBounds(1096,940,40,40);
////            thirdPageButton.setText("3");
////            thirdPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            thirdPageButton.setHorizontalAlignment(JButton.CENTER);
////            thirdPageButton.setForeground(new Color(0x2e582e));
////            thirdPageButton.setBackground(Color.WHITE);
////            thirdPageButton.setBorder(BorderFactory.createEtchedBorder());
////            thirdPageButton.setFocusable(false);
////
////        fourthPageButton = new JButton();
////            fourthPageButton.setBounds(1146,940,40,40);
////            fourthPageButton.setText("...");
////            fourthPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            fourthPageButton.setHorizontalAlignment(JButton.CENTER);
////            fourthPageButton.setForeground(new Color(0x2e582e));
////            fourthPageButton.setBackground(Color.WHITE);
////            fourthPageButton.setBorder(BorderFactory.createEtchedBorder());
////            fourthPageButton.setFocusable(false);
////
////        lastPageButton = new JButton();
////            lastPageButton.setBounds(1196,940,40,40);
////            lastPageButton.setText("25");
////            lastPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            lastPageButton.setHorizontalAlignment(JButton.CENTER);
////            lastPageButton.setForeground(new Color(0x2e582e));
////            lastPageButton.setBackground(Color.WHITE);
////            lastPageButton.setBorder(BorderFactory.createEtchedBorder());
////            lastPageButton.setFocusable(false);
////
////        nextPageButton = new JButton();
////            nextPageButton.setBounds(1246,940,40,40);
////            nextPageButton.setText(">");
////            nextPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
////            nextPageButton.setHorizontalAlignment(JButton.CENTER);
////            nextPageButton.setForeground(new Color(0x2e582e));
////            nextPageButton.setBackground(Color.WHITE);
////            nextPageButton.setBorder(BorderFactory.createEtchedBorder());
////            nextPageButton.setFocusable(false);
////
////        // Layouts -----------------------------------------------
////
////        this.add(wholeScreen);
////            wholeScreen.add(sidePanel);
////                sidePanel.add(logoLabel);
////                sidePanel.add(mainMenuLabel);
////                    sidePanel.add(dashboardButton);
////                    sidePanel.add(patientButton);
////                    sidePanel.add(physicianButton);
////                    sidePanel.add(nurseButton);
////                    sidePanel.add(wardButton);
////                    sidePanel.add(medicineButton);
////                    sidePanel.add(ailmentButton);
////                sidePanel.add(transactionsLabel);
////                    sidePanel.add(admissionButton);
////                    sidePanel.add(dischargeButton);
////                    sidePanel.add(pAssignmentButton);
////                    sidePanel.add(nAssignmentButton);
////                    sidePanel.add(treatmentButton);
////                sidePanel.add(recordsLabel);
////                    sidePanel.add(recordsButton);
////            wholeScreen.add(mainPanel);
////                mainPanel.add(topPanel);
////                    topPanel.add(patientListLabel);
////                    topPanel.add(settingsButton);
////                    topPanel.add(notificationButton);
////                    topPanel.add(profileLabel);
////                        profileLabel.add(profileNameLabel);
////                        profileLabel.add(profileJobLabel);
////                        profileLabel.add(dropdownButton);
////                mainPanel.add(topPanel2);
////                    topPanel2.add(pathLabel);
////                    topPanel2.add(searchBarLabel);
////                        searchBarLabel.add(searchButton);
////                        searchBarLabel.add(searchTextField);
////                        searchBarLabel.add(cancelButton);
////                    topPanel2.add(sortByLabel);
////                        sortByLabel.add(sortByTextLabel);
////                        sortByLabel.add(dropdownButton2);
////                    topPanel2.add(filterByButton);
////                mainPanel.add(listBGPanel);
////                    mainPanel.setLayer(listBGPanel, 10);
////                    listBGPanel.add(selectAllBtn);
////                    listBGPanel.add(deselectAllBtn);
////                    listBGPanel.add(scrollPane);
////                    // listBGPanel.add(listAttributesPanel);
////                mainPanel.add(entriesLabel);
////                mainPanel.add(listViewButton);
////                mainPanel.add(tileViewButton);
////                mainPanel.add(createButton);
////                mainPanel.add(updateButton);
////                mainPanel.add(deleteButton);
////                mainPanel.add(previousPageButton);
////                mainPanel.add(firstPageButton);
////                mainPanel.add(secondPageButton);
////                mainPanel.add(thirdPageButton);
////                mainPanel.add(fourthPageButton);
////                mainPanel.add(lastPageButton);
////                mainPanel.add(nextPageButton);
////                mainPanel.add(backgroundLabel);
////    }
////
//    ////    public void createFonts()
//    ////    {
//    ////        try{
//    ////            RobotoRegular = Font.createFont(Font.TRUETYPE_FONT, new File("RobotoRegular.ttf")).deriveFont(50f);
//    ////                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//    ////                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("RobotoRegular.ttf")));
//    ////        }
//    ////        catch(IOException | FontFormatException e){
//    ////        }
//    ////        try{
//    ////            RobotoBold = Font.createFont(Font.TRUETYPE_FONT, new File("RobotoBold.ttf")).deriveFont(50f);
//    ////                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//    ////                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("RobotoBold.ttf")));
//    ////        }
//    ////        catch(IOException | FontFormatException e){
//    ////        }
//    ////
//    ////        try{
//    ////            MontserratBold = Font.createFont(Font.TRUETYPE_FONT, new File("MontserratBold.ttf")).deriveFont(50f);
//    ////                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//    ////                ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("MontserratBold.ttf")));
//    ////        }
//    ////        catch(IOException | FontFormatException e){
//    ////        }
//    ////    }
////
////    public void createFonts() {
////        RobotoRegular = loadFont("/RobotoRegular.ttf", 50f);
////        RobotoBold = loadFont("/RobotoBold.ttf", 50f);
////        MontserratBold = loadFont("/MontserratBold.ttf", 50f);
////    }
////
////    private Font loadFont(String path, float size) {
////        try {
////            InputStream is = getClass().getResourceAsStream(path);
////            if (is == null) {
////                throw new RuntimeException("Font file not found: " + path);
////            }
////
////            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
////            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
////            ge.registerFont(font);
////
////            return font;
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
////    }
////
////    private JTable createPatientTable() {
////        List<Patient> patients = patientController.getAllPatients();
////
////        String[] columns = {" ", "Patient ID", "Last Name", "First Name", "Sex", "Birthdate", "Contact Number", "Status"};
////        Object[][] data = new Object[patients.size()][columns.length];
////
////        for (int i = 0; i < patients.size(); i++) {
////            Patient p = patients.get(i);
////            data[i][0] = false; // checkbox
////            data[i][1] = p.getPatientID();
////            data[i][2] = new Object[]{profileIcon, p.getLastName() + ", " + p.getFirstName()};
////            data[i][3] = p.getSex();
////            data[i][4] = p.getBirthDate();
////            data[i][5] = p.getContact();
////            data[i][6] = p.getStatus();
////            data[i][7] = p.getStatus(); // make sure index matches columns
////        }
////
////        return new JTable(data, columns);
////    }
////
////    private void setupPatientTableRenderers(JTable table) {
////        // Checkbox column
////        TableColumn selectCol = table.getColumnModel().getColumn(0);
////        selectCol.setCellRenderer(new DefaultTableCellRenderer() { /* ... */ });
////        selectCol.setCellEditor(new DefaultCellEditor(new JCheckBox()));
////
////        // Name column with icon
////        TableColumn nameCol = table.getColumnModel().getColumn(2);
////        nameCol.setCellRenderer(new DefaultTableCellRenderer() { /* ... */ });
////
////        // Status color
////        TableColumn statusCol = table.getColumnModel().getColumn(7);
////        statusCol.setCellRenderer(new DefaultTableCellRenderer() { /* ... */ });
////
////        // Column widths
////        int[] widths = {104, 120, 125, 125, 100, 160, 160, 120};
////        for (int i = 0; i < widths.length; i++) {
////            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
////        }
////
////        table.setRowHeight(68);
////        table.setFont(RobotoRegular.deriveFont(Font.PLAIN,14f));
////        table.setShowVerticalLines(false);
////    }
////
////}
//
//    ASGui1()
//    {
//        createFonts();
//
//        // Columns and Data --------------------------------------
//
//        String[] attributes = {" ", "ID", "Patient Name", "Sex", "Birthdate", "Contact Number",
//                "Status", "Assigned Physician"};
//
//        Object[][] data = {{false, "12648273", new Object[]{profileIcon, "Sunwoo Han"}, "F", "January 01, 1999", "+63 927 636 2540",
//                "Admitted", "Dr. Tony Chopper"},
//                {false, "12412600", new Object[]{profileIcon, "Li Zhao Yu"}, "M", "January 01, 1999", "+63 939 838 8404",
//                        "Discharged", "Dr. Tony Chopper"},
//                {false, "11428446", new Object[]{profileIcon, "Sabine Callas"}, "F", "January 01, 1999", "+63 927 636 2540",
//                        "Admitted", "Dr. Tony Chopper"},
//                {false, "11673941", new Object[]{profileIcon, "Vincent Fabron"}, "M", "January 01, 1999", "+63 939 838 8404",
//                        "Discharged", "Dr. Tony Chopper"},
//                {false, "12648273", new Object[]{profileIcon, "Sunwoo Han"}, "F", "January 01, 1999", "+63 927 636 2540",
//                        "Admitted", "Dr. Tony Chopper"},
//                {false, "12412600", new Object[]{profileIcon, "Li Zhao Yu"}, "M", "January 01, 1999", "+63 939 838 8404",
//                        "Discharged", "Dr. Tony Chopper"},
//                {false, "11428446", new Object[]{profileIcon, "Sabine Callas"}, "F", "January 01, 1999", "+63 927 636 2540",
//                        "Admitted", "Dr. Tony Chopper"},
//                {false, "11673941", new Object[]{profileIcon, "Vincent Fabron"}, "M", "January 01, 1999", "+63 939 838 8404",
//                        "Discharged", "Dr. Tony Chopper"},
//                {false, "12648273", new Object[]{profileIcon, "Sunwoo Han"}, "F", "January 01, 1999", "+63 927 636 2540",
//                        "Admitted", "Dr. Tony Chopper"},
//                {false, "12412600", new Object[]{profileIcon, "Li Zhao Yu"}, "M", "January 01, 1999", "+63 939 838 8404",
//                        "Discharged", "Dr. Tony Chopper"}};
//
//        // JTable ------------------------------------------------
//
//        JTable table = new JTable(data, attributes){
//            @Override
//            public Class<?> getColumnClass(int column) {
//                if (column == 0) return Boolean.class;
//                return String.class;
//            }
//        };
//        table.setBounds(0,50,1226,680);
//        table.setFont(RobotoRegular.deriveFont(Font.PLAIN,14f));
//        table.setForeground(new Color(0x2e582e));
//        table.setRowHeight(68);
//        table.setShowVerticalLines(false);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        table.setIntercellSpacing(new Dimension(0, 0));
//        table.getColumnModel().setColumnMargin(0);
//
//        table.setRowSelectionAllowed(false);
//        table.setColumnSelectionAllowed(false);
//        table.setCellSelectionEnabled(true);
//
//        // Header ------------------------------------------------
//
//        JTableHeader header = table.getTableHeader();
//        header.setPreferredSize(new Dimension(1226, 48));
//        header.setBorder(BorderFactory.createEmptyBorder());
//        header.setResizingAllowed(false);
//
//        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer()
//        {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                                                           boolean isSelected, boolean hasFocus,
//                                                           int row, int column) {
//                JLabel label = (JLabel) super.getTableCellRendererComponent(
//                        table, value, isSelected, hasFocus, row, column);
//                label.setHorizontalAlignment(SwingConstants.LEFT);
//                label.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
//                // label.setBackground(new Color(0xd5e3d5));
//                label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//                // label.setOpaque(true);
//                return label;
//            }
//        };
//
//        for (int i = 0; i < table.getColumnCount(); i++) {
//            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
//        }
//
//        // Checkbox ----------------------------------------------
//
//        TableColumn selectCol = table.getColumnModel().getColumn(0);
//        selectCol.setCellRenderer(new DefaultTableCellRenderer()
//        {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                                                           boolean isSelected, boolean hasFocus,
//                                                           int row, int column) {
//                JCheckBox checkBox = new JCheckBox();
//                if (value instanceof Boolean) {
//                    checkBox.setSelected((Boolean) value);
//                }
//                checkBox.setHorizontalAlignment(SwingConstants.CENTER);
//                checkBox.setBackground(table.getBackground());
//
//                JPanel panel = new JPanel(new BorderLayout());
//                panel.add(checkBox, BorderLayout.CENTER);
//                panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, table.getGridColor())); // horizontal line only
//                if (isSelected) panel.setBackground(table.getSelectionBackground());
//
//                return panel;
//            }
//        });
//
//        // Name --------------------------------------------------
//
//        TableColumn nameCol = table.getColumnModel().getColumn(2);
//        nameCol.setCellRenderer(new DefaultTableCellRenderer()
//        {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                                                           boolean isSelected, boolean hasFocus,
//                                                           int row, int column) {
//                JPanel panel = new JPanel(new BorderLayout());
//                panel.setOpaque(true);
//                panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
//
//                if (value instanceof Object[]) {
//                    Object[] arr = (Object[]) value;
//                    ImageIcon profileIcon = (ImageIcon) arr[0];
//                    String name = (String) arr[1];
//
//                    JLabel label = new JLabel(name);
//                    label.setIcon(profileIcon);
//                    label.setIconTextGap(10);
//                    label.setFont(RobotoRegular.deriveFont(Font.PLAIN, 14f));
//                    label.setForeground(new Color(0x2e582e));
//                    label.setHorizontalAlignment(SwingConstants.LEFT);
//
//                    panel.add(label, BorderLayout.CENTER);
//
//                    panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, table.getGridColor()));
//                }
//                return panel;
//            }
//        });
//
//        // Status ------------------------------------------------
//
//        TableColumn statusCol = table.getColumnModel().getColumn(6);
//        statusCol.setCellRenderer(new DefaultTableCellRenderer()
//        {
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                                                           boolean isSelected, boolean hasFocus,
//                                                           int row, int column) {
//                JLabel label = (JLabel) super.getTableCellRendererComponent(
//                        table, value, isSelected, hasFocus, row, column);
//
//                // Set text color based on status
//                if (value != null) {
//                    String status = value.toString();
//                    if (status.equalsIgnoreCase("Admitted")) {
//                        label.setForeground(new Color(0, 128, 0)); // green
//                    } else if (status.equalsIgnoreCase("Discharged")) {
//                        label.setForeground(Color.RED);
//                    } else {
//                        label.setForeground(Color.BLACK);
//                    }
//                }
//                return label;
//            }
//        });
//
//        // Column Width ------------------------------------------
//
//        table.getColumnModel().getColumn(0).setPreferredWidth(104); // Checkbox
//        table.getColumnModel().getColumn(1).setPreferredWidth(120); // ID
//        table.getColumnModel().getColumn(2).setPreferredWidth(250); // Name
//        table.getColumnModel().getColumn(3).setPreferredWidth(100); // Sex
//        table.getColumnModel().getColumn(4).setPreferredWidth(160); // Birthdate
//        table.getColumnModel().getColumn(5).setPreferredWidth(160); // Contact
//        table.getColumnModel().getColumn(6).setPreferredWidth(120); // Status
//        table.getColumnModel().getColumn(7).setPreferredWidth(210); // Physician
//
//        // Scroll Pane -------------------------------------------
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBounds(0,0,1226,750);
//
//        // Select Button -----------------------------------------
//
//        JButton selectAllBtn = new JButton("Select All");
//        selectAllBtn.setBounds(10, 760, 120, 30);
//        selectAllBtn.addActionListener(e -> {
//            for (int i = 0; i < table.getRowCount(); i++) {
//                table.setValueAt(true, i, 0); // check all checkboxes
//            }
//        });
//
//        // Deselect Button ---------------------------------------
//
//        JButton deselectAllBtn = new JButton("Deselect All");
//        deselectAllBtn.setBounds(140, 760, 120, 30);
//        deselectAllBtn.addActionListener(e -> {
//            for (int i = 0; i < table.getRowCount(); i++) {
//                table.setValueAt(false, i, 0); // uncheck all checkboxes
//            }
//        });
//
//        // Frames ------------------------------------------------
//
//        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//
//        screenWidth = screenSize.width;
//        screenHeight = screenSize.height;
//        mainWidth = 1346;
//        sideWidth = 300;
//
//        System.out.println("Screen Width: " + screenWidth + " pixels");
//        System.out.println("Screen Height: " + screenHeight + " pixels");
//
//        this.setTitle("AdmitSys");
//        this.setLayout(null);
//        this.setSize(screenWidth, screenHeight);
//        this.setResizable(false);
//        this.setExtendedState(Frame.MAXIMIZED_BOTH);
//        this.setUndecorated(true);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//
//        this.getContentPane().setBackground(Color.WHITE);
//
//
//        wholeScreen = new JLayeredPane();
//        wholeScreen.setLayout(null);
//        wholeScreen.setBounds(0,0, screenWidth, screenHeight);
//        wholeScreen.setBackground(new Color(0x749ee2));
//        // wholeScreen.setOpaque(true);
//
//        mainPanel = new JLayeredPane();
//        mainPanel.setLayout(null);
//        mainPanel.setBounds(300,0,mainWidth,screenHeight);
//        mainPanel.setBackground(Color.WHITE);
//        mainPanel.setOpaque(false);
//
//        sidePanel = new JLayeredPane();
//        sidePanel.setLayout(null);
//        sidePanel.setBounds(0,0,sideWidth,screenHeight);
//        sidePanel.setBackground(Color.WHITE);
//        sidePanel.setOpaque(true);
//
//        topPanel = new JPanel();
//        topPanel.setLayout(null);
//        topPanel.setBounds(0,0,mainWidth,64);
//        topPanel.setBackground(new Color(0x2e582e));
//        topPanel.setOpaque(true);
//
//        topPanel2 = new JPanel();
//        topPanel2.setLayout(null);
//        topPanel2.setBounds(0,64,mainWidth,50);
//        topPanel2.setBackground(Color.WHITE);
//        topPanel2.setOpaque(true);
//
//        listBGPanel = new JPanel();
//        listBGPanel.setLayout(null);
//        listBGPanel.setBounds(60,184,1226,730); //(1346) lr60, t70&b100
//        listBGPanel.setBackground(Color.WHITE);
//        listBGPanel.setOpaque(true);
//
//        listAttributesPanel = new JPanel();
//        listAttributesPanel.setLayout(null);
//        listAttributesPanel.setBounds(0,0,1226,50);
//        listAttributesPanel.setBackground(new Color(0xd5e3d5));
//        listAttributesPanel.setOpaque(true);
//
//        // int y = 50;
//
//        // for(int i = 0; i < 11; i++)
//        // {
//        //     listPanel[i] = new JPanel();
//
//        //     listPanel[i].setLayout(null);
//        //     listPanel[i].setBounds(0,y,1226,68);
//        //     listPanel[i].setOpaque(true);
//
//        //     if (i % 2 == 0)
//        //         listPanel[i].setBackground(Color.WHITE);
//        //     else
//        //         listPanel[i].setBackground(new Color(0xd5e3d5));
//
//        //     listBGPanel.add(listPanel[i]);
//        //     y += 68;
//        // }
//
//        // Labels ------------------------------------------------
//
//        logoLabel = new JLabel();
//        logoLabel.setIcon(logoImage);
//        logoLabel.setBounds(45,0,240,64);
//        logoLabel.setText("AdmitSys");
//        logoLabel.setFont(MontserratBold.deriveFont(Font.BOLD,28f));
//        logoLabel.setVerticalTextPosition(JLabel.CENTER);
//        logoLabel.setHorizontalTextPosition(JLabel.RIGHT);
//        logoLabel.setForeground(new Color(0x2e582e));
//        logoLabel.setBackground(Color.BLUE);
//
//        mainMenuLabel = new JLabel();
//        mainMenuLabel.setBounds(50,64,240,50);
//        mainMenuLabel.setText("Main Menu");
//        mainMenuLabel.setFont(MontserratBold.deriveFont(Font.BOLD,20f));
//        mainMenuLabel.setForeground(new Color(0x2e582e));
//        mainMenuLabel.setBackground(Color.BLUE);
//
//        transactionsLabel = new JLabel();
//        transactionsLabel.setBounds(50,490,240,50);
//        transactionsLabel.setText("Transactions");
//        transactionsLabel.setFont(MontserratBold.deriveFont(Font.BOLD,20f));
//        transactionsLabel.setForeground(new Color(0x2e582e));
//        transactionsLabel.setBackground(Color.BLUE);
//
//        recordsLabel = new JLabel();
//        recordsLabel.setBounds(50,812,240,50);
//        recordsLabel.setText("Records");
//        recordsLabel.setFont(MontserratBold.deriveFont(Font.BOLD,20f));
//        recordsLabel.setForeground(new Color(0x2e582e));
//        recordsLabel.setBackground(Color.BLUE);
//
//        patientListLabel = new JLabel();
//        patientListLabel.setBounds(60,0,240,64);
//        patientListLabel.setText("Patient List");
//        patientListLabel.setFont(MontserratBold.deriveFont(Font.BOLD,28f));
//        patientListLabel.setForeground(Color.WHITE);
//        patientListLabel.setBackground(Color.BLUE);
//
//        profileLabel = new JLabel();
//        profileLabel.setIcon(profileIcon);
//        profileLabel.setBounds(1166,0,180,64);
//        profileLabel.setForeground(new Color(0x2e582e));
//        profileLabel.setBackground(Color.BLUE);
//
//        profileNameLabel = new JLabel();
//        profileNameLabel.setBounds(50,16,120,20);
//        profileNameLabel.setText("Ian Lopez");
//        profileNameLabel.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
//        profileNameLabel.setForeground(Color.WHITE);
//        profileNameLabel.setBackground(Color.WHITE);
//
//        profileJobLabel = new JLabel();
//        profileJobLabel.setBounds(50,28,120,20);
//        profileJobLabel.setText("Physician");
//        profileJobLabel.setFont(RobotoBold.deriveFont(Font.BOLD,10f));
//        profileJobLabel.setForeground(Color.WHITE);
//        profileJobLabel.setBackground(Color.RED);
//        // profileJobLabel.setOpaque(true);
//
//        searchBarLabel = new JLabel();
//        searchBarLabel.setBounds(736,10,300,30);
//        searchBarLabel.setForeground(new Color(0x2e582e));
//        searchBarLabel.setBackground(new Color(0xd5e3d5));
//        searchBarLabel.setBorder(BorderFactory.createEtchedBorder());
//        searchBarLabel.setOpaque(true);
//
//        sortByLabel = new JLabel();
//        sortByLabel.setBounds(1046,10,190,30);
//        sortByLabel.setForeground(new Color(0x2e582e));
//        sortByLabel.setBackground(new Color(0xd5e3d5));
//        sortByLabel.setBorder(BorderFactory.createEtchedBorder());
//        sortByLabel.setOpaque(true);
//
//        sortByTextLabel = new JLabel();
//        sortByTextLabel.setBounds(20,0,140,30);
//        sortByTextLabel.setText("Sort By: Name");
//        sortByTextLabel.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
//        sortByTextLabel.setForeground(new Color(0x2e582e));
//
//        pathLabel = new JLabel();
//        pathLabel.setIcon(houseIcon);
//        pathLabel.setBounds(60,0,240,50);
//        pathLabel.setText("Home   /   Patient   /");
//        pathLabel.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        pathLabel.setVerticalTextPosition(JLabel.CENTER);
//        pathLabel.setHorizontalTextPosition(JLabel.RIGHT);
//        pathLabel.setIconTextGap(10);
//        pathLabel.setForeground(new Color(0x2e582e));
//        pathLabel.setBackground(Color.BLUE);
//        // pathLabel.setOpaque(true);
//
//        entriesLabel = new JLabel();
//        entriesLabel.setBounds(60,940,240,40);
//        entriesLabel.setText("Showing 1-10 of 246 entries");
//        entriesLabel.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
//        entriesLabel.setHorizontalAlignment(JLabel.CENTER);
//        entriesLabel.setForeground(new Color(0x2e582e));
//        entriesLabel.setBackground(Color.WHITE);
//        entriesLabel.setBorder(BorderFactory.createEtchedBorder());
//        entriesLabel.setOpaque(true);
//
//        backgroundLabel = new JLabel();
//        backgroundLabel.setIcon(backgroundImage);
//        backgroundLabel.setBounds(0,114,mainWidth,915);
//        backgroundLabel.setBackground(Color.WHITE);
//        backgroundLabel.setOpaque(true);
//
//        // Text Field --------------------------------------------
//
//        searchTextField = new JTextField();
//        searchTextField.setBounds(50,0,210,30);
//        // searchTextField.setText("Search...");
//        searchTextField.setText(placeholder);
//        searchTextField.setFont(RobotoBold.deriveFont(Font.BOLD,14f));
//        searchTextField.setBorder(null);
//        searchTextField.setForeground(new Color(0x2e582e));
//        searchTextField.setBackground(new Color(0xd5e3d5));
//
//        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
//            @Override
//            public void focusGained(java.awt.event.FocusEvent e) {
//                if (searchTextField.getText().equals(placeholder)) {
//                    searchTextField.setText("");
//                    searchTextField.setForeground(new Color(0x2e582e)); // normal text color
//                }
//            }
//
//            @Override
//            public void focusLost(java.awt.event.FocusEvent e) {
//                if (searchTextField.getText().isEmpty()) {
//                    searchTextField.setText(placeholder);
//                    searchTextField.setForeground(Color.GRAY);
//                }
//            }
//        });
//
//        // Buttons -----------------------------------------------
//
//        dashboardButton = new JButton();
//        dashboardButton.setBounds(30,126,240,40);
//        dashboardButton.setIcon(personIcon);
//        dashboardButton.setText("Dashboard");
//        dashboardButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        dashboardButton.setHorizontalAlignment(JLabel.LEFT);
//        dashboardButton.setIconTextGap(10);
//        dashboardButton.setForeground(new Color(0x2e582e));
//        dashboardButton.setBackground(new Color(0xd5e3d5));
//        dashboardButton.setBorder(BorderFactory.createEtchedBorder());
//        // dashboardButton.setBorder(BorderFactory.createLineBorder(new Color(0x9cb39c),2));
//        dashboardButton.setFocusable(false);
//
//        patientButton = new JButton();
//        patientButton.setBounds(30,178,240,40);
//        patientButton.setIcon(personIcon);
//        patientButton.setText("Patient");
//        patientButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        patientButton.setHorizontalAlignment(JLabel.LEFT);
//        patientButton.setIconTextGap(10);
//        patientButton.setForeground(new Color(0x2e582e));
//        patientButton.setBackground(new Color(0xd5e3d5));
//        patientButton.setBorder(BorderFactory.createEtchedBorder());
//        patientButton.setFocusable(false);
//
//        physicianButton = new JButton();
//        physicianButton.setBounds(30,230,240,40);
//        physicianButton.setIcon(personIcon);
//        physicianButton.setText("Physician");
//        physicianButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        physicianButton.setHorizontalAlignment(JLabel.LEFT);
//        physicianButton.setIconTextGap(10);
//        physicianButton.setForeground(new Color(0x2e582e));
//        physicianButton.setBackground(new Color(0xd5e3d5));
//        physicianButton.setBorder(BorderFactory.createEtchedBorder());
//        physicianButton.setFocusable(false);
//
//        nurseButton = new JButton();
//        nurseButton.setBounds(30,282,240,40);
//        nurseButton.setIcon(personIcon);
//        nurseButton.setText("Nurse");
//        nurseButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        nurseButton.setHorizontalAlignment(JLabel.LEFT);
//        nurseButton.setIconTextGap(10);
//        nurseButton.setForeground(new Color(0x2e582e));
//        nurseButton.setBackground(new Color(0xd5e3d5));
//        nurseButton.setBorder(BorderFactory.createEtchedBorder());
//        nurseButton.setFocusable(false);
//
//        wardButton = new JButton();
//        wardButton.setBounds(30,334,240,40);
//        wardButton.setIcon(personIcon);
//        wardButton.setText("Ward");
//        wardButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        wardButton.setHorizontalAlignment(JLabel.LEFT);
//        wardButton.setIconTextGap(10);
//        wardButton.setForeground(new Color(0x2e582e));
//        wardButton.setBackground(new Color(0xd5e3d5));
//        wardButton.setBorder(BorderFactory.createEtchedBorder());
//        wardButton.setFocusable(false);
//
//        medicineButton = new JButton();
//        medicineButton.setBounds(30,386,240,40);
//        medicineButton.setIcon(personIcon);
//        medicineButton.setText("Medicine");
//        medicineButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        medicineButton.setHorizontalAlignment(JLabel.LEFT);
//        medicineButton.setIconTextGap(10);
//        medicineButton.setForeground(new Color(0x2e582e));
//        medicineButton.setBackground(new Color(0xd5e3d5));
//        medicineButton.setBorder(BorderFactory.createEtchedBorder());
//        medicineButton.setFocusable(false);
//
//        ailmentButton = new JButton();
//        ailmentButton.setBounds(30,438,240,40);
//        ailmentButton.setIcon(personIcon);
//        ailmentButton.setText("Ailment");
//        ailmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        ailmentButton.setHorizontalAlignment(JLabel.LEFT);
//        ailmentButton.setIconTextGap(10);
//        ailmentButton.setForeground(new Color(0x2e582e));
//        ailmentButton.setBackground(new Color(0xd5e3d5));
//        ailmentButton.setBorder(BorderFactory.createEtchedBorder());
//        ailmentButton.setFocusable(false);
//
//        admissionButton = new JButton();
//        admissionButton.setBounds(30,552,240,40);
//        admissionButton.setIcon(personIcon);
//        admissionButton.setText("Admission");
//        admissionButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        admissionButton.setHorizontalAlignment(JLabel.LEFT);
//        admissionButton.setIconTextGap(10);
//        admissionButton.setForeground(new Color(0x2e582e));
//        admissionButton.setBackground(new Color(0xd5e3d5));
//        admissionButton.setBorder(BorderFactory.createEtchedBorder());
//        admissionButton.setFocusable(false);
//
//        dischargeButton = new JButton();
//        dischargeButton.setBounds(30,604,240,40);
//        dischargeButton.setIcon(personIcon);
//        dischargeButton.setText("Discharge");
//        dischargeButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        dischargeButton.setHorizontalAlignment(JLabel.LEFT);
//        dischargeButton.setIconTextGap(10);
//        dischargeButton.setForeground(new Color(0x2e582e));
//        dischargeButton.setBackground(new Color(0xd5e3d5));
//        dischargeButton.setBorder(BorderFactory.createEtchedBorder());
//        dischargeButton.setFocusable(false);
//
//        pAssignmentButton = new JButton();
//        pAssignmentButton.setBounds(30,656,240,40);
//        pAssignmentButton.setIcon(personIcon);
//        pAssignmentButton.setText("Physician Assignment");
//        pAssignmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
//        pAssignmentButton.setHorizontalAlignment(JLabel.LEFT);
//        pAssignmentButton.setIconTextGap(10);
//        pAssignmentButton.setForeground(new Color(0x2e582e));
//        pAssignmentButton.setBackground(new Color(0xd5e3d5));
//        pAssignmentButton.setBorder(BorderFactory.createEtchedBorder());
//        pAssignmentButton.setFocusable(false);
//
//        nAssignmentButton = new JButton();
//        nAssignmentButton.setBounds(30,708,240,40);
//        nAssignmentButton.setIcon(personIcon);
//        nAssignmentButton.setText("Nurse Assignment");
//        nAssignmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
//        nAssignmentButton.setHorizontalAlignment(JLabel.LEFT);
//        nAssignmentButton.setIconTextGap(10);
//        nAssignmentButton.setForeground(new Color(0x2e582e));
//        nAssignmentButton.setBackground(new Color(0xd5e3d5));
//        nAssignmentButton.setBorder(BorderFactory.createEtchedBorder());
//        nAssignmentButton.setFocusable(false);
//
//        treatmentButton = new JButton();
//        treatmentButton.setBounds(30,760,240,40);
//        treatmentButton.setIcon(personIcon);
//        treatmentButton.setText("Treatment Diagnosis");
//        treatmentButton.setFont(RobotoBold.deriveFont(Font.BOLD,16f));
//        treatmentButton.setHorizontalAlignment(JLabel.LEFT);
//        treatmentButton.setIconTextGap(10);
//        treatmentButton.setForeground(new Color(0x2e582e));
//        treatmentButton.setBackground(new Color(0xd5e3d5));
//        treatmentButton.setBorder(BorderFactory.createEtchedBorder());
//        treatmentButton.setFocusable(false);
//
//        recordsButton = new JButton();
//        recordsButton.setBounds(30,874,240,40);
//        recordsButton.setIcon(personIcon);
//        recordsButton.setText("Records");
//        recordsButton.setFont(RobotoBold.deriveFont(Font.BOLD,20f));
//        recordsButton.setHorizontalAlignment(JLabel.LEFT);
//        recordsButton.setIconTextGap(10);
//        recordsButton.setForeground(new Color(0x2e582e));
//        recordsButton.setBackground(new Color(0xd5e3d5));
//        recordsButton.setBorder(BorderFactory.createEtchedBorder());
//        recordsButton.setFocusable(false);
//
//        settingsButton = new JButton();
//        settingsButton.setBounds(1086,22,20,20);
//        settingsButton.setIcon(settingsIcon);
//        settingsButton.setContentAreaFilled(false);
//        // settingsButton.setBorderPainted(false);
//        settingsButton.setFocusable(false);
//
//        notificationButton = new JButton();
//        notificationButton.setBounds(1126,22,20,20);
//        notificationButton.setIcon(bellIcon);
//        notificationButton.setContentAreaFilled(false);
//        // notificationButton.setBorderPainted(false);
//        notificationButton.setFocusable(false);
//
//        searchButton = new JButton();
//        searchButton.setBounds(10,5,20,20);
//        searchButton.setIcon(searchIcon);
//        searchButton.setContentAreaFilled(false);
//        // searchButton.setBorderPainted(false);
//        searchButton.setFocusable(false);
//
//        cancelButton = new JButton();
//        cancelButton.setBounds(270,5,20,20);
//        cancelButton.setIcon(cancelIcon);
//        cancelButton.setContentAreaFilled(false);
//        // cancelButton.setBorderPainted(false);
//        cancelButton.setFocusable(false);
//
//        dropdownButton = new JButton();
//        dropdownButton.setBounds(140,20,20,20);
//        dropdownButton.setIcon(dropdownIcon);
//        dropdownButton.setContentAreaFilled(false);
//        // dropdownButton.setBorderPainted(false);
//        dropdownButton.setFocusable(false);
//
//        dropdownButton2 = new JButton();
//        dropdownButton2.setBounds(160,5,20,20);
//        dropdownButton2.setIcon(dropdownIcon2);
//        dropdownButton2.setContentAreaFilled(false);
//        // dropdownButton2.setBorderPainted(false);
//        dropdownButton2.setFocusable(false);
//
//        filterByButton = new JButton();
//        filterByButton.setBounds(1246,10,40,30);
//        filterByButton.setText("F");
//        filterByButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        filterByButton.setHorizontalAlignment(JButton.CENTER);
//        filterByButton.setForeground(new Color(0x2e582e));
//        filterByButton.setBackground(new Color(0xd5e3d5));
//        filterByButton.setBorder(BorderFactory.createEtchedBorder());
//        filterByButton.setFocusable(false);
//        filterByButton.setOpaque(true);
//
//        listViewButton = new JButton();
//        listViewButton.setBounds(60,129,40,40);
//        listViewButton.setText("L");
//        listViewButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        listViewButton.setHorizontalAlignment(JButton.CENTER);
//        listViewButton.setForeground(Color.WHITE);
//        listViewButton.setBackground(new Color(0x2e582e));
//        listViewButton.setBorder(BorderFactory.createEtchedBorder());
//        listViewButton.setFocusable(false);
//
//        tileViewButton = new JButton();
//        tileViewButton.setBounds(110,129,40,40);
//        tileViewButton.setText("T");
//        tileViewButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        tileViewButton.setHorizontalAlignment(JButton.CENTER);
//        tileViewButton.setForeground(Color.WHITE);
//        tileViewButton.setBackground(new Color(0x2e582e));
//        tileViewButton.setBorder(BorderFactory.createEtchedBorder());
//        tileViewButton.setFocusable(false);
//
//        createButton = new JButton();
//        createButton.setBounds(1046,129,140,40);
//        createButton.setText("+ Add Patient");
//        createButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        createButton.setHorizontalAlignment(JButton.CENTER);
//        createButton.setForeground(Color.WHITE);
//        createButton.setBackground(new Color(0x2e582e));
//        createButton.setBorder(BorderFactory.createEtchedBorder());
//        createButton.setFocusable(false);
//
//        updateButton = new JButton();
//        updateButton.setBounds(1196,129,40,40);
//        updateButton.setText("U");
//        updateButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        updateButton.setHorizontalAlignment(JButton.CENTER);
//        updateButton.setForeground(Color.WHITE);
//        updateButton.setBackground(new Color(0x2e582e));
//        updateButton.setBorder(BorderFactory.createEtchedBorder());
//        updateButton.setFocusable(false);
//
//        deleteButton = new JButton();
//        deleteButton.setBounds(1246,129,40,40);
//        deleteButton.setText("D");
//        deleteButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        deleteButton.setHorizontalAlignment(JButton.CENTER);
//        deleteButton.setForeground(Color.WHITE);
//        deleteButton.setBackground(new Color(0x2e582e));
//        deleteButton.setBorder(BorderFactory.createEtchedBorder());
//        deleteButton.setFocusable(false);
//
//        previousPageButton = new JButton();
//        previousPageButton.setBounds(946,940,40,40);
//        previousPageButton.setText("<");
//        previousPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        previousPageButton.setHorizontalAlignment(JButton.CENTER);
//        previousPageButton.setForeground(new Color(0x2e582e));
//        previousPageButton.setBackground(Color.WHITE);
//        previousPageButton.setBorder(BorderFactory.createEtchedBorder());
//        previousPageButton.setFocusable(false);
//
//        firstPageButton = new JButton();
//        firstPageButton.setBounds(996,940,40,40);
//        firstPageButton.setText("1");
//        firstPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        firstPageButton.setHorizontalAlignment(JButton.CENTER);
//        firstPageButton.setForeground(new Color(0x2e582e));
//        firstPageButton.setBackground(Color.WHITE);
//        firstPageButton.setBorder(BorderFactory.createEtchedBorder());
//        firstPageButton.setFocusable(false);
//
//        secondPageButton = new JButton();
//        secondPageButton.setBounds(1046,940,40,40);
//        secondPageButton.setText("2");
//        secondPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        secondPageButton.setHorizontalAlignment(JButton.CENTER);
//        secondPageButton.setForeground(new Color(0x2e582e));
//        secondPageButton.setBackground(Color.WHITE);
//        secondPageButton.setBorder(BorderFactory.createEtchedBorder());
//        secondPageButton.setFocusable(false);
//
//        thirdPageButton = new JButton();
//        thirdPageButton.setBounds(1096,940,40,40);
//        thirdPageButton.setText("3");
//        thirdPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        thirdPageButton.setHorizontalAlignment(JButton.CENTER);
//        thirdPageButton.setForeground(new Color(0x2e582e));
//        thirdPageButton.setBackground(Color.WHITE);
//        thirdPageButton.setBorder(BorderFactory.createEtchedBorder());
//        thirdPageButton.setFocusable(false);
//
//        fourthPageButton = new JButton();
//        fourthPageButton.setBounds(1146,940,40,40);
//        fourthPageButton.setText("...");
//        fourthPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        fourthPageButton.setHorizontalAlignment(JButton.CENTER);
//        fourthPageButton.setForeground(new Color(0x2e582e));
//        fourthPageButton.setBackground(Color.WHITE);
//        fourthPageButton.setBorder(BorderFactory.createEtchedBorder());
//        fourthPageButton.setFocusable(false);
//
//        lastPageButton = new JButton();
//        lastPageButton.setBounds(1196,940,40,40);
//        lastPageButton.setText("25");
//        lastPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        lastPageButton.setHorizontalAlignment(JButton.CENTER);
//        lastPageButton.setForeground(new Color(0x2e582e));
//        lastPageButton.setBackground(Color.WHITE);
//        lastPageButton.setBorder(BorderFactory.createEtchedBorder());
//        lastPageButton.setFocusable(false);
//
//        nextPageButton = new JButton();
//        nextPageButton.setBounds(1246,940,40,40);
//        nextPageButton.setText(">");
//        nextPageButton.setFont(RobotoBold.deriveFont(Font.BOLD,18f));
//        nextPageButton.setHorizontalAlignment(JButton.CENTER);
//        nextPageButton.setForeground(new Color(0x2e582e));
//        nextPageButton.setBackground(Color.WHITE);
//        nextPageButton.setBorder(BorderFactory.createEtchedBorder());
//        nextPageButton.setFocusable(false);
//
//        // Layouts -----------------------------------------------
//
//        this.add(wholeScreen);
//        wholeScreen.add(sidePanel);
//        sidePanel.add(logoLabel);
//        sidePanel.add(mainMenuLabel);
//        sidePanel.add(dashboardButton);
//        sidePanel.add(patientButton);
//        sidePanel.add(physicianButton);
//        sidePanel.add(nurseButton);
//        sidePanel.add(wardButton);
//        sidePanel.add(medicineButton);
//        sidePanel.add(ailmentButton);
//        sidePanel.add(transactionsLabel);
//        sidePanel.add(admissionButton);
//        sidePanel.add(dischargeButton);
//        sidePanel.add(pAssignmentButton);
//        sidePanel.add(nAssignmentButton);
//        sidePanel.add(treatmentButton);
//        sidePanel.add(recordsLabel);
//        sidePanel.add(recordsButton);
//        wholeScreen.add(mainPanel);
//        mainPanel.add(topPanel);
//        topPanel.add(patientListLabel);
//        topPanel.add(settingsButton);
//        topPanel.add(notificationButton);
//        topPanel.add(profileLabel);
//        profileLabel.add(profileNameLabel);
//        profileLabel.add(profileJobLabel);
//        profileLabel.add(dropdownButton);
//        mainPanel.add(topPanel2);
//        topPanel2.add(pathLabel);
//        topPanel2.add(searchBarLabel);
//        searchBarLabel.add(searchButton);
//        searchBarLabel.add(searchTextField);
//        searchBarLabel.add(cancelButton);
//        topPanel2.add(sortByLabel);
//        sortByLabel.add(sortByTextLabel);
//        sortByLabel.add(dropdownButton2);
//        topPanel2.add(filterByButton);
//        mainPanel.add(listBGPanel);
//        mainPanel.setLayer(listBGPanel, 10);
//        listBGPanel.add(selectAllBtn);
//        listBGPanel.add(deselectAllBtn);
//        listBGPanel.add(scrollPane);
//        // listBGPanel.add(listAttributesPanel);
//        mainPanel.add(entriesLabel);
//        mainPanel.add(listViewButton);
//        mainPanel.add(tileViewButton);
//        mainPanel.add(createButton);
//        mainPanel.add(updateButton);
//        mainPanel.add(deleteButton);
//        mainPanel.add(previousPageButton);
//        mainPanel.add(firstPageButton);
//        mainPanel.add(secondPageButton);
//        mainPanel.add(thirdPageButton);
//        mainPanel.add(fourthPageButton);
//        mainPanel.add(lastPageButton);
//        mainPanel.add(nextPageButton);
//        mainPanel.add(backgroundLabel);
//    }
//
//    public void createFonts()
//    {
//        try{
//            RobotoRegular = Font.createFont(Font.TRUETYPE_FONT, new File("RobotoRegular.ttf")).deriveFont(50f);
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("RobotoRegular.ttf")));
//        }
//        catch(IOException | FontFormatException e){
//        }
//
//        try{
//            RobotoBold = Font.createFont(Font.TRUETYPE_FONT, new File("RobotoBold.ttf")).deriveFont(50f);
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("RobotoBold.ttf")));
//        }
//        catch(IOException | FontFormatException e){
//        }
//
//        try{
//            MontserratBold = Font.createFont(Font.TRUETYPE_FONT, new File("MontserratBold.ttf")).deriveFont(50f);
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("MontserratBold.ttf")));
//        }
//        catch(IOException | FontFormatException e){
//        }
//    }
//}