package home;

import admin_base.AdminProfile;
import admin_base.Login;
import room.ManageRooms;
import payment.PaymentSystem;
import student.DuesList;
import student.DeleteStudent;
import student.AllStudents;
import student.Admission;
import student.StudentLeaves;
import student.StudentRegistration;
import student.StudentProfile;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author ritesh_Singh
 */

public class HomePage extends javax.swing.JFrame {
    public static Admission obj;
    public int z=0;
    public static boolean admin=false,dashboard=false,payment=false,room=false,admission=false,allstd=false,deletestd=false,dues=false,leave=false,profile=false,registration=false;
    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
        btnabsentstd.setVisible(false);
        btnadmission.setVisible(false);
        btndues.setVisible(false);
        btngrantleave.setVisible(false);
        btnlogout.setVisible(false);
        btnpresentstd.setVisible(false);
        btnregister.setVisible(false);
        btnupdate.setVisible(false);
        btnAdmin.setVisible(false);
        btnexit.setVisible(false);
        lbladmission.setVisible(false);
        lbldues.setVisible(false);
        lblexit.setVisible(false);
        lblleave.setVisible(false);
        lbldeletestd.setVisible(false);
        lbllogout.setVisible(false);
        lblallstd.setVisible(false);
        lblregister.setVisible(false);
        lblprofile.setVisible(false);
        lbladminprofile.setVisible(false);
        lblexit.setVisible(false);
        
