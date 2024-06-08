package student;

import room.AllotRoom;
import java.sql.Connection;
import connectivity.ConnectionProvider;
import home.HomePage;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


/**
 *
 * @author ritesh Singh
 */

public class Admission extends javax.swing.JFrame {

    public static String studentId ="",roomDetails="-----";
    public static boolean roomDetailsStatus=false;
    int fees=0;
    
    File adharFile, photoFile;
    byte[] image, adharpic;
    String fname, lname, father, mother, mobile, dob, adharno, gender, stdId, pathdp;
    String foccupation, pmobile, email, institute, course, villege, district, pincode, state,blood;

    /**
     * Creates new form Admission_first
     */
    public Admission() {
        initComponents();
        scallBackground();
        scallBack1();
        scallBack2();
        scallCross();
    }
    public final void scallCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Exit_big.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnclose.getWidth(), btnclose.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnclose.setIcon(finalImage);
    }
     public final void scallBackground()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\pages background.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
    }
     public final void scallBack1()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\pages background.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblback1.getWidth(), lblback1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblback1.setIcon(finalImage);
    }
      public final void scallBack2()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\pages background.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblback2.getWidth(), lblback2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblback2.setIcon(finalImage);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlfirst = new javax.swing.JPanel();
        lblfname = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        txtdob = new javax.swing.JTextField();
        lbllname = new javax.swing.JLabel();
        lblfather = new javax.swing.JLabel();
        txtfather = new javax.swing.JTextField();
        txtmother = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        lblmobile = new javax.swing.JLabel();
        lbladhar = new javax.swing.JLabel();
        txtadhar = new javax.swing.JTextField();
        lblmother = new javax.swing.JLabel();
        lbldob = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        btnbrowse = new javax.swing.JButton();
        lblfname1 = new javax.swing.JLabel();
        rdofemale = new javax.swing.JRadioButton();
        rdomale = new javax.swing.JRadioButton();
        lblfather1 = new javax.swing.JLabel();
        txtfatheroccu = new javax.swing.JTextField();
        txtparentmob = new javax.swing.JTextField();
        lblmobile1 = new javax.swing.JLabel();
        lbladhar1 = new javax.swing.JLabel();
        txtadharpath = new javax.swing.JTextField();
        lblmother1 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblmobile2 = new javax.swing.JLabel();
        btnsearch = new javax.swing.JButton();
        lblphoto = new javax.swing.JLabel();
        btnnext = new javax.swing.JButton();
        txtlname = new javax.swing.JTextField();
        lblmobile3 = new javax.swing.JLabel();
        cmbBloodGroup = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        rdono = new javax.swing.JRadioButton();
        rdoyes = new javax.swing.JRadioButton();
        lblback1 = new javax.swing.JLabel();
        pnlsecond = new javax.swing.JPanel();
        txttotalamt = new javax.swing.JTextField();
        txtdistrict = new javax.swing.JTextField();
        lbldistrict = new javax.swing.JLabel();
        lblpincode = new javax.swing.JLabel();
        txtpincode = new javax.swing.JTextField();
        txtstate = new javax.swing.JTextField();
        lblstate = new javax.swing.JLabel();
        lbladdress = new javax.swing.JLabel();
        lblvillege = new javax.swing.JLabel();
        txtinstute = new javax.swing.JTextField();
        txtcourse = new javax.swing.JTextField();
        lblcourse = new javax.swing.JLabel();
        lblclghead = new javax.swing.JLabel();
        lblinstute = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        btntakeadmission = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbladdress1 = new javax.swing.JLabel();
        lblcourse1 = new javax.swing.JLabel();
        lblcourse2 = new javax.swing.JLabel();
        txtvillege = new javax.swing.JTextField();
        txtsecurity = new javax.swing.JTextField();
        lblcourse3 = new javax.swing.JLabel();
        txtfirstfees = new javax.swing.JTextField();
        lblcourse4 = new javax.swing.JLabel();
        ckbpayment = new javax.swing.JCheckBox();
        lblroomdetails = new javax.swing.JLabel();
        lblback2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnclose = new javax.swing.JButton();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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

        pnlfirst.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblfname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfname.setText("Gender");
        pnlfirst.add(lblfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 30));

        txtfname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 160, 30));

        txtdob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 160, 30));

        lbllname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllname.setText("Last Name");
        pnlfirst.add(lbllname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 80, 30));

        lblfather.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfather.setText("Father's Name");
        pnlfirst.add(lblfather, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, 30));

        txtfather.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtfather, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 160, 30));

        txtmother.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtmother, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 160, 30));

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 160, 30));

        lblmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile.setText("Mobile Number");
        pnlfirst.add(lblmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 110, 30));

        lbladhar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladhar.setText("Adhar Number");
        pnlfirst.add(lbladhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 110, 30));

        txtadhar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtadhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadharActionPerformed(evt);
            }
        });
        pnlfirst.add(txtadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 160, 30));

        lblmother.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmother.setText("Mother's Name");
        pnlfirst.add(lblmother, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 110, 30));

        lbldob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldob.setText("Date Of Birth");
        pnlfirst.add(lbldob, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 100, 30));

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtidFocusLost(evt);
            }
        });
        pnlfirst.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 100, 30));

        lblid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblid.setText("Enter ID");
        pnlfirst.add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 30));

        btnbrowse.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnbrowse.setText("Browse");
        btnbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowseActionPerformed(evt);
            }
        });
        pnlfirst.add(btnbrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 70, 30));

        lblfname1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfname1.setText("First Name");
        pnlfirst.add(lblfname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 30));

        buttonGroup1.add(rdofemale);
        rdofemale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdofemale.setText("Female");
        rdofemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdofemaleActionPerformed(evt);
            }
        });
        pnlfirst.add(rdofemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        buttonGroup1.add(rdomale);
        rdomale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdomale.setText("Male");
        rdomale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdomaleActionPerformed(evt);
            }
        });
        pnlfirst.add(rdomale, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        lblfather1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfather1.setText("Father's Occupation");
        pnlfirst.add(lblfather1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 140, 30));

        txtfatheroccu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtfatheroccu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 160, 30));

        txtparentmob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtparentmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 160, 30));

        lblmobile1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile1.setText("Payrent's mob No");
        pnlfirst.add(lblmobile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 130, 30));

        lbladhar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladhar1.setText("Adhar Number");
        pnlfirst.add(lbladhar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 110, 30));

        txtadharpath.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtadharpath, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 160, 30));

        lblmother1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmother1.setText("Upload Adhar");
        pnlfirst.add(lblmother1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 110, 30));

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 160, 30));

        lblmobile2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile2.setText("Email ID");
        pnlfirst.add(lblmobile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 100, 30));

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_btn.png"))); // NOI18N
        btnsearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        pnlfirst.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 50, 30));
        pnlfirst.add(lblphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 110, 130));

        btnnext.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        pnlfirst.add(btnnext, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, -1, 40));

        txtlname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlfirst.add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 160, 30));

        lblmobile3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile3.setText("Select Blood Group");
        pnlfirst.add(lblmobile3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 140, 30));

        cmbBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbBloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-", " ", " " }));
        pnlfirst.add(cmbBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 160, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Started Living");
        pnlfirst.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 120, 30));

        buttonGroup2.add(rdono);
        rdono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdono.setText("No");
        pnlfirst.add(rdono, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        buttonGroup2.add(rdoyes);
        rdoyes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoyes.setText("Yes");
        rdoyes.setIconTextGap(6);
        rdoyes.setInheritsPopupMenu(true);
        pnlfirst.add(rdoyes, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, -1, -1));
        pnlfirst.add(lblback1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 840, 420));

        getContentPane().add(pnlfirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 840, 410));

        pnlsecond.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txttotalamt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txttotalamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 80, 30));

        txtdistrict.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtdistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 160, 30));

        lbldistrict.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldistrict.setText("District:-");
        pnlsecond.add(lbldistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 80, 30));

        lblpincode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblpincode.setText("Pincode:-");
        pnlsecond.add(lblpincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 80, 30));

        txtpincode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtpincode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 160, 30));

        txtstate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 160, 30));

        lblstate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblstate.setText("State:-");
        pnlsecond.add(lblstate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 70, 30));

        lbladdress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladdress.setText("Room Allotment & Payments:-");
        pnlsecond.add(lbladdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 220, 30));

        lblvillege.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblvillege.setText("Villege:-");
        pnlsecond.add(lblvillege, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 80, 30));

        txtinstute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtinstute, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 160, 30));

        txtcourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 160, 30));

        lblcourse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcourse.setText("Total Amount");
        pnlsecond.add(lblcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 100, 30));

        lblclghead.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblclghead.setText("Enter College/Instute Details:-");
        pnlsecond.add(lblclghead, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 220, 30));

        lblinstute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblinstute.setText("Instute Name:-");
        pnlsecond.add(lblinstute, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 120, 30));

        btnback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        pnlsecond.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 373, -1, 40));

        btntakeadmission.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntakeadmission.setText("Take Admisssion");
        btntakeadmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntakeadmissionActionPerformed(evt);
            }
        });
        pnlsecond.add(btntakeadmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 160, 40));

        btnclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnclear.setText("Clear");
        pnlsecond.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 170, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("View Rooms");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlsecond.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 130, 30));

        lbladdress1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladdress1.setText("Enter Permanent Address:-");
        pnlsecond.add(lbladdress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 200, 30));

        lblcourse1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcourse1.setText("Course:-");
        pnlsecond.add(lblcourse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 80, 30));

        lblcourse2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcourse2.setText("Mark as Payment Done");
        pnlsecond.add(lblcourse2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 170, 30));

        txtvillege.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtvillege, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 160, 30));

        txtsecurity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtsecurity, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 80, 30));

        lblcourse3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcourse3.setText("1st Month Fees");
        pnlsecond.add(lblcourse3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 110, 30));

        txtfirstfees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(txtfirstfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 80, 30));

        lblcourse4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblcourse4.setText("Security Money");
        pnlsecond.add(lblcourse4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 110, 30));

        ckbpayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(ckbpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 30, 30));

        lblroomdetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pnlsecond.add(lblroomdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 290, 30));
        pnlsecond.add(lblback2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 430));

        getContentPane().add(pnlsecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 840, 430));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setText("Hostel Admission Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 350, 60));

        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 70, 70));

        lblbackground.setBackground(new java.awt.Color(255, 0, 0));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        HomePage.admission=true;
        setVisible(false);
    }//GEN-LAST:event_btncloseActionPerformed

    private void rdomaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdomaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdomaleActionPerformed

    private void rdofemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdofemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdofemaleActionPerformed

    private void btnbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowseActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        adharFile = jfc.getSelectedFile();
    }//GEN-LAST:event_btnbrowseActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        
            pnlfirst.setVisible(false);
            pnlsecond.setVisible(true);
       
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        pnlsecond.setVisible(false);
        pnlfirst.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setBounds(170, 150, 841, 500);
        //pnlsecond.setVisible(false);
        
        if(roomDetailsStatus)
        {
            
            lblroomdetails.setText("Room Number "+roomDetails+" is alloted To you");
            lblroomdetails.setForeground(Color.GREEN);
            lblroomdetails.setVisible(true);
            
            try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from rooms where room_id="+roomDetails);
            while(rs.next())
            {
            fees=rs.getInt(5);
            }
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
                System.out.println(e);
            }
            txtsecurity.setText(""+fees);
            txtfirstfees.setText(""+fees);
            txttotalamt.setText(""+(fees*2));
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed

        Connection con;
        stdId = txtid.getText();
        
        boolean b=validator.Validator.validateRegistration(stdId);
        if(b==false)
        {
            JOptionPane.showMessageDialog(null, "ID is not registered");
            txtid.requestFocus();
        }
        
        try {
            con = ConnectionProvider.getCon();
            if(con==null)
            {
                return;
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from studentregistrations where std_id=" + stdId);
            while (rs.next()) {
                fname = rs.getString(2);
                txtfname.setText(fname);
                lname = rs.getString(3);
                txtlname.setText(lname);
                father = rs.getString(4);
                txtfather.setText(father);
                mother = rs.getString(5);
                txtmother.setText(mother);
                mobile = rs.getString(6);
                txtmobile.setText(mobile);
                dob = rs.getString(7);
                txtdob.setText(dob);
                adharno = rs.getString(8);
                txtadhar.setText(adharno);
                gender = rs.getString(9);
                if (gender.equals("Male")) {
                    rdomale.setSelected(true);
                } else {
                    rdofemale.setSelected(true);
                }
                image = rs.getBytes(10);
                ImageIcon iif = new ImageIcon(image);
                Image img1 = iif.getImage();
                Image format = img1.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(format);
                lblphoto.setIcon(scaledImage);
                
                pathdp = rs.getString(11);
                System.out.println(pathdp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtadharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadharActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadharActionPerformed

    private void btntakeadmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntakeadmissionActionPerformed
        if(ckbpayment.isSelected()!=true)
        {
            JOptionPane.showMessageDialog(null,"Check for cash payments before taking admission");
            return;
        }
        Connection con;
        mobile = txtmobile.getText();
        foccupation = txtfatheroccu.getText();
        pmobile = txtparentmob.getText();
        email = txtemail.getText();
        institute = txtinstute.getText();
        course = txtcourse.getText();
        villege = txtvillege.getText();
        district = txtdistrict.getText();
        pincode = txtpincode.getText();
        state = txtstate.getText();
        String path = adharFile.getAbsolutePath();
        blood=(String)cmbBloodGroup.getSelectedItem();

        try {
            con = connectivity.ConnectionProvider.getCon();
            PreparedStatement pst = con.prepareStatement("insert into admission values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, stdId);
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, gender);
            pst.setString(5, dob);
            pst.setString(6, father);
            pst.setString(7, mother);
            pst.setString(8, foccupation);
            pst.setString(9, pmobile);
            pst.setString(10, adharno);
            FileInputStream fis = new FileInputStream(adharFile);
            pst.setBinaryStream(11, fis);
            pst.setString(12, mobile);
            pst.setString(13, email);
            pst.setString(14, institute);
            pst.setString(15, course);
            pst.setString(16, villege);
            pst.setString(17, district);
            pst.setString(18, pincode);
            pst.setString(19, state);
            FileInputStream fis1 = new FileInputStream(pathdp);
            pst.setBinaryStream(20, fis1);
            pst.setString(21, blood);
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            Connection con1=ConnectionProvider.getCon();
            PreparedStatement pst=con1.prepareStatement("insert into fees values(?,?,?,?,?,?)");
            pst.setString(1, stdId);
            pst.setInt(2, fees);
            //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-DD");
            Date date=new Date();
            java.sql.Date sqldate=new java.sql.Date(date.getTime());
            pst.setDate(3, sqldate);
            pst.setDate(4, sqldate);
            pst.setString(5, "No");
            pst.setInt(6, 0);
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String Status="Present";
            if(rdono.isSelected())
            {
                Status="Absent";
            }
            Connection con2=ConnectionProvider.getCon();
            PreparedStatement pst=con2.prepareStatement("insert into leaves values(?,?,?)");
            Date date=new Date();
            java.sql.Date sqldate=new java.sql.Date(date.getTime());
            pst.setString(1, stdId);
            pst.setDate(2, sqldate);
            pst.setString(3,Status);
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        JOptionPane.showMessageDialog(null, "Admission Successful");
    }//GEN-LAST:event_btntakeadmissionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        studentId = stdId;
        AllotRoom obj=new AllotRoom();
        
        new AllotRoom().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        pnlsecond.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void txtidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidFocusLost
        
    }//GEN-LAST:event_txtidFocusLost

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
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admission().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnbrowse;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btntakeadmission;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox ckbpayment;
    private javax.swing.JComboBox<String> cmbBloodGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbladdress;
    private javax.swing.JLabel lbladdress1;
    private javax.swing.JLabel lbladhar;
    private javax.swing.JLabel lbladhar1;
    private javax.swing.JLabel lblback1;
    private javax.swing.JLabel lblback2;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblclghead;
    private javax.swing.JLabel lblcourse;
    private javax.swing.JLabel lblcourse1;
    private javax.swing.JLabel lblcourse2;
    private javax.swing.JLabel lblcourse3;
    private javax.swing.JLabel lblcourse4;
    private javax.swing.JLabel lbldistrict;
    private javax.swing.JLabel lbldob;
    private javax.swing.JLabel lblfather;
    private javax.swing.JLabel lblfather1;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblfname1;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblinstute;
    private javax.swing.JLabel lbllname;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblmobile1;
    private javax.swing.JLabel lblmobile2;
    private javax.swing.JLabel lblmobile3;
    private javax.swing.JLabel lblmother;
    private javax.swing.JLabel lblmother1;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel lblpincode;
    private javax.swing.JLabel lblroomdetails;
    private javax.swing.JLabel lblstate;
    private javax.swing.JLabel lblvillege;
    private javax.swing.JPanel pnlfirst;
    private javax.swing.JPanel pnlsecond;
    private javax.swing.JRadioButton rdofemale;
    private javax.swing.JRadioButton rdomale;
    private javax.swing.JRadioButton rdono;
    private javax.swing.JRadioButton rdoyes;
    private javax.swing.JTextField txtadhar;
    private javax.swing.JTextField txtadharpath;
    private javax.swing.JTextField txtcourse;
    private javax.swing.JTextField txtdistrict;
    private javax.swing.JTextField txtdob;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfather;
    private javax.swing.JTextField txtfatheroccu;
    private javax.swing.JTextField txtfirstfees;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtinstute;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtmother;
    private javax.swing.JTextField txtparentmob;
    private javax.swing.JTextField txtpincode;
    private javax.swing.JTextField txtsecurity;
    private javax.swing.JTextField txtstate;
    private javax.swing.JTextField txttotalamt;
    private javax.swing.JTextField txtvillege;
    // End of variables declaration//GEN-END:variables
}