package student;

import java.sql.PreparedStatement;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import connectivity.ConnectionProvider;
import home.HomePage;
import java.io.FileInputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ritesh Singh
 * 
 */
public class StudentRegistration extends javax.swing.JFrame {

    String s;
    File storedPhoto=null;
    String id;
    public StudentRegistration() {
        initComponents();
        getId();
        scallCross();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblfname = new javax.swing.JLabel();
        txtfname = new javax.swing.JTextField();
        btnclose = new javax.swing.JButton();
        txtlname = new javax.swing.JTextField();
        lbllname = new javax.swing.JLabel();
        lblfather = new javax.swing.JLabel();
        txtfather = new javax.swing.JTextField();
        txtmother = new javax.swing.JTextField();
        txtmobile = new javax.swing.JTextField();
        lblmobile = new javax.swing.JLabel();
        lbladhar = new javax.swing.JLabel();
        txtadhar = new javax.swing.JTextField();
        lblmother = new javax.swing.JLabel();
        datedob = new com.toedter.calendar.JDateChooser();
        lbldob = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        btnpay_submit = new javax.swing.JButton();
        tbtnphoto = new javax.swing.JToggleButton();
        lblfname1 = new javax.swing.JLabel();
        rdofemale = new javax.swing.JRadioButton();
        rdomale = new javax.swing.JRadioButton();
        btnreload = new javax.swing.JButton();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));
        setForeground(java.awt.Color.cyan);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setText("Hostel Registration Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 350, 60));

        lblfname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfname.setText("First Name");
        getContentPane().add(lblfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 80, 30));

        txtfname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 160, 30));

        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 70, 70));

        txtlname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 160, 30));

        lbllname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllname.setText("Last Name");
        getContentPane().add(lbllname, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 80, 30));

        lblfather.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfather.setText("Father's Name");
        getContentPane().add(lblfather, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 110, 30));

        txtfather.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtfather, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 30));

        txtmother.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtmother, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 160, 30));

        txtmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 160, 30));

        lblmobile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmobile.setText("Mobile Number");
        getContentPane().add(lblmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 110, 30));

        lbladhar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbladhar.setText("Adhar Number");
        getContentPane().add(lbladhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 110, 30));

        txtadhar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 160, 30));

        lblmother.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblmother.setText("Mother's Name");
        getContentPane().add(lblmother, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 110, 30));
        getContentPane().add(datedob, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 160, 30));

        lbldob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldob.setText("Date Of Birth");
        getContentPane().add(lbldob, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 100, 30));

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 110, 30));

        lblid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblid.setText("Suggested ID:-");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 110, 30));

        btnclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        getContentPane().add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 100, 50));

        btnpay_submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnpay_submit.setText("Pay & Submit");
        btnpay_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpay_submitActionPerformed(evt);
            }
        });
        getContentPane().add(btnpay_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 140, 50));

        tbtnphoto.setText("Insert Photo");
        tbtnphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnphotoActionPerformed(evt);
            }
        });
        getContentPane().add(tbtnphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(657, 100, 130, 150));

        lblfname1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfname1.setText("Gender");
        getContentPane().add(lblfname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 80, 30));

        btngroup.add(rdofemale);
        rdofemale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdofemale.setText("Female");
        rdofemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdofemaleActionPerformed(evt);
            }
        });
        getContentPane().add(rdofemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        btngroup.add(rdomale);
        rdomale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdomale.setText("Male");
        rdomale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdomaleActionPerformed(evt);
            }
        });
        getContentPane().add(rdomale, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, -1, -1));

        btnreload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_btn.png"))); // NOI18N
        btnreload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreloadActionPerformed(evt);
            }
        });
        getContentPane().add(btnreload, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 40, 30));

        lblbackground.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_s1.jpg"))); // NOI18N
        lblbackground.setText("jLabel10");
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void scallCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Exit_big.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnclose.getWidth(), btnclose.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnclose.setIcon(finalImage);
    }
    private void getId()
    {
        double tid=9999*Math.random();
        int t=(int)tid;
        id=""+t;
        
        if(id.length()==4)
        {
        txtid.setText(id);
        }
        else
        {
            getId();
        }
    }
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setBounds(170, 150, 800, 520);
        
        
    }//GEN-LAST:event_formWindowActivated

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        HomePage.registration=true;
        setVisible(false);
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnpay_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpay_submitActionPerformed
        String fname,lname,father,mother,mobile,dob,adhar,gender,stdId,path;
        Connection con;
        stdId=txtid.getText();
        fname=txtfname.getText();
        lname=txtlname.getText();
        father=txtfather.getText();
        mother=txtmother.getText();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(datedob.getDate()==null)
        {
            Date date=new Date();
            dob=sdf.format(date);
        }
        else
        {
            dob=sdf.format(datedob.getDate());
        }
        mobile=txtmobile.getText();
        adhar=txtadhar.getText();
        if(rdofemale.isSelected())
        {
            gender="Female";
        }
        else
            gender="Male";
        
        try {
            con=ConnectionProvider.getCon();
            PreparedStatement pst=con.prepareStatement("insert into studentregistrations values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,stdId);
            pst.setString(2,fname);
            pst.setString(3,lname);
            pst.setString(4,father);
            pst.setString(5,mother);
            pst.setString(6,mobile);
            pst.setString(7,dob);
            pst.setString(8,adhar);
            pst.setString(9,gender);
            path=storedPhoto.getAbsolutePath();
            FileInputStream fis=new FileInputStream(storedPhoto);
            pst.setBinaryStream(10, fis);
            pst.setString(11, path);
            System.out.println(pst);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btnpay_submitActionPerformed

    private void tbtnphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnphotoActionPerformed
        
        if(tbtnphoto.isSelected())
        {
            tbtnphoto.setIcon(null);
            JFileChooser jfc=new JFileChooser();
            jfc.showOpenDialog(null);
            storedPhoto=jfc.getSelectedFile();
            
            tbtnphoto.setText("View Photo");
        }
        else
        {
            tbtnphoto.setText("");
            ImageIcon icon=new ImageIcon(storedPhoto.getAbsolutePath());
            Image img=icon.getImage();
            Image sImage=img.getScaledInstance(tbtnphoto.getWidth(), tbtnphoto.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon finalImage=new ImageIcon(sImage);
            tbtnphoto.setIcon(finalImage);
        }
        
    }//GEN-LAST:event_tbtnphotoActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        txtadhar.setText("");
        txtfather.setText("");
        txtfname.setText("");
        txtlname.setText("");
        txtmobile.setText("");
        txtmother.setText("");
        /*long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);*/
        datedob.setDate(null);
        tbtnphoto.setIcon(null);
    }//GEN-LAST:event_btnclearActionPerformed

    private void rdomaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdomaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdomaleActionPerformed

    private void rdofemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdofemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdofemaleActionPerformed

    private void btnreloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreloadActionPerformed
        getId();
    }//GEN-LAST:event_btnreloadActionPerformed

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
            java.util.logging.Logger.getLogger(StudentRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnclose;
    private javax.swing.ButtonGroup btngroup;
    private javax.swing.JButton btnpay_submit;
    private javax.swing.JButton btnreload;
    private com.toedter.calendar.JDateChooser datedob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbladhar;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lbldob;
    private javax.swing.JLabel lblfather;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblfname1;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lbllname;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblmother;
    private javax.swing.JRadioButton rdofemale;
    private javax.swing.JRadioButton rdomale;
    private javax.swing.JToggleButton tbtnphoto;
    private javax.swing.JTextField txtadhar;
    private javax.swing.JTextField txtfather;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtmother;
    // End of variables declaration//GEN-END:variables
}