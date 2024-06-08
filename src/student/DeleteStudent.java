package student;

import connectivity.ConnectionProvider;
import home.HomePage;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rites
 */

public class DeleteStudent extends javax.swing.JFrame {

    String stdId,name,dob,father,pmobile,mobile,path,adharno,doa,status,room;
    byte[]image;
    
    /**
     * Creates new form DeleteStudent
     */
    
    public void tableDetails()
    {
        DefaultTableModel dtm=(DefaultTableModel)tblxstudent.getModel();
        dtm.setRowCount(0);
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from x_students");
            while(rs.next())
            {
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void getStudentData()
    {
        stdId=txtid.getText();
         Connection con;
        try {
            con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admission where std_id=" + stdId);
            while (rs.next()) {
                name=rs.getString(2)+" "+rs.getString(3);
                dob=rs.getString(5);
                father=rs.getString(6);
                mobile=rs.getString(12);
                pmobile=rs.getString(9);
                adharno=rs.getString(10);
                
                Connection con1=ConnectionProvider.getCon();
                Statement st1=con1.createStatement();
                ResultSet rst1=st1.executeQuery("select * from fees where id="+stdId);
                while(rst1.next())
                {
                    doa=rst1.getString(3);
                }
                
                Connection con2=ConnectionProvider.getCon();
                Statement st2=con2.createStatement();
                ResultSet rst2=st2.executeQuery("select * from leaves where student_id="+stdId);
                while(rst2.next())
                {
                    status=rst2.getString(3);
                }
                
                
                image = rs.getBytes(20);
                ImageIcon iif = new ImageIcon(image);
                Image img1 = iif.getImage();
                Image format = img1.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon scaledImage = new ImageIcon(format);
                lblphoto.setIcon(scaledImage);
                
                lblhdob.setText("DOB: "+dob);
                lblhid.setText("Student ID: "+stdId);
                lblhname.setText("Name: "+name);
                lblhstatus.setText("Status: "+status);
                lbldoa.setText("Admission date: "+doa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void insertIntoXStudents()
    {
        try {
            Connection con1=ConnectionProvider.getCon();
            PreparedStatement pst=con1.prepareStatement("insert into x_students values(?,?,?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2,father);
            pst.setString(3,mobile);
            pst.setString(4,pmobile);
            pst.setString(5,adharno);
            pst.setString(6,doa);
            Date date=new Date();
            java.sql.Date sqldate=new java.sql.Date(date.getTime());
            pst.setDate(7, sqldate);
            pst.setBytes(8, image);
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void deleteFromAdmission()
    {
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("delete from admission where std_id="+stdId);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void findRoom()
    {
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
                if (bed1.equals(stdId) || bed2.equals(stdId) || bed3.equals(stdId) || bed4.equals(stdId)) 
                {                    
                    room=rs.getString(1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e +" in findRoom()");
        }
    }
    
    private void deleteFromRoom()
    {
        Connection con1;
        int beds, booked;
        String rstatus = "Available", bedposition = "";
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
                st1.executeUpdate("update rooms set beds_booked='" + booked + "', beds_available='" + (beds - booked) + "', status='" + rstatus + "'," + bedposition + "='" + "----" + "' where room_id='" + room + "';");   
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void deleteFromFees()
    {
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("delete from fees where id="+stdId);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void deleteFromLeave()
    {
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("delete from leaves where student_id="+stdId);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public DeleteStudent() {
        initComponents();
        tableDetails();
        scallBackground();
    }
     public final void scallBackground() {
        ImageIcon icon = new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\black_4.png");
        Image img = icon.getImage();
        Image sImage = img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblxstudent = new javax.swing.JTable();
        lblhead = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        btndeletestd = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        lblphoto = new javax.swing.JLabel();
        lbldoa = new javax.swing.JLabel();
        lblhname = new javax.swing.JLabel();
        lblhdob = new javax.swing.JLabel();
        lblhid = new javax.swing.JLabel();
        lblhstatus = new javax.swing.JLabel();
        lbltableinfo = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 70, 60));

        tblxstudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblxstudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Father's Name", "Mobile Number", "Parents Mobile", "Adhar No", "Admission Date", "Leaved Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblxstudent);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 850, 270));

        lblhead.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        lblhead.setText("the student deletion portel!");
        getContentPane().add(lblhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 590, 40));

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 100, 30));

        lblid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblid.setText("Enter Student Id:");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 130, 30));

        btndeletestd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndeletestd.setText("Delete Student");
        btndeletestd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletestdActionPerformed(evt);
            }
        });
        getContentPane().add(btndeletestd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 140, 30));

        btnsearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, -1, 30));
        getContentPane().add(lblphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 130));

        lbldoa.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lbldoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 250, 20));

        lblhname.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 190, 20));

        lblhdob.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 190, 20));

        lblhid.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 170, 20));

        lblhstatus.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        getContentPane().add(lblhstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 120, 20));

        lbltableinfo.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        lbltableinfo.setText("The Following Table Shows The details of X-Students of The Hostel");
        getContentPane().add(lbltableinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 530, 20));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setBounds(170,150, 850, 480);
    }//GEN-LAST:event_formWindowActivated

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        HomePage.deletestd=true;
        //HomePage.obj.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btndeletestdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletestdActionPerformed
        if(stdId.length()>=4)
        {
            insertIntoXStudents();
        findRoom();
        deleteFromRoom();
        deleteFromLeave();
        deleteFromFees();
        deleteFromAdmission();
        stdId=" ";
        room="";
        }
        else{
        JOptionPane.showMessageDialog(null, "Invalid Student ID");
            return;
        }
    }//GEN-LAST:event_btndeletestdActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        getStudentData();
    }//GEN-LAST:event_btnsearchActionPerformed

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
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteStudent().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndeletestd;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lbldoa;
    private javax.swing.JLabel lblhdob;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblhid;
    private javax.swing.JLabel lblhname;
    private javax.swing.JLabel lblhstatus;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel lbltableinfo;
    private javax.swing.JTable tblxstudent;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