        scallCross();
        scallDashboard();
        scallPayment();
        scallDuesList();
        scallAdmission();
        scallApproved();
        scallAboutUs();
        scallAllStudent();
        scallHomeBackground();
        scallAdmin();
        scallNevigator1();
        //scallLeave();
    }
    public final void scallHomeBackground()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\back_s4.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblHomeBack.getWidth(), lblHomeBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblHomeBack.setIcon(finalImage);
    }
    public final void scallCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Exit_big.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnexit.getWidth(), btnexit.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnexit.setIcon(finalImage);
    }
    public final void scallAdmin()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\admin_3.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnAdmin.getWidth(), btnAdmin.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnAdmin.setIcon(finalImage);
    }
    public final void scallDashboard()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Dashboard_1.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btndashboard.getWidth(), btndashboard.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btndashboard.setIcon(finalImage);
    }
    public final void scallPayment()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\payment_big.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnpayment.getWidth(), btnpayment.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnpayment.setIcon(finalImage);
    }
    
     public final void scallAboutUs()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\aboutus.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnabout.getWidth(), btnabout.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnabout.setIcon(finalImage);
    }
    
    public final void scallDuesList()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\duesList.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btndues.getWidth(), btndues.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btndues.setIcon(finalImage);
    }
    public final void scallAdmission()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\admission.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnadmission.getWidth(), btnadmission.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnadmission.setIcon(finalImage);
    }
    public final void scallApproved()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\PermitsApproved.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btngrantleave.getWidth()-5, btngrantleave.getHeight()-5, Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btngrantleave.setIcon(finalImage);
    }
    public final void scallAllStudent()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\list_students.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnpresentstd.getWidth()-5, btnpresentstd.getHeight()-5, Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnpresentstd.setIcon(finalImage);
    }
    public final void scallLeave()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\leave_std - Copy.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnabsentstd.getWidth()-30, btnabsentstd.getHeight()-5, Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnabsentstd.setIcon(finalImage);
    }
    public final void scallNevigator1()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\arrow_front.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnnavigation.getWidth(), btnnavigation.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnnavigation.setIcon(finalImage);
    }
    public final void scallNevigator2()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\arrow_back.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnnavigation.getWidth(), btnnavigation.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnnavigation.setIcon(finalImage);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnexit = new javax.swing.JButton();
        lblregister = new javax.swing.JLabel();
        lbladmission = new javax.swing.JLabel();
        lblprofile = new javax.swing.JLabel();
        lbldues = new javax.swing.JLabel();
        lblleave = new javax.swing.JLabel();
        lblallstd = new javax.swing.JLabel();
        lbldeletestd = new javax.swing.JLabel();
        lbladminprofile = new javax.swing.JLabel();
        lbllogout = new javax.swing.JLabel();
        lblexit = new javax.swing.JLabel();
        lblnevigator = new javax.swing.JLabel();
        btnnavigation = new javax.swing.JToggleButton();
        btnregister = new javax.swing.JButton();
        btnadmission = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndues = new javax.swing.JButton();
        btngrantleave = new javax.swing.JButton();
        btnpresentstd = new javax.swing.JButton();
        btnabsentstd = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        btnabout = new javax.swing.JButton();
        btnregister2 = new javax.swing.JButton();
        btndashboard = new javax.swing.JButton();
        btnpayment = new javax.swing.JButton();
        btnfood = new javax.swing.JButton();
        lblaboutus = new javax.swing.JLabel();
        lblroom = new javax.swing.JLabel();
        lbldashboard = new javax.swing.JLabel();
        lblfood = new javax.swing.JLabel();
        lblpayment = new javax.swing.JLabel();
        lblhead = new javax.swing.JLabel();
        lblHomeBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnexit.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnexitComponentShown(evt);
            }
        });
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 100, 80));

        lblregister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblregister.setText("Register");
        getContentPane().add(lblregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 70, 30));

        lbladmission.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladmission.setText("Admission");
        getContentPane().add(lbladmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 30));

        lblprofile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblprofile.setText("Student Profile");
        getContentPane().add(lblprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 100, 30));

        lbldues.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldues.setText("Dues List");
        getContentPane().add(lbldues, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 70, 30));

        lblleave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblleave.setText("Leave Approval");
        getContentPane().add(lblleave, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 100, 30));

        lblallstd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblallstd.setText("All Students");
        getContentPane().add(lblallstd, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 100, 30));

        lbldeletestd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldeletestd.setText("Delete Students");
        getContentPane().add(lbldeletestd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 110, 30));

        lbladminprofile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladminprofile.setText("Admin Profile");
        getContentPane().add(lbladminprofile, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 90, 30));

        lbllogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbllogout.setText("Log Out");
        getContentPane().add(lbllogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 70, 30));

        lblexit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblexit.setText("Exit Application");
        getContentPane().add(lblexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 90, 100, 30));

        lblnevigator.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnevigator.setText("Nevigation Bar");
        getContentPane().add(lblnevigator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 30));

        btnnavigation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnavigationActionPerformed(evt);
            }
        });
        getContentPane().add(btnnavigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 80));

        btnregister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register_std1.png"))); // NOI18N
        btnregister.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnregisterComponentShown(evt);
            }
        });
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 90, 80));

        btnadmission.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnadmissionComponentShown(evt);
            }
        });
        btnadmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadmissionActionPerformed(evt);
            }
        });
        getContentPane().add(btnadmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 90, 80));

        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update.png"))); // NOI18N
        btnupdate.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnupdateComponentShown(evt);
            }
        });
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 90, 80));

        btndues.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnduesComponentShown(evt);
            }
        });
        btndues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnduesActionPerformed(evt);
            }
        });
        getContentPane().add(btndues, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 90, 80));

        btngrantleave.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btngrantleaveComponentShown(evt);
            }
        });
        btngrantleave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngrantleaveActionPerformed(evt);
            }
        });
        getContentPane().add(btngrantleave, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, 80));

        btnpresentstd.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnpresentstdComponentShown(evt);
            }
        });
        btnpresentstd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpresentstdActionPerformed(evt);
            }
        });
        getContentPane().add(btnpresentstd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 100, 80));

        btnabsentstd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove_user.png"))); // NOI18N
        btnabsentstd.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnabsentstdComponentShown(evt);
            }
        });
        btnabsentstd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnabsentstdActionPerformed(evt);
            }
        });
        getContentPane().add(btnabsentstd, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 110, 80));

        btnAdmin.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnAdminComponentShown(evt);
            }
        });
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 90, 80));

        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        btnlogout.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnlogoutComponentShown(evt);
            }
        });
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 90, 80));

        btnabout.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnaboutComponentShown(evt);
            }
        });
        btnabout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaboutActionPerformed(evt);
            }
        });
        getContentPane().add(btnabout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 90, 80));

        btnregister2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rooms_btn.png"))); // NOI18N
        btnregister2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnregister2ComponentShown(evt);
            }
        });
        btnregister2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregister2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnregister2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 80));

        btndashboard.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btndashboardComponentShown(evt);
            }
        });
        btndashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btndashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 90, 80));

        btnpayment.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnpaymentComponentShown(evt);
            }
        });
        btnpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaymentActionPerformed(evt);
            }
        });
        getContentPane().add(btnpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, 80));

        btnfood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/food.png"))); // NOI18N
        btnfood.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                btnfoodComponentShown(evt);
            }
        });
        btnfood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfoodActionPerformed(evt);
            }
        });
        getContentPane().add(btnfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 90, 80));

        lblaboutus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblaboutus.setText("About Us");
        getContentPane().add(lblaboutus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 70, 20));

        lblroom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblroom.setText("Manage Rooms");
        getContentPane().add(lblroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 20));

        lbldashboard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldashboard.setText("DashBoard");
        getContentPane().add(lbldashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, 20));

        lblfood.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfood.setText("Food Details");
        getContentPane().add(lblfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 80, 20));

        lblpayment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpayment.setText("Payments");
        getContentPane().add(lblpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 70, 20));

        lblhead.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        lblhead.setText("Welcome To Apna Boys Hostel");
        getContentPane().add(lblhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 580, 40));
        lblhead.getAccessibleContext().setAccessibleName("Welcome to the Dashboard");

        getContentPane().add(lblHomeBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setBounds(0, 0, 1280, 690);
    }//GEN-LAST:event_formWindowActivated

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
    System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnnavigationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnavigationActionPerformed
        
        if(btnnavigation.isSelected())
        {
            scallNevigator1();
            lblhead.setVisible(false);
            if(z==0)
            {
                try {
                    Thread.sleep(250);
                    btnregister.setVisible(true);
                    lblregister.setVisible(true);
                } catch (Exception e) {
                    
                }
            }
        }
        else
        {
            scallNevigator2();
            lblhead.setVisible(true);
            btnabsentstd.setVisible(false);
                btnadmission.setVisible(false);
                btndues.setVisible(false);
                btngrantleave.setVisible(false);
                btnlogout.setVisible(false);
                btnpresentstd.setVisible(false);
                btnregister.setVisible(false);
                btnupdate.setVisible(false);
                btnAdmin.setVisible(false);
                btnexit.setVisible(false);
                lbladmission.setVisible(false);
                lbldues.setVisible(false);
                lblexit.setVisible(false);
                lblleave.setVisible(false);
                lbldeletestd.setVisible(false);
                lbllogout.setVisible(false);
                lblnevigator.setVisible(false);
                lblallstd.setVisible(false);
                lblregister.setVisible(false);
                lblprofile.setVisible(false);
                lbladminprofile.setVisible(false);
                lblexit.setVisible(false);
                z=0;
        }
    }//GEN-LAST:event_btnnavigationActionPerformed

    private void btnexitComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnexitComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexitComponentShown

    private void btnregisterComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnregisterComponentShown
        try 
        {
            Thread.sleep(250);
            btnadmission.setVisible(true);
            lbladmission.setVisible(true);
        } catch (InterruptedException e) {
                
          }
    }//GEN-LAST:event_btnregisterComponentShown

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        lblregister.setForeground(Color.red);
        new StudentRegistration().setVisible(true);
        
    }//GEN-LAST:event_btnregisterActionPerformed

    private void btnadmissionComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnadmissionComponentShown
        try 
        {
            Thread.sleep(250);
            btnupdate.setVisible(true);
            lblprofile.setVisible(true);
        } catch (InterruptedException e) {
                
          }
    }//GEN-LAST:event_btnadmissionComponentShown

    private void btnadmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadmissionActionPerformed
       lbladmission.setForeground(Color.red);
       obj= new Admission();
       obj.setVisible(true);
    }//GEN-LAST:event_btnadmissionActionPerformed

    private void btnupdateComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnupdateComponentShown
        try 
        {
            Thread.sleep(250);
            btndues.setVisible(true);
            lbldues.setVisible(true);
        } catch (InterruptedException e) {
                
          }
    }//GEN-LAST:event_btnupdateComponentShown

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        new StudentProfile().setVisible(true);
        lblprofile.setForeground(Color.red);
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnduesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnduesComponentShown
        try 
        {
            Thread.sleep(250);
            btngrantleave.setVisible(true);
            lblleave.setVisible(true);
        } catch (InterruptedException e) {
                
          }
    }//GEN-LAST:event_btnduesComponentShown

    private void btnduesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnduesActionPerformed
        new DuesList().setVisible(true);
        lbldues.setForeground(Color.red);
    }//GEN-LAST:event_btnduesActionPerformed

    private void btngrantleaveComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btngrantleaveComponentShown
        try 
        {
            Thread.sleep(250);
            btnpresentstd.setVisible(true);
            lblallstd.setVisible(true);
        } catch (Exception e) {
                
          }
    }//GEN-LAST:event_btngrantleaveComponentShown

    private void btngrantleaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngrantleaveActionPerformed
        new StudentLeaves().setVisible(true);
        lblleave.setForeground(Color.red);
    }//GEN-LAST:event_btngrantleaveActionPerformed

    private void btnpresentstdComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnpresentstdComponentShown
        try 
        {
            Thread.sleep(250);
            btnabsentstd.setVisible(true);
            lbldeletestd.setVisible(true);
        } catch (Exception e) {
                
          }
    }//GEN-LAST:event_btnpresentstdComponentShown

    private void btnpresentstdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpresentstdActionPerformed
        new AllStudents().setVisible(true);
        lblallstd.setForeground(Color.red);
    }//GEN-LAST:event_btnpresentstdActionPerformed

    private void btnabsentstdComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnabsentstdComponentShown
        try 
        {
            Thread.sleep(250);
            btnAdmin.setVisible(true);
            lbladminprofile.setVisible(true);
        } catch (InterruptedException e) {
                
          }
    }//GEN-LAST:event_btnabsentstdComponentShown

    private void btnabsentstdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnabsentstdActionPerformed
        new DeleteStudent().setVisible(true);
        lbldeletestd.setForeground(Color.red);
    }//GEN-LAST:event_btnabsentstdActionPerformed

    private void btnAdminComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnAdminComponentShown
        try 
        {
            Thread.sleep(250);
            btnlogout.setVisible(true);
            lbllogout.setVisible(true);
        } catch (InterruptedException e) {
       
          }
    }//GEN-LAST:event_btnAdminComponentShown

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        new AdminProfile().setVisible(true);
        lbladminprofile.setForeground(Color.red);
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnlogoutComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnlogoutComponentShown
        try 
        {
            Thread.sleep(250);
            btnexit.setVisible(true);
            lblexit.setVisible(true);
        } catch (InterruptedException e) {
                
          }
    }//GEN-LAST:event_btnlogoutComponentShown

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        new Login().setVisible(true);
        Login.adminId=null;
        Login.adminEmail=null;
        this.setVisible(false);
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnaboutComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnaboutComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaboutComponentShown

    private void btnaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaboutActionPerformed
        // TODO add your handling code here:
        lblaboutus.setForeground(Color.red);
    }//GEN-LAST:event_btnaboutActionPerformed

    private void btnregister2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnregister2ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregister2ComponentShown

    private void btnregister2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregister2ActionPerformed
        // TODO add your handling code here:
        new ManageRooms().setVisible(true);
        lblroom.setForeground(Color.red);
    }//GEN-LAST:event_btnregister2ActionPerformed

    private void btndashboardComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btndashboardComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_btndashboardComponentShown

    private void btndashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndashboardActionPerformed
        // TODO add your handling code here:
       // new DashBoard().setVisible(true);
       DashBoard obj=new DashBoard();
       obj.setVisible(true);
       Thread t=new Thread(obj);
       t.start();
       lbldashboard.setForeground(Color.red);
    }//GEN-LAST:event_btndashboardActionPerformed

    private void btnpaymentComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnpaymentComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpaymentComponentShown

    private void btnpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaymentActionPerformed
        new PaymentSystem().setVisible(true);
        lblpayment.setForeground(Color.red);
    }//GEN-LAST:event_btnpaymentActionPerformed

    private void btnfoodComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btnfoodComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_btnfoodComponentShown

    private void btnfoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfoodActionPerformed
        // TODO add your handling code here:
        lblfood.setForeground(Color.red);
    }//GEN-LAST:event_btnfoodActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        //lblregister.setForeground(Color.black);
    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(admin)
        {
            lbladminprofile.setForeground(Color.black);
        }
        if(dashboard)
        {
            lbldashboard.setForeground(Color.black);
        }
        if(payment)
        {
            lblpayment.setForeground(Color.black);
        }
        if(room)
        {
            lblroom.setForeground(Color.black);
        }
        if(admission)
        {
            lbladmission.setForeground(Color.black);
        }
        if(allstd)
        {
            lblallstd.setForeground(Color.black);
        }
        if(deletestd)
        {
            lbldeletestd.setForeground(Color.black);
        }
        if(dues)
        {
            lbldues.setForeground(Color.black);
        }
        if(leave)
        {
            lblleave.setForeground(Color.black);
        }
        if(profile)
        {
            lblprofile.setForeground(Color.black);
        }
        if(registration)
        {
            lblregister.setForeground(Color.black);
        }
    }//GEN-LAST:event_formWindowGainedFocus
    /*public void scaleCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\cross.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnCross.getWidth(), btnCross.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnCross.setIcon(finalImage);
    }*/
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnabout;
    private javax.swing.JButton btnabsentstd;
    private javax.swing.JButton btnadmission;
    private javax.swing.JButton btndashboard;
    private javax.swing.JButton btndues;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnfood;
    private javax.swing.JButton btngrantleave;
    private javax.swing.JButton btnlogout;
    private javax.swing.JToggleButton btnnavigation;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnpresentstd;
    private javax.swing.JButton btnregister;
    private javax.swing.JButton btnregister2;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel lblHomeBack;
    private javax.swing.JLabel lblaboutus;
    private javax.swing.JLabel lbladminprofile;
    private javax.swing.JLabel lbladmission;
    private javax.swing.JLabel lblallstd;
    private javax.swing.JLabel lbldashboard;
    private javax.swing.JLabel lbldeletestd;
    private javax.swing.JLabel lbldues;
    private javax.swing.JLabel lblexit;
    private javax.swing.JLabel lblfood;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblleave;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JLabel lblnevigator;
    private javax.swing.JLabel lblpayment;
    private javax.swing.JLabel lblprofile;
    private javax.swing.JLabel lblregister;
    private javax.swing.JLabel lblroom;
    // End of variables declaration//GEN-END:variables
}
