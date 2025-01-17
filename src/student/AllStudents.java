package student;


import connectivity.ConnectionProvider;
import home.HomePage;
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
 * @author ritesh singh
 */
public class AllStudents extends javax.swing.JFrame {

    /**
     * Creates new form AllStudents
     */
    public final void tableDetails() {
        DefaultTableModel dtm = (DefaultTableModel) tblAllStudents.getModel();
        dtm.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from admission");
            while (rs.next()) {
                String id = rs.getString(1);
                String doa = "";
                String room = "Not Found";
                Connection con1 = ConnectionProvider.getCon();
                Statement st1 = con1.createStatement();
                ResultSet rs1 = st1.executeQuery("select * from rooms");
                while (rs1.next()) {
                    String bed1 = " ", bed2 = " ", bed3 = " ", bed4 = " ";
                    if (rs1.getString(8) != null) {
                        bed1 = (String) rs1.getString(8);
                    }
                    if (rs1.getString(9) != null) {

                        bed2 = (String) rs1.getString(9);
                    }
                    if (rs1.getString(10) != null) {
                        bed3 = (String) rs1.getString(10);
                    }
                    if (rs1.getString(11) != null) {
                        bed4 = (String) rs1.getString(11);

                    }
                    if (bed1.equals(id) || bed2.equals(id) || bed3.equals(id) || bed4.equals(id)) {
                        room = (String) rs1.getString(1);
                    }
                }
                Connection con2 = ConnectionProvider.getCon();
                Statement st2 = con2.createStatement();
                ResultSet rst2 = st2.executeQuery("select * from fees where id=" + id);
                while (rst2.next()) {
                    doa = (String) rst2.getString(3);
                }

                String status = "";
                Connection con3 = ConnectionProvider.getCon();
                Statement st3 = con3.createStatement();
                ResultSet rst3 = st3.executeQuery("select * from leaves where student_id=" + id);
                while (rst3.next()) {
                    status = rst3.getString(3);
                }

                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2) + " " + rs.getString(3), rs.getString(12), rs.getString(21), doa, room, status});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public AllStudents() {
        initComponents();
        tableDetails();
        scallBackground();
        scallBackgroundtable();
    }
    public final void scallBackground()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\solid_5.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
    }
    public final void scallBackgroundtable()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\solid_5.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lbltableback.getWidth(), lbltableback.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lbltableback.setIcon(finalImage);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllStudents = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnexit5 = new javax.swing.JButton();
        lbltableback = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAllStudents.setModel(new javax.swing.table.DefaultTableModel(
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
                "Student ID", "Name", "Mobile Number", "Blood Group", "Admission Date", "Room Number", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAllStudents);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 800, 270));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setText("Details Of all students currently living");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 570, 40));

        btnexit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexit5ActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 70, 60));

        lbltableback.setText("jLabel2");
        getContentPane().add(lbltableback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 800, 270));

        lblbackground.setText("jLabel2");
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setBounds(170, 150, 800, 400);
    }//GEN-LAST:event_formWindowOpened

    private void btnexit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexit5ActionPerformed
        HomePage.allstd=true;
//HomePage.obj.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnexit5ActionPerformed

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
            java.util.logging.Logger.getLogger(AllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllStudents().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lbltableback;
    private javax.swing.JTable tblAllStudents;
    // End of variables declaration//GEN-END:variables
}
