package room;

import student.Admission;
import connectivity.ConnectionProvider;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author rites
 */
public class AllotRoom extends javax.swing.JFrame {

    /**
     * Creates new form AllotRoom
     */
    public void tableDetails()
    {
        DefaultTableModel dtm=(DefaultTableModel)table.getModel();
        dtm.setRowCount(0);
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from rooms where status='Available'");
            while(rs.next())
            {
                dtm.addRow(new Object[]{rs.getString(1), rs.getInt(5),rs.getString(2),rs.getString(4),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public AllotRoom() {
        initComponents();
        tableDetails();
        scallBackground();
        scallCross();
    }
    
    public final void scallCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Exit_big.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btnexit.getWidth(), btnexit.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btnexit.setIcon(finalImage);
    }
    public final void scallBackground()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\solid_5.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
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

        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnexit = new javax.swing.JButton();
        btnallotroom = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtroomid = new javax.swing.JTextField();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel8.setText("Available Rooms");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 180, 30));

        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Room ID", "Fees", "Total Beds", "Available Beds", "1st", "2nd", "3rd", "4th"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 600, 180));

        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 70, 60));

        btnallotroom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnallotroom.setText("Allot Room");
        btnallotroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnallotroomActionPerformed(evt);
            }
        });
        getContentPane().add(btnallotroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, 30));

        txtid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Enter Room id");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Your ID is:-");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 30));

        txtroomid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtroomid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroomidActionPerformed(evt);
            }
        });
        getContentPane().add(txtroomid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 110, 30));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setBounds(170,150, 600, 370);
        txtid.setText(Admission.studentId);
        
    }//GEN-LAST:event_formWindowActivated

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void btnallotroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnallotroomActionPerformed
        String roomId=txtroomid.getText();
        Admission.roomDetails=roomId;
        if(roomId.length()>1)
        {
        Admission.roomDetailsStatus=true;
        }
        String studentid=txtid.getText();
        Connection con;
        int beds,booked;
        String status="Available",bedposition="";
        try {
            con=connectivity.ConnectionProvider.getCon();
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery("select * from rooms where status='Available'");
            while(rs.next())
            {
                if(((String)rs.getString(1)).equals(roomId))
                { 
                    beds=rs.getInt(2);
                    booked=rs.getInt(3);
                    booked=booked+1;
                    if(beds==booked)
                    {
                        status="Not Available";
                    }
                    if(rs.getString(8).equals("----"))
                    {
                        bedposition="1st";
                    }
                    else if(rs.getString(9).equals("----"))
                    {
                        bedposition="2nd";
                    }
                    else if(rs.getString(10).equals("----"))
                    {
                        bedposition="3rd";
                    }
                    else if(rs.getString(11).equals("----"))
                    {
                        bedposition="4th";
                    }
                    Statement st1=con.createStatement();
                    st1.executeUpdate("update rooms set beds_booked='"+booked+"', beds_available='"+(beds-booked)+"', status='"+status+"',"+bedposition+"='"+studentid+"' where room_id='"+roomId+"';");
                    tableDetails();
                }
                else
                    continue;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnallotroomActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        //HomePage.obj.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnexitActionPerformed

    private void txtroomidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroomidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroomidActionPerformed

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
            java.util.logging.Logger.getLogger(AllotRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllotRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllotRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllotRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllotRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnallotroom;
    private javax.swing.JButton btnexit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtroomid;
    // End of variables declaration//GEN-END:variables
}