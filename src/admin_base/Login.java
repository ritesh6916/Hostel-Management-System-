package admin_base;

import connectivity.ConnectionProvider;
import home.HomePage;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    
    public static String adminId,adminEmail,loginData;
    private String password;
    
    private void getDataById()
    {
        loginData=txtid.getText();
        String tpass=txtpassword.getText();
        int counter=0;
        String status;
        Connection con;
        try {
            con = ConnectionProvider.getCon();
            if(con==null)
            {
                return;
            }
            Statement st = con.createStatement();
            ResultSet rs;
            if(validator.Validator.validateEmail(loginData))
            {
                System.out.println(loginData);
                //rs = st.executeQuery("select * from admin_details where email="+loginData);
                //rs=st.executeQuery("SELECT * FROM `admin_details` WHERE email='riteshsingh0500@gmail.com'");
                rs=st.executeQuery("SELECT * FROM `admin_details` WHERE email='"+loginData+"'");
            }
            else{
                rs = st.executeQuery("select * from admin_details where admin_id="+loginData);
            }
            while (rs.next()) {
                counter++;
                password=rs.getString(7);
                System.out.println(password +" "+tpass);
                if(password.equals(tpass)==true)
                {
                    adminId=rs.getString(1);
                    status=rs.getString(15);
                    if(status.equals("Allowed"))
                    {
                        adminId=rs.getString(1);
                        new HomePage().setVisible(true);
                        setVisible(false);
                    }
                    else
                    {
                        
                        JOptionPane.showMessageDialog(null,"Please Contact with Existing admin to Approve You");
                        return;
                        
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"ID and Password Don't match");
                    return;
                }
            }
            if(counter==0)
            {
                JOptionPane.showMessageDialog(null,"Id Doesn't Exist ");
                //return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID or Password");
        }
    }
    public Login() {
        
        initComponents();
        scaleCross();
        scaledImage();
        scaledBackground2();  
        scaledLoginIcon();
        scaledDesktop();
    }
    public void scaleCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\cross.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnCross.getWidth(), btnCross.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnCross.setIcon(finalImage);
    }
    public void scaledImage()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\d8.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
    }
   public void scaledBackground2()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\back_s2.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground2.getWidth(), lblbackground2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackground2.setIcon(finalImage);
    }
   public void scaledLoginIcon()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\login_icon3.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lbllohinicon.getWidth(), lbllohinicon.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lbllohinicon.setIcon(finalImage);
    }
    public void scaledDesktop()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\desktop-application.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lbldesktop.getWidth(), lbldesktop.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lbldesktop.setIcon(finalImage);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCross = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        btncear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbllohinicon = new javax.swing.JLabel();
        lblclickhere = new javax.swing.JLabel();
        lblclickhere1 = new javax.swing.JLabel();
        lblbackground2 = new javax.swing.JLabel();
        lbldesktop = new javax.swing.JLabel();
        lblheading = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setName("Login"); // NOI18N
        setUndecorated(true);
        setSize(new java.awt.Dimension(600, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrossActionPerformed(evt);
            }
        });
        getContentPane().add(btnCross, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 70, 60));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Admin Id/Email");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 20));

        txtid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtid.setText("User Id");
        txtid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtidMouseClicked(evt);
            }
        });
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 220, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 90, 20));

        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtpassword.setText("jPasswordField1");
        txtpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpasswordMouseClicked(evt);
            }
        });
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 140, -1));

        btncear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btncear.setText("Clear");
        btncear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncearActionPerformed(evt);
            }
        });
        jPanel1.add(btncear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Forgot Password ?");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        btnlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jPanel1.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jLabel4.setText("Sign Up...");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 60, 20));
        jPanel1.add(lbllohinicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 100, 90));

        lblclickhere.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblclickhere.setText("Click Here");
        lblclickhere.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblclickhereMouseClicked(evt);
            }
        });
        jPanel1.add(lblclickhere, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        lblclickhere1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblclickhere1.setText("Click Here");
        lblclickhere1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblclickhere1MouseClicked(evt);
            }
        });
        jPanel1.add(lblclickhere1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, 20));
        jPanel1.add(lblbackground2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 420, 310));
        getContentPane().add(lbldesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 260, 220));

        lblheading.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        lblheading.setText("Welcome to Apna Boys Hostel");
        getContentPane().add(lblheading, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 520, 50));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        /*Image img=new ImageIcon(this.getClass().getResource("fees.png")).getImage();
	    jLabel1.setIcon(new ImageIcon(img));*/
        setBounds(220, 95, 800, 475);
    }//GEN-LAST:event_formWindowActivated

    private void btnCrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrossActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCrossActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
    
        
        getDataById();
        
    }//GEN-LAST:event_btnloginActionPerformed

    private void btncearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncearActionPerformed
        // TODO add your handling code here:
        txtid.setText("");
        txtpassword.setText("");
    }//GEN-LAST:event_btncearActionPerformed

    private void lblclickhereMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblclickhereMouseClicked
        new ForgetPassword().setVisible(true);
    }//GEN-LAST:event_lblclickhereMouseClicked

    private void txtpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpasswordMouseClicked
        txtpassword.setText(null);
        if(txtid.getText().length()==0)
        {
            JOptionPane.showMessageDialog(null, "Please Enter Your Email or Admin ID");
            txtid.requestFocus();
            return;
        }
            
    }//GEN-LAST:event_txtpasswordMouseClicked

    private void txtidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidMouseClicked
        txtid.setText(null);
    }//GEN-LAST:event_txtidMouseClicked

    private void lblclickhere1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblclickhere1MouseClicked
        new SignUp().setVisible(true);
    }//GEN-LAST:event_lblclickhere1MouseClicked
        public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCross;
    private javax.swing.JButton btncear;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblbackground2;
    private javax.swing.JLabel lblclickhere;
    private javax.swing.JLabel lblclickhere1;
    private javax.swing.JLabel lbldesktop;
    private javax.swing.JLabel lblheading;
    private javax.swing.JLabel lbllohinicon;
    private javax.swing.JTextField txtid;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}