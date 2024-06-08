package student;


import connectivity.ConnectionProvider;
import home.HomePage;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ritesh Singh
 */
public class StudentProfile extends javax.swing.JFrame {
    
    int oldfees = 0, newfees = 0;
    boolean canChangeRoom;
    String stdId, fname, lname, mobile, pmobile, course, foccupation, institute, email, villege, district, pincode, state;

    /**
     * Creates new form StudentProfile
     */
    
    public StudentProfile() {
        initComponents();
        scallBackground();
        scallBack_edu();
        scallBack_room();
        scallBack_personal();
        scallCross();
    }
    public final void scallBackground()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\solid_5.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
    }
    public final void scallBack_edu()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\solid_3.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblback_education.getWidth(), lblback_education.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblback_education.setIcon(finalImage);
    }
    public final void scallBack_personal()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\solid_3.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblback_personal.getWidth(), lblback_personal.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblback_personal.setIcon(finalImage);
    }
    public final void scallBack_room()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\solid_3.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblback_room.getWidth(), lblback_room.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblback_room.setIcon(finalImage);
    }
    public final void scallCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Exit_big.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnclose.getWidth(), btnclose.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnclose.setIcon(finalImage);
    }
    private void lock() {
        txtfatheroccupation.setEditable(false);
        txtparentsmobile.setEditable(false);
        txtmobile.setEditable(false);
        txtemail.setEditable(false);
        txtinstute.setEditable(false);
        txtcourse.setEditable(false);
        txtvillege.setEditable(false);
        txtdistrict.setEditable(false);
        txtpincode.setEditable(false);
        txtstate.setEditable(false);
        
        lblwarning1.setVisible(false);
        lblwarning2.setVisible(false);
        btnpersonalsave.setVisible(false);
        btnacadmicsave.setVisible(false);
        
    }

    private void unLock() {
        txtfatheroccupation.setEditable(true);
        txtparentsmobile.setEditable(true);
        txtmobile.setEditable(true);
        txtemail.setEditable(true);
        txtinstute.setEditable(true);
        txtcourse.setEditable(true);
        txtvillege.setEditable(true);
        txtdistrict.setEditable(true);
        txtpincode.setEditable(true);
        txtstate.setEditable(true);
        
        lblwarning1.setVisible(true);
        lblwarning2.setVisible(true);
        btnpersonalsave.setVisible(true);
        btnacadmicsave.setVisible(true);
        
    }

    public void tableDetails() {
        DefaultTableModel dtm = (DefaultTableModel) tblChangeRoom.getModel();
        dtm.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from rooms where status='Available' ");
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getString(1), rs.getInt(2), rs.getString(4), rs.getString(5)});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void checkStatus(String id) {
        try {
            
            Connection con3 = ConnectionProvider.getCon();
            Statement st3 = con3.createStatement();
            ResultSet rst3 = st3.executeQuery("select * from leaves where student_id=" + id);
            while (rst3.next()) {
                lblhstatus.setText("Status: " + rst3.getString(3));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void checkStudentRoom() {
        Connection con = ConnectionProvider.getCon();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from rooms");
            while (rs.next()) {
                String bed1 = " ", bed2 = " ", bed3 = " ", bed4 = " ";
                if (rs.getString(8) != null) {
                    bed1 = (String) rs.getString(8);
                }
                if (rs.getString(9) != null) {
                    bed2 = (String) rs.getString(9);
                }
                if (rs.getString(10) != null) {
                    bed3 = (String) rs.getString(10);
                }
                if (rs.getString(11) != null) {
                    bed4 = (String) rs.getString(11);
                }
                
                if (bed1.equals(stdId) || bed2.equals(stdId) || bed3.equals(stdId) || bed4.equals(stdId)) {                    
                    System.out.print(9);
                    txtroomno.setText((String) rs.getString(1));
                    break;
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        
    }

    public void deleteStudentFromRoom() {
        Connection con1;
        String room = txtroomno.getText();
        int beds, booked;
        String status = "Available", bedposition = "";
        try {
            con1 = connectivity.ConnectionProvider.getCon();
            Statement st = con1.createStatement();            
            ResultSet rs = st.executeQuery("select * from rooms where room_id=" + room);
            while (rs.next()) {                
                beds = rs.getInt(2);
                booked = rs.getInt(3);
                booked = booked - 1;
                if (stdId.equals(rs.getString(8))) {
                    bedposition = "1st";
                } else if (stdId.equals(rs.getString(9))) {
                    bedposition = "2nd";
                } else if (stdId.equals(rs.getString(10))) {
                    bedposition = "3rd";
                } else if (stdId.equals(rs.getString(11))) {
                    bedposition = "4th";
                }
                Statement st1 = con1.createStatement();
                st1.executeUpdate("update rooms set beds_booked='" + booked + "', beds_available='" + (beds - booked) + "', status='" + status + "'," + bedposition + "='" + "----" + "' where room_id='" + room + "';");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void allotRoom() {
        String studentid = txtid.getText();
        String roomId = txtnewroom.getText();
        Connection con;
        int beds, booked;
        String status = "Available", bedposition = "";
        try {
            con = connectivity.ConnectionProvider.getCon();
            Statement st = con.createStatement();            
            ResultSet rs = st.executeQuery("select * from rooms where room_id=" + roomId);
            while (rs.next()) {
                if (((String) rs.getString(1)).equals(roomId)) {                    
                    beds = rs.getInt(2);
                    booked = rs.getInt(3);
                    booked = booked + 1;
                    newfees = rs.getInt(5);
                    if (beds == booked) {
                        status = "Not Available";
                    }
                    if (rs.getString(8).equals("----")) {
                        bedposition = "1st";
                    } else if (rs.getString(9).equals("----")) {
                        bedposition = "2nd";
                    } else if (rs.getString(10).equals("----")) {
                        bedposition = "3rd";
                    } else if (rs.getString(11).equals("----")) {
                        bedposition = "4th";
                    }
                    Statement st1 = con.createStatement();
                    st1.executeUpdate("update rooms set beds_booked='" + booked + "', beds_available='" + (beds - booked) + "', status='" + status + "'," + bedposition + "='" + studentid + "' where room_id='" + roomId + "';");
                    tableDetails();
                    txtroomno.setText(txtnewroom.getText());
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void getfeeDetailse() {
        Connection con = ConnectionProvider.getCon();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from fees where id=" + txtid.getText());
            while (rs.next()) {
                oldfees = rs.getInt(2);
                txtsecuritymonet.setText("" + rs.getInt(2));
                ckbsecurity.setSelected(true);
                String templastdate = rs.getString(4);
                java.sql.Date sqldate = java.sql.Date.valueOf(templastdate);
                //java.util.Date utildate= new java.util.Date(sqldate.getTime());
                //System.out.println(utildate);
                //SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                //Date LastPaid=sdf.parse(templastdate);
                long monthsBetween = ChronoUnit.MONTHS.between(LocalDate.parse(rs.getString(4)).withDayOfMonth(1), LocalDate.now().withDayOfMonth(1));
                System.out.println(monthsBetween);
                if (monthsBetween == 0) {
                    ckbfees.setSelected(true);
                    txtmonthlyfees.setText("NO Dues");
                    canChangeRoom = true;
                } else {
                    txtmonthlyfees.setText("" + monthsBetween * rs.getInt(2));
                    ckbfees.setSelected(false);
                    canChangeRoom = false;
                }                
            }
        } catch (Exception e) {
        }
        txtmonthlyfees.setEditable(false);
        txtsecuritymonet.setEditable(false);        
    }

    void updateSecurity() {
        Connection con1 = ConnectionProvider.getCon();
        try {            
            PreparedStatement pst = con1.prepareStatement("update fees set security=? where id=" + stdId);
            pst.setInt(1, newfees);
            pst.executeUpdate();
            txtsecuritymonet.setText("" + newfees);
            if (oldfees > newfees) {
                JOptionPane.showMessageDialog(null, "Please '->Give<-' Rs " + (oldfees - newfees) + " to the Student");
                oldfees = newfees;
            } else if (newfees > oldfees) {
                JOptionPane.showMessageDialog(null, "Please '->Take<-' Rs " + (newfees - oldfees) + " to the Student");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlPersonal = new javax.swing.JPanel();
        lblfname = new javax.swing.JLabel();
        lblfather = new javax.swing.JLabel();
        lblmobile = new javax.swing.JLabel();
        lblmother = new javax.swing.JLabel();
        lbldob = new javax.swing.JLabel();
        lblfather1 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        lblmobile1 = new javax.swing.JLabel();
        lbladhar1 = new javax.swing.JLabel();
        txtfatheroccupation = new javax.swing.JTextField();
        lblmobile2 = new javax.swing.JLabel();
        lbladharpic = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtparentsmobile = new javax.swing.JTextField();
        txtdate = new javax.swing.JLabel();
        txtgender = new javax.swing.JLabel();
        txtfname = new javax.swing.JLabel();
        txtmother = new javax.swing.JLabel();
        txtadhar = new javax.swing.JLabel();
        btnpersonalsave = new javax.swing.JButton();
        lblwarning1 = new javax.swing.JLabel();
        lblback_personal = new javax.swing.JLabel();
        pnlAcadmic = new javax.swing.JPanel();
        txtdistrict = new javax.swing.JTextField();
        lbldistrict = new javax.swing.JLabel();
        lblpincode = new javax.swing.JLabel();
        txtpincode = new javax.swing.JTextField();
        txtstate = new javax.swing.JTextField();
        lblstate = new javax.swing.JLabel();
        lblvillege = new javax.swing.JLabel();
        txtinstute = new javax.swing.JTextField();
        txtcourse = new javax.swing.JTextField();
        lblclghead = new javax.swing.JLabel();
        lblinstute = new javax.swing.JLabel();
        lbladdress1 = new javax.swing.JLabel();
        lblcourse1 = new javax.swing.JLabel();
        txtvillege = new javax.swing.JTextField();
        btnacadmicsave = new javax.swing.JButton();
        lblwarning2 = new javax.swing.JLabel();
        lblback_education = new javax.swing.JLabel();
        pnlRooms = new javax.swing.JPanel();
        lblroomno = new javax.swing.JLabel();
        txtmonthlyfees = new javax.swing.JTextField();
        lblroomchange = new javax.swing.JLabel();
        lblnewroomno = new javax.swing.JLabel();
        lblroomdetails = new javax.swing.JLabel();
        btnchangeToNewRoom = new javax.swing.JButton();
        lblroomno4 = new javax.swing.JLabel();
        txtnewroom = new javax.swing.JTextField();
        txtsecuritymonet = new javax.swing.JTextField();
        ckbfees = new javax.swing.JCheckBox();
        ckbsecurity = new javax.swing.JCheckBox();
        txtroomno = new javax.swing.JTextField();
        btnchangeroom = new javax.swing.JButton();
        lblroomno6 = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChangeRoom = new javax.swing.JTable();
        lblback_room = new javax.swing.JLabel();
        btnclose = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        lblphoto = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        lblhead = new javax.swing.JLabel();
        btnsearch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblhblood = new javax.swing.JLabel();
        lblmobile3 = new javax.swing.JLabel();
        lblhname = new javax.swing.JLabel();
        lblhdob = new javax.swing.JLabel();
        lblhstatus = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        pnlPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfname.setText("Gender");
        pnlPersonal.add(lblfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 30));

        lblfather.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfather.setText("Father's Name");
        pnlPersonal.add(lblfather, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 110, 30));

        lblmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile.setText("Mobile Number");
        pnlPersonal.add(lblmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 110, 30));

        lblmother.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmother.setText("Mother's Name");
        pnlPersonal.add(lblmother, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, 30));

        lbldob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldob.setText("Date Of Birth");
        pnlPersonal.add(lbldob, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 100, 30));

        lblfather1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfather1.setText("Father's Occupation");
        pnlPersonal.add(lblfather1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 140, 30));

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 160, 30));

        lblmobile1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile1.setText("Payrent's mob No");
        pnlPersonal.add(lblmobile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 130, 30));

        lbladhar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladhar1.setText("Adhar Number");
        pnlPersonal.add(lbladhar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 110, 30));

        txtfatheroccupation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtfatheroccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 160, 30));

        lblmobile2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile2.setText("Email ID");
        pnlPersonal.add(lblmobile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 130, 30));
        pnlPersonal.add(lbladharpic, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 140));

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        pnlPersonal.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 240, 30));

        txtparentsmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtparentsmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 160, 30));

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 120, 30));

        txtgender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 120, 30));

        txtfname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 120, 30));

        txtmother.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtmother, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 120, 30));

        txtadhar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlPersonal.add(txtadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 120, 30));

        btnpersonalsave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnpersonalsave.setText("save");
        btnpersonalsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpersonalsaveActionPerformed(evt);
            }
        });
        pnlPersonal.add(btnpersonalsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 80, 30));

        lblwarning1.setForeground(new java.awt.Color(255, 0, 0));
        lblwarning1.setText("Please save the details before moving to the next section");
        pnlPersonal.add(lblwarning1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 290, 20));
        pnlPersonal.add(lblback_personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 330));

        jTabbedPane1.addTab("Personal Details          ", pnlPersonal);

        pnlAcadmic.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtdistrict.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlAcadmic.add(txtdistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 160, 30));

        lbldistrict.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldistrict.setText("District:-");
        pnlAcadmic.add(lbldistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 80, 30));

        lblpincode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblpincode.setText("Pincode:-");
        pnlAcadmic.add(lblpincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 80, 30));

        txtpincode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlAcadmic.add(txtpincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 160, 30));

        txtstate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlAcadmic.add(txtstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 160, 30));

        lblstate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblstate.setText("State:-");
        pnlAcadmic.add(lblstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 70, 30));

        lblvillege.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblvillege.setText("Villege:-");
        pnlAcadmic.add(lblvillege, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 80, 30));

        txtinstute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlAcadmic.add(txtinstute, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 280, 30));

        txtcourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlAcadmic.add(txtcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 140, 30));

        lblclghead.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblclghead.setText("Enter College/Instute Details:-");
        pnlAcadmic.add(lblclghead, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 220, 30));

        lblinstute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblinstute.setText("Instute Name:-");
        pnlAcadmic.add(lblinstute, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 120, 30));

        lbladdress1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladdress1.setText("Enter Permanent Address:-");
        pnlAcadmic.add(lbladdress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 200, 30));

        lblcourse1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcourse1.setText("Course:-");
        pnlAcadmic.add(lblcourse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 60, 30));

        txtvillege.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlAcadmic.add(txtvillege, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 160, 30));

        btnacadmicsave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnacadmicsave.setText("Save");
        btnacadmicsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnacadmicsaveActionPerformed(evt);
            }
        });
        pnlAcadmic.add(btnacadmicsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 80, 30));

        lblwarning2.setForeground(new java.awt.Color(255, 0, 0));
        lblwarning2.setText("Please save the details before moving to the next section");
        pnlAcadmic.add(lblwarning2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 290, 20));
        pnlAcadmic.add(lblback_education, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 330));

        jTabbedPane1.addTab("     Acadmic And Address      ", pnlAcadmic);

        pnlRooms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblroomno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblroomno.setText("Your Room Number is:-");
        pnlRooms.add(lblroomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 30));

        txtmonthlyfees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlRooms.add(txtmonthlyfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 120, 30));

        lblroomchange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblroomchange.setText("Please Choose one of the following rooms");
        pnlRooms.add(lblroomchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 330, 30));

        lblnewroomno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblnewroomno.setText("Enter new Room Number");
        pnlRooms.add(lblnewroomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 190, 30));

        lblroomdetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblroomdetails.setText("Your Fees details:-");
        pnlRooms.add(lblroomdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 30));

        btnchangeToNewRoom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnchangeToNewRoom.setText("Click Here To Change");
        btnchangeToNewRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeToNewRoomActionPerformed(evt);
            }
        });
        pnlRooms.add(btnchangeToNewRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 300, 30));

        lblroomno4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblroomno4.setText("Available Security Money");
        pnlRooms.add(lblroomno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 190, 30));

        txtnewroom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlRooms.add(txtnewroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 100, 30));

        txtsecuritymonet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlRooms.add(txtsecuritymonet, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 120, 30));

        ckbfees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ckbfees.setText("paid");
        ckbfees.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ckbfeesFocusLost(evt);
            }
        });
        pnlRooms.add(ckbfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        ckbsecurity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ckbsecurity.setText("paid");
        pnlRooms.add(ckbsecurity, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        txtroomno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlRooms.add(txtroomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 120, 30));

        btnchangeroom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnchangeroom.setText("Chnage Room");
        btnchangeroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeroomActionPerformed(evt);
            }
        });
        pnlRooms.add(btnchangeroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 30));

        lblroomno6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblroomno6.setText("Monthly fees Dues");
        pnlRooms.add(lblroomno6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 140, 30));

        pnlTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblChangeRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room Number", "Total Beds", "Available Beds", "Fees"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblChangeRoom);

        pnlTable.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 410, 150));

        pnlRooms.add(pnlTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 410, 170));
        pnlRooms.add(lblback_room, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 330));

        jTabbedPane1.addTab("     Rooms And Payments     ", pnlRooms);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 840, 360));

        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 70, 70));

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 100, 30));

        lblid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblid.setText("Enter ID");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 70, 30));
        getContentPane().add(lblphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 130));

        btnedit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnedit.setText("Edit Profile");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 110, 30));

        lblhead.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        lblhead.setText("welcome to your profile");
        getContentPane().add(lblhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 510, 40));

        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 80, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Reset");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, -1, 30));

        lblhblood.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 170, 20));

        lblmobile3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile3.setText("Mobile Number");
        getContentPane().add(lblmobile3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 110, 30));

        lblhname.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 190, 20));

        lblhdob.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, 20));

        lblhstatus.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 120, 20));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setBounds(170, 150, 841, 500);
        lblwarning1.setVisible(false);
        lblwarning2.setVisible(false);
        btnpersonalsave.setVisible(false);
        btnacadmicsave.setVisible(false);
        
    }//GEN-LAST:event_formWindowActivated

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        HomePage.profile=true;
        setVisible(false);
    }//GEN-LAST:event_btncloseActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        unLock();
        
    }//GEN-LAST:event_btneditActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        stdId = txtid.getText();
        checkStudentRoom();
        getfeeDetailse();
        Connection con;
        String father, mother, dob, adharno, gender;
        byte image[], adhar[];
        try {
            con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admission where std_id=" + stdId);
            while (rs.next()) {
                fname = rs.getString(2);
                lblhead.setText("Welcome Back " + fname + "!");
                lname = rs.getString(3);
                lblhname.setText("Name: " + fname + " " + lname);
                gender = rs.getString(4);
                txtgender.setText(gender);
                dob = rs.getString(5);
                lblhdob.setText("DOB: " + dob);
                txtdate.setText(dob);
                father = rs.getString(6);
                txtfname.setText(father);
                mother = rs.getString(7);
                txtmother.setText(mother);
                foccupation = rs.getString(8);
                txtfatheroccupation.setText(foccupation);
                pmobile = rs.getString(9);
                txtparentsmobile.setText(pmobile);
                adharno = rs.getString(10);
                txtadhar.setText(adharno);
                adhar = rs.getBytes(11);
                ImageIcon tadhar = new ImageIcon(adhar);
                Image img2 = tadhar.getImage();
                Image formated = img2.getScaledInstance(lbladharpic.getWidth(), lbladharpic.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledadhar = new ImageIcon(formated);
                lbladharpic.setIcon(scaledadhar);
                
                mobile = rs.getString(12);
                txtmobile.setText(mobile);
                email = rs.getString(13);
                txtemail.setText(email);
                institute = rs.getString(14);
                txtinstute.setText(institute);
                course = rs.getString(15);
                txtcourse.setText(course);
                villege = rs.getString(16);
                txtvillege.setText(villege);
                district = rs.getString(17);
                txtdistrict.setText(district);
                pincode = rs.getString(18);
                txtpincode.setText(pincode);
                state = rs.getString(19);
                txtstate.setText(state);
                //datedob.setDateFormatString(dob);
                image = rs.getBytes(20);
                ImageIcon iif = new ImageIcon(image);
                Image img1 = iif.getImage();
                Image format = img1.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(format);
                lblphoto.setIcon(scaledImage);
                String blood = rs.getString(21);
                lblhblood.setText("Blood Group: " + blood);
                checkStatus(stdId);
                lock();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        txtnewroom.setVisible(false);
        pnlTable.setVisible(false);
        lblnewroomno.setVisible(false);
        lblroomchange.setVisible(false);
        btnchangeToNewRoom.setVisible(false);
        
    }//GEN-LAST:event_btnsearchActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txtnewroom.setVisible(false);
        pnlTable.setVisible(false);
        lblnewroomno.setVisible(false);
        lblroomchange.setVisible(false);
        btnchangeToNewRoom.setVisible(false);
        ckbfees.setSelected(false);
        ckbsecurity.setSelected(false);
        txtmonthlyfees.setText("");
        txtsecuritymonet.setText("");
    }//GEN-LAST:event_formWindowOpened

    private void btnchangeroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeroomActionPerformed
        if (canChangeRoom) {
            txtnewroom.setVisible(true);
            pnlTable.setVisible(true);
            lblnewroomno.setVisible(true);
            lblroomchange.setVisible(true);
            btnchangeToNewRoom.setVisible(true);
            tableDetails();
        } else
        JOptionPane.showMessageDialog(null, "Please! Clear Your Dues, You are not eligible to change the Room.");
    }//GEN-LAST:event_btnchangeroomActionPerformed

    private void ckbfeesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ckbfeesFocusLost
        ckbfees.setSelected(canChangeRoom);
    }//GEN-LAST:event_ckbfeesFocusLost

    private void btnchangeToNewRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeToNewRoomActionPerformed
        deleteStudentFromRoom();
        allotRoom();
        updateSecurity();
        tableDetails();
        txtnewroom.setVisible(false);
        pnlTable.setVisible(false);
        lblnewroomno.setVisible(false);
        lblroomchange.setVisible(false);
        btnchangeToNewRoom.setVisible(false);
        txtnewroom.setText(null);
    }//GEN-LAST:event_btnchangeToNewRoomActionPerformed

    private void btnacadmicsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnacadmicsaveActionPerformed
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update admission set institute=?, course=?, villege=?, district=?, pincode=?,state=? where std_id=" + stdId);
            ps.setString(1, txtinstute.getText());
            ps.setString(2, txtcourse.getText());
            ps.setString(3, txtvillege.getText());
            ps.setString(4, txtdistrict.getText());
            ps.setString(5, txtpincode.getText());
            ps.setString(6, txtstate.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            lblwarning1.setVisible(false);
            btnpersonalsave.setVisible(false);
            lock();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnacadmicsaveActionPerformed

    private void btnpersonalsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpersonalsaveActionPerformed
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update admission set father_occupation=?, parents_mob=?, mobile=?, email=? where std_id=" + stdId);
            ps.setString(1, txtfatheroccupation.getText());
            ps.setString(2, txtparentsmobile.getText());
            ps.setString(3, txtmobile.getText());
            ps.setString(4, txtemail.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            lock();
            lblwarning1.setVisible(false);
            btnpersonalsave.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnpersonalsaveActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentProfile().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnacadmicsave;
    private javax.swing.JButton btnchangeToNewRoom;
    private javax.swing.JButton btnchangeroom;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnpersonalsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JCheckBox ckbfees;
    private javax.swing.JCheckBox ckbsecurity;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbladdress1;
    private javax.swing.JLabel lbladhar1;
    private javax.swing.JLabel lbladharpic;
    private javax.swing.JLabel lblback_education;
    private javax.swing.JLabel lblback_personal;
    private javax.swing.JLabel lblback_room;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblclghead;
    private javax.swing.JLabel lblcourse1;
    private javax.swing.JLabel lbldistrict;
    private javax.swing.JLabel lbldob;
    private javax.swing.JLabel lblfather;
    private javax.swing.JLabel lblfather1;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblhblood;
    private javax.swing.JLabel lblhdob;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblhname;
    private javax.swing.JLabel lblhstatus;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblinstute;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblmobile1;
    private javax.swing.JLabel lblmobile2;
    private javax.swing.JLabel lblmobile3;
    private javax.swing.JLabel lblmother;
    private javax.swing.JLabel lblnewroomno;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel lblpincode;
    private javax.swing.JLabel lblroomchange;
    private javax.swing.JLabel lblroomdetails;
    private javax.swing.JLabel lblroomno;
    private javax.swing.JLabel lblroomno4;
    private javax.swing.JLabel lblroomno6;
    private javax.swing.JLabel lblstate;
    private javax.swing.JLabel lblvillege;
    private javax.swing.JLabel lblwarning1;
    private javax.swing.JLabel lblwarning2;
    private javax.swing.JPanel pnlAcadmic;
    private javax.swing.JPanel pnlPersonal;
    private javax.swing.JPanel pnlRooms;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JTable tblChangeRoom;
    private javax.swing.JLabel txtadhar;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JLabel txtdate;
    private javax.swing.JTextField txtdistrict;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfatheroccupation;
    private javax.swing.JLabel txtfname;
    private javax.swing.JLabel txtgender;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtinstute;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtmonthlyfees;
    private javax.swing.JLabel txtmother;
    private javax.swing.JTextField txtnewroom;
    private javax.swing.JTextField txtparentsmobile;
    private javax.swing.JTextField txtpincode;
    private javax.swing.JTextField txtroomno;
    private javax.swing.JTextField txtsecuritymonet;
    private javax.swing.JTextField txtstate;
    private javax.swing.JTextField txtvillege;
    // End of variables declaration//GEN-END:variables
}