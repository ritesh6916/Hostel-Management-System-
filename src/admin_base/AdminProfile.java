/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_base;

import connectivity.ConnectionProvider;
import home.HomePage;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ritesh Singh
 */
public class AdminProfile extends javax.swing.JFrame {
    private String oldpass,newpass;
    /**
     * Creates new form AdminProfile
     */
    private void reShape()
    {
        btnsearch.setBounds(620, 110, 140, 30);
        txtid.setBounds(510, 110, 100, 30);
        lblid.setBounds(430, 110, 70, 30);
    }
    private void getDataById()
    {
        btnapprove.setVisible(false);
        lblapprove.setVisible(false);
        byte[] photo,adhar,sign;
        if(Login.adminId==null)
        {
            JOptionPane.showMessageDialog(null, "Login Error");
            return;
        }
        Connection con;
        try {
            con = ConnectionProvider.getCon();
            if(con==null)
            {
                return;
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admin_details where admin_id="+Login.adminId);
            while (rs.next())
            {
                oldpass=rs.getString(7);
                lbltid.setText(rs.getString(1));
                lbltadhar.setText(rs.getString(9));
                lbltblood.setText(rs.getString(5));
                lbltemail.setText(rs.getString(6));
                lbltgender.setText(rs.getString(4));
                lbltmobile.setText(rs.getString(8));
                String s=rs.getString(2)+" "+rs.getString(3);
                lbltname.setText(s);   
                
                adhar = rs.getBytes(10);
                ImageIcon tadhar = new ImageIcon(adhar);
                Image img = tadhar.getImage();
                Image formatedAdhar = img.getScaledInstance(lbladharPic.getWidth(), lbladharPic.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledadhar = new ImageIcon(formatedAdhar);
                lbladharPic.setIcon(scaledadhar);
                
                photo = rs.getBytes(11);
                ImageIcon tphoto = new ImageIcon(photo);
                Image img2 = tphoto.getImage();
                Image formatedPhoto = img2.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledPhoto = new ImageIcon(formatedPhoto);
                lblphoto.setIcon(scaledPhoto);
                
                sign = rs.getBytes(12);
                ImageIcon tsign = new ImageIcon(sign);
                Image img1 = tsign.getImage();
                Image formatedSign = img1.getScaledInstance(lblsignPic.getWidth(), lblsignPic.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledSign = new ImageIcon(formatedSign);
                lblsignPic.setIcon(scaledSign);    
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Please Login to visit This Page");
        }         
    }
    private void lock()
    {
        btnchangeSign.setVisible(false);
        btnchnagepassw.setVisible(false);
        btnsave.setVisible(false);
        txtmobile.setVisible(false);
        txtemail.setVisible(false);
        txtconformpass.setVisible(false);
        txtnewpass.setVisible(false);
        
    }
    private void clear()
    {
        txtconformpass.setText(null);
        txtemail.setText(null);
        txtmobile.setText(null);
        txtnewpass.setText(null);
        lbltadhar.setText(null);
        lbltblood.setText(null);
        lbltblood.setText(null);
        lbltemail.setText(null);
        lbltgender.setText(null);
        lbltid.setText(null);
        lbltmobile.setText(null);
        lbltname.setText(null);
        txtid.setEditable(true);
        btnapprove.setVisible(false);
        lblapprove.setVisible(false);
        lbladharPic.setIcon(null);
        lblphoto.setIcon(null);
        lblsignPic.setIcon(null);
        lbladharPic.setText(null);
        lblphoto.setText(null);
        lblsignPic.setText(null);
        btnchangeAdhar.setVisible(false);
        btnchangeSign.setVisible(false);
        btnchangePicture.setVisible(false);
        btnchangeMobile.setVisible(false);
        btnchangeEmail.setVisible(false);
        btnedit.setVisible(true);
    }
    public AdminProfile() {
        initComponents();
        scallBackground();
        scallCross();
        //scallBackgroundHead();
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
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\back_s2.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
    }
      public final void scallBackgroundHead()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\h2.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackgroundhead.getWidth(), lblbackgroundhead.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackgroundhead.setIcon(finalImage);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblhead = new javax.swing.JLabel();
        btnclose = new javax.swing.JButton();
        lblphoto = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblblood = new javax.swing.JLabel();
        lbltmobile = new javax.swing.JLabel();
        lbladhar = new javax.swing.JLabel();
        lblgender = new javax.swing.JLabel();
        lbltemail = new javax.swing.JLabel();
        txtnewpass = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        txtemail = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        lblmobile = new javax.swing.JLabel();
        lbltname = new javax.swing.JLabel();
        lbltblood = new javax.swing.JLabel();
        lbltadhar = new javax.swing.JLabel();
        lbltgender = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        btnchangeSign = new javax.swing.JButton();
        lblgender1 = new javax.swing.JLabel();
        lbltid = new javax.swing.JLabel();
        btnreset = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        txtconformpass = new javax.swing.JTextField();
        btnchnagepassw = new javax.swing.JButton();
        btnapprove = new javax.swing.JButton();
        lbladharPic = new javax.swing.JLabel();
        lblsignPic = new javax.swing.JLabel();
        lblapprove = new javax.swing.JLabel();
        btnchangePicture = new javax.swing.JButton();
        btnchangeAdhar = new javax.swing.JButton();
        btnchangeMobile = new javax.swing.JButton();
        btnchangeEmail = new javax.swing.JButton();
        lblbackground = new javax.swing.JLabel();
        lblbackgroundhead = new javax.swing.JLabel();

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

        lblhead.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        lblhead.setText("welcome to your profile");
        getContentPane().add(lblhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 570, 50));

        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 70, 60));
        getContentPane().add(lblphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 130));

        lblname.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblname.setText("Name");
        getContentPane().add(lblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, 30));

        lblblood.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblblood.setText("Blood Group");
        getContentPane().add(lblblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 30));

        lbltmobile.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(lbltmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 160, 30));

        lbladhar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbladhar.setText("Adhar Number");
        getContentPane().add(lbladhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 30));

        lblgender.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblgender.setText("Gender");
        getContentPane().add(lblgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 60, 30));

        lbltemail.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(lbltemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 250, 30));

        txtnewpass.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtnewpass.setText("New Password");
        getContentPane().add(txtnewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 190, 30));

        lblid.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblid.setText("Enter ID");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 70, 30));

        btnsave.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 150, 30));

        btnsearch.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnsearch.setText("Search Profile");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 140, 30));

        txtemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 260, 30));

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 190, 30));

        lblemail.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblemail.setText("Email ID");
        getContentPane().add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 70, 30));

        lblmobile.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblmobile.setText("Mobile Number");
        getContentPane().add(lblmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 30));

        lbltname.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(lbltname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 230, 30));

        lbltblood.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(lbltblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 90, 30));

        lbltadhar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(lbltadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 110, 30));

        lbltgender.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(lbltgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 100, 30));

        btnedit.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnedit.setText("Edit Profile");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, 30));

        btnchangeSign.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnchangeSign.setText("Change Signature");
        btnchangeSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeSignActionPerformed(evt);
            }
        });
        getContentPane().add(btnchangeSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, -1, 30));

        lblgender1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblgender1.setText("Admin Id");
        getContentPane().add(lblgender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, 30));

        lbltid.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(lbltid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 100, 30));

        btnreset.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnreset.setText("reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 70, 30));

        txtid.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 30));

        txtconformpass.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtconformpass.setText("Conform Password");
        txtconformpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconformpassActionPerformed(evt);
            }
        });
        getContentPane().add(txtconformpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 190, 30));

        btnchnagepassw.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnchnagepassw.setText("Change Password");
        btnchnagepassw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchnagepasswActionPerformed(evt);
            }
        });
        getContentPane().add(btnchnagepassw, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 150, 30));

        btnapprove.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnapprove.setText("Approve ID");
        btnapprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapproveActionPerformed(evt);
            }
        });
        getContentPane().add(btnapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, 30));
        getContentPane().add(lbladharPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 220, 150));
        getContentPane().add(lblsignPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 220, 50));

        lblapprove.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblapprove.setForeground(new java.awt.Color(255, 0, 0));
        lblapprove.setText("User is not Approved");
        getContentPane().add(lblapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 160, 30));

        btnchangePicture.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnchangePicture.setText("Change Picture");
        btnchangePicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangePictureActionPerformed(evt);
            }
        });
        getContentPane().add(btnchangePicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 30));

        btnchangeAdhar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnchangeAdhar.setText("Change Adhar");
        btnchangeAdhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeAdharActionPerformed(evt);
            }
        });
        getContentPane().add(btnchangeAdhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, 30));

        btnchangeMobile.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnchangeMobile.setText("Change Mobile");
        btnchangeMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeMobileActionPerformed(evt);
            }
        });
        getContentPane().add(btnchangeMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, 30));

        btnchangeEmail.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnchangeEmail.setText("Change Email");
        btnchangeEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangeEmailActionPerformed(evt);
            }
        });
        getContentPane().add(btnchangeEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, -1, 30));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));
        getContentPane().add(lblbackgroundhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        setBounds(170, 150, 850, 500);
        txtmobile.setVisible(false);
        txtemail.setVisible(false);
        btnchangeAdhar.setVisible(false);
        btnchangeSign.setVisible(false);
        btnchangePicture.setVisible(false);
        btnchangeMobile.setVisible(false);
        btnchangeEmail.setVisible(false);
        lock();
    }//GEN-LAST:event_formWindowActivated

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        HomePage.admin=true;
        setVisible(false);
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
    lbltemail.setVisible(false);
    lbltmobile.setVisible(false);
    txtmobile.setVisible(true);
    txtemail.setVisible(true);
    if(txtconformpass.getText()==null || txtnewpass.getText()==null || txtnewpass.getText().equals("Conform Password")|| txtnewpass.getText().equals("New Password"))
    {
        JOptionPane.showMessageDialog(null, "Please Fill old or New Password");
        return;
    }
    if(oldpass.equals(txtconformpass))
    {
        newpass=txtnewpass.getText();
        boolean b=validator.Validator.validateStrongPassword(newpass);
        if(b==true)
        {
            Connection con;
            try {
                con=ConnectionProvider.getCon();
                if(con==null)
                {
                    return;
                }
                PreparedStatement ps=con.prepareStatement("update admin_details set password=? where admin_id="+Login.adminId);
                ps.setString(1, newpass);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Password Updated Sucessfully");
                clear();
            } catch (SQLException e) {
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please Stron Password i.e 1 upper & lowercase 1 digit @ special character ");
        }
    }
    else
    {
        JOptionPane.showMessageDialog(null, "Old Password is Incorrect");
        return;
    }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
   /*
        reShape();
        btnedit.setVisible(false);
        btnsearch.setBounds(620, 110, 140, 30);
        txtid.setBounds(510, 110, 100, 30);
        lblid.setBounds(430, 110, 70, 30);
    */
    //btnsearch.setBounds(620, 110, 140, 30);
    String id=txtid.getText();
    int counter=0;
    if(id.length()<=3)
    {
        JOptionPane.showMessageDialog(null,"please enter a valid id ");
        return;
    }
        byte[] photo,adhar,sign;
        Connection con;
        try {
            con = ConnectionProvider.getCon();
            if(con==null)
            {
                return;
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admin_details where admin_id="+id);
            while (rs.next())
            {
                btnedit.setVisible(false);
                reShape();
                counter++;
                txtid.setEditable(false);
                lbltid.setText(rs.getString(1));
                lbltadhar.setText(rs.getString(9));
                lbltblood.setText(rs.getString(5));
                lbltemail.setText(rs.getString(6));
                lbltgender.setText(rs.getString(4));
                lbltmobile.setText(rs.getString(8));
                String s=rs.getString(2)+" "+rs.getString(3);
                lbltname.setText(s); 
                
                adhar = rs.getBytes(10);
                ImageIcon tadhar = new ImageIcon(adhar);
                Image img = tadhar.getImage();
                Image formatedAdhar = img.getScaledInstance(lbladharPic.getWidth(), lbladharPic.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledadhar = new ImageIcon(formatedAdhar);
                lbladharPic.setIcon(scaledadhar);
                
                photo = rs.getBytes(11);
                ImageIcon tphoto = new ImageIcon(photo);
                Image img2 = tphoto.getImage();
                Image formatedPhoto = img2.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledPhoto = new ImageIcon(formatedPhoto);
                lblphoto.setIcon(scaledPhoto);
                
                sign = rs.getBytes(12);
                ImageIcon tsign = new ImageIcon(sign);
                Image img1 = tsign.getImage();
                Image formatedSign = img1.getScaledInstance(lblsignPic.getWidth(), lblsignPic.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledSign = new ImageIcon(formatedSign);
                lblsignPic.setIcon(scaledSign);
                
                if(rs.getString(15).equals("Not Allowed"))
                {
                    btnapprove.setVisible(true);
                    lblapprove.setVisible(true);
                }
            }
        if(counter==0)
        {
            JOptionPane.showMessageDialog(null, "Admin ID is not registered");
        }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Please Login to visit This Page");
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getDataById();
    }//GEN-LAST:event_formWindowOpened

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        if(Login.adminId==null)
        {
            JOptionPane.showMessageDialog(null, "Login data is not available ");
        }
        btnchangeSign.setVisible(true);
        btnchnagepassw.setVisible(true);
        lbltemail.setVisible(false);
        txtemail.setVisible(true);
        txtemail.setText(lbltemail.getText());
        lbltmobile.setVisible(false);
        txtmobile.setVisible(true);
        txtmobile.setText(lbltmobile.getText());
        btnchangeAdhar.setVisible(true);
        btnchangePicture.setVisible(true);
        btnchangeMobile.setVisible(true);
        btnchangeEmail.setVisible(true);
    }//GEN-LAST:event_btneditActionPerformed

    private void btnchangeSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeSignActionPerformed
        //For Adhar
        JFileChooser jfc=new JFileChooser();
        jfc.showOpenDialog(null);
        File img_sign=jfc.getSelectedFile();
        if(img_sign==null)
        {
            JOptionPane.showMessageDialog(null, "Please! select a Signature File");
            return;
        }
        boolean b2=validator.Validator.validatePhoto(img_sign);
        if(b2==false)
        {
            img_sign=null;
            JOptionPane.showMessageDialog(null, "Please! select a jpg/jpeg/png File");
            return;
        }
    try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update admin_details set img_sign=? where admin_id=" + Login.adminId);
            java.io.FileInputStream fis=new FileInputStream(img_sign);
            ps.setBinaryStream(1, fis);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Your signature is Successfully Updated");
            clear();
            getDataById();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }//GEN-LAST:event_btnchangeSignActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
    lock();
    clear();
    txtid.setText(null);
    lbltemail.setVisible(true);
    lbltmobile.setVisible(true);
    getDataById();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnchnagepasswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchnagepasswActionPerformed
        txtconformpass.setVisible(true);
        txtconformpass.setText("Conform Password");
        txtnewpass.setVisible(true);
        txtnewpass.setText("New Password");
        btnsave.setVisible(true);
    }//GEN-LAST:event_btnchnagepasswActionPerformed

    private void btnapproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapproveActionPerformed
        if(txtid.getText()==null)
        {
            JOptionPane.showMessageDialog(null,"Please Search the details first");
        }
    Connection con; 
        try{
            con=ConnectionProvider.getCon();
            if(con==null)
            {
            return;
            }
            PreparedStatement pst=con.prepareStatement("update admin_details set status=? where admin_id="+txtid.getText());
            pst.setString(1, "Allowed");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Admin is Authorized Successfully");
            btnapprove.setVisible(false);
            lblapprove.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    }//GEN-LAST:event_btnapproveActionPerformed

    private void btnchangePictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangePictureActionPerformed
         //For Adhar
        JFileChooser jfc=new JFileChooser();
        jfc.showOpenDialog(null);
        File img_picture=jfc.getSelectedFile();
        if(img_picture==null)
        {
            JOptionPane.showMessageDialog(null, "Please! select a Adhar File");
            return;
        }
        boolean b2=validator.Validator.validatePhoto(img_picture);
        if(b2==false)
        {
            img_picture=null;
            JOptionPane.showMessageDialog(null, "Please! select a jpg/jpeg/png File");
            return;
        }
    try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update admin_details set img_photo=? where admin_id=" + Login.adminId);
            java.io.FileInputStream fis=new FileInputStream(img_picture);
            ps.setBinaryStream(1, fis);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Image is Successfully Updated");
            clear();
            getDataById();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnchangePictureActionPerformed

    private void btnchangeAdharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeAdharActionPerformed
        //For Adhar
        JFileChooser jfc=new JFileChooser();
        jfc.showOpenDialog(null);
        File img_adhar=jfc.getSelectedFile();
        if(img_adhar==null)
        {
            JOptionPane.showMessageDialog(null, "Please! select a Adhar File");
            return;
        }
        boolean b2=validator.Validator.validatePhoto(img_adhar);
        if(b2==false)
        {
            img_adhar=null;
            JOptionPane.showMessageDialog(null, "Please! select a jpg/jpeg/png File");
            return;
        }
    try {
            Connection con = ConnectionProvider.getCon();
            if(con==null)
                return;
            PreparedStatement ps = con.prepareStatement("update admin_details set img_adhar=? where admin_id=" + Login.adminId);
            java.io.FileInputStream fis=new FileInputStream(img_adhar);
            ps.setBinaryStream(1, fis);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            clear();
            getDataById();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnchangeAdharActionPerformed

    private void btnchangeMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeMobileActionPerformed
        boolean b=validator.Validator.validateMobile(txtmobile.getText());
        if(b!=true)
        {
            JOptionPane.showMessageDialog(null,"phon number should be 10 digits number only");
            return;
        }
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update admin_details set mobile=? where admin_id=" + Login.adminId);
            ps.setString(1, txtmobile.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            clear();
            getDataById();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnchangeMobileActionPerformed

    private void btnchangeEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangeEmailActionPerformed
        boolean b=validator.Validator.validateEmail(txtemail.getText());
        if(b!=true)
        {
            JOptionPane.showMessageDialog(null,"Invalid Email");
            return;
        }
        
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("update admin_details set email=? where admin_id=" + Login.adminId);
            ps.setString(1, txtemail.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Email Updated");
            clear();
            getDataById();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnchangeEmailActionPerformed

    private void txtconformpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconformpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconformpassActionPerformed

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
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnapprove;
    private javax.swing.JButton btnchangeAdhar;
    private javax.swing.JButton btnchangeEmail;
    private javax.swing.JButton btnchangeMobile;
    private javax.swing.JButton btnchangePicture;
    private javax.swing.JButton btnchangeSign;
    private javax.swing.JButton btnchnagepassw;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel lbladhar;
    private javax.swing.JLabel lbladharPic;
    private javax.swing.JLabel lblapprove;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblbackgroundhead;
    private javax.swing.JLabel lblblood;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblgender;
    private javax.swing.JLabel lblgender1;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel lblsignPic;
    private javax.swing.JLabel lbltadhar;
    private javax.swing.JLabel lbltblood;
    private javax.swing.JLabel lbltemail;
    private javax.swing.JLabel lbltgender;
    private javax.swing.JLabel lbltid;
    private javax.swing.JLabel lbltmobile;
    private javax.swing.JLabel lbltname;
    private javax.swing.JTextField txtconformpass;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtnewpass;
    // End of variables declaration//GEN-END:variables
}
