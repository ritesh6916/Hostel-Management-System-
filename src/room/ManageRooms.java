package room;

import java.sql.*;
import connectivity.ConnectionProvider;
import home.HomePage;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;

public class ManageRooms extends javax.swing.JFrame {
    
    String roomuno;
    public void clear()
    {
        txtroomno.setText("");
        txturoomno.setText("");
        ckbactivate.setSelected(false);
        ckbuactivate.setSelected(false);
        cmbbeds.setSelectedIndex(0);
        cmbubeds.setSelectedIndex(0);
        txturoomno.setForeground(Color.BLACK);
        txturoomno.setEditable(true);
        roomuno="";
        txtfees.setText("");
        txtufrre.setText("");
    }
    
    public final void tableDetails()
    {
        DefaultTableModel dtm=(DefaultTableModel)tblresults.getModel();
        dtm.setRowCount(0);
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from rooms");
            while(rs.next())
            {
                dtm.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7)});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public ManageRooms() {
        initComponents();
        tableDetails();
        scallCross();
        scallbackground();
    }
     public final void scallCross()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Exit_big.png");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(btncross.getWidth(), btncross.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        btncross.setIcon(finalImage);
    }
     public final void scallbackground()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\back_s2.jpg");
        Image img=icon.getImage();
        Image sImage=img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage=new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btncross = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtroomno = new javax.swing.JTextField();
        ckbactivate = new javax.swing.JCheckBox();
        btnsave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ckbuactivate = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txturoomno = new javax.swing.JTextField();
        btnuupdate = new javax.swing.JButton();
        btnudelete = new javax.swing.JButton();
        btnusearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblresults = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        cmbbeds = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbubeds = new javax.swing.JComboBox<>();
        lblfees = new javax.swing.JLabel();
        txtfees = new javax.swing.JTextField();
        txtufrre = new javax.swing.JTextField();
        lblfees1 = new javax.swing.JLabel();
        lblhead = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(250, 150));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel1.setText("Add new Room");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 146, 30));

        btncross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncrossActionPerformed(evt);
            }
        });
        getContentPane().add(btncross, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 80, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Room Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtroomno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtroomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 90, -1));

        ckbactivate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ckbactivate.setText("Active ");
        getContentPane().add(ckbactivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        btnsave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_btn.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 90, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Total Beds");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 118, 20));

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel3.setText("Update / Delete Rooms");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 238, 30));

        ckbuactivate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(ckbuactivate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Room Number");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txturoomno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txturoomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 177, 90, -1));

        btnuupdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnuupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_btn.png"))); // NOI18N
        btnuupdate.setText("Update");
        btnuupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnuupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 124, 30));

        btnudelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnudelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_btn.png"))); // NOI18N
        btnudelete.setText("Delete");
        btnudelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnudeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnudelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 110, 30));

        btnusearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnusearch.setText("Search");
        btnusearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnusearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 174, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Activate");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 60, -1));

        jLabel8.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        jLabel8.setText("All Rooms");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 120, 30));

        tblresults.setBackground(java.awt.SystemColor.info);
        tblresults.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Room number", "Toatal Beds", "Booked", "Availabe Beds", "Fees", "Activated", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblresults);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 750, 190));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 750, 10));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 750, 10));

        cmbbeds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbbeds.setMaximumRowCount(4);
        cmbbeds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        getContentPane().add(cmbbeds, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 70, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Total Beds");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 80, 20));

        cmbubeds.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbubeds.setMaximumRowCount(4);
        cmbubeds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        getContentPane().add(cmbubeds, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 70, -1));

        lblfees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfees.setText("Fees");
        getContentPane().add(lblfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 40, -1));

        txtfees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 90, -1));

        txtufrre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtufrre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 90, -1));

        lblfees1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblfees1.setText("Fees");
        getContentPane().add(lblfees1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 40, -1));

        lblhead.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        lblhead.setText("Room Manager window");
        getContentPane().add(lblhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 350, 40));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed

        String roomNo=txtroomno.getText();
        try{
        if(roomNo.length()<2)
        {
            throw new NullPointerException();
        }
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Plese Enter Room Number");
            return;
        }
        int beds=Integer.parseInt((String) cmbbeds.getSelectedItem());
        int bedsBooked=0,fees;
        String activate;
        String roomStatus="";
        fees=Integer.parseInt((String)txtfees.getText());
        if(ckbactivate.isSelected())
        {
            activate="true";
            if(beds>bedsBooked)
                roomStatus="Available";
            else if(beds<=bedsBooked)
                roomStatus="Not Available";
        }
        else{
            activate="false";
            roomStatus="Not Available";
        }
        try {
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("insert into rooms values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, roomNo);
            ps.setInt(2, beds);
            ps.setInt(3, bedsBooked);
            ps.setInt(4, beds-bedsBooked);
            ps.setInt(5, fees);
            ps.setString(6, activate);
            ps.setString(7, roomStatus);
            ps.setString(8, "----");
            ps.setString(9, "----");
            ps.setString(10, "----");
            ps.setString(11, "----");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Success");
            tableDetails();
            clear();
        }
        catch(SQLIntegrityConstraintViolationException e)
        {
            JOptionPane.showMessageDialog(null, "Room ID Already Exist");
            clear();
        }
        catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Plese Enter Room Number");
        }
        catch(NumberFormatException e)
        {
           JOptionPane.showMessageDialog(null,"Plese Enter a Valid Fees Amount"); 
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnusearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusearchActionPerformed
        roomuno=txturoomno.getText();
        int i=0;
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from rooms where room_id="+roomuno+"");
            while(rs.next())
            {
                i=1;
                    txturoomno.setEditable(false);
                    txturoomno.setForeground(Color.red);
                    if(rs.getString(6).equals("true"))
                    {
                        ckbuactivate.setSelected(true);
                    } 
                    else
                        ckbuactivate.setSelected(false);
                    int beds=rs.getInt(2);
                    cmbubeds.setSelectedIndex(beds-1);
                    int fees=rs.getInt(5);
                    txtufrre.setText(""+fees);
            }
            if(i==0)
            {
                JOptionPane.showMessageDialog(null, "Room doesn't exist");
                clear();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnusearchActionPerformed

    private void btnuupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuupdateActionPerformed
         
        try{
        if(roomuno.length()<2)
        {
            throw new NullPointerException();
        }
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Plese Enter Room Number");
            return;
        }
        int beds=Integer.parseInt((String) cmbubeds.getSelectedItem());
        int bedsBooked=0,fees;
        String activate;
        String roomStatus="";
        fees=Integer.parseInt((String)txtufrre.getText());
        if(ckbuactivate.isSelected())
        {
            activate="true";
            if(beds>bedsBooked)
                roomStatus="Available";
            else if(beds<=bedsBooked)
                roomStatus="Not Available";
        }
        else{
            activate="false";
            roomStatus="Not Available";
        }
        try {
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("update rooms set beds=?, beds_booked=?, beds_available=?, fees=?,activated=?,status=? where room_id="+roomuno);
            //ps.setString(1, roomuno);
            ps.setInt(1, beds);
            ps.setInt(2, bedsBooked);
            ps.setInt(3, beds-bedsBooked);
            ps.setInt(4, fees);
            ps.setString(5, activate);
            ps.setString(6, roomStatus);
            /*ps.setString(8, null);
            ps.setString(9, null);
            ps.setString(10, null);
            ps.setString(11, null);*/
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            tableDetails();
            clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnuupdateActionPerformed

    private void btnudeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnudeleteActionPerformed
        
        try{
        if(roomuno.length()<2)
        {
            throw new NullPointerException();
        }
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Plese Enter a valid Room Number");
            return;
        }
        
        try {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("delete from rooms where room_id="+roomuno);
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
            tableDetails();
            clear();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnudeleteActionPerformed

    private void btncrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncrossActionPerformed
        HomePage.room=true;
        setVisible(false);
    }//GEN-LAST:event_btncrossActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageRooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncross;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnudelete;
    private javax.swing.JButton btnusearch;
    private javax.swing.JButton btnuupdate;
    private javax.swing.JCheckBox ckbactivate;
    private javax.swing.JCheckBox ckbuactivate;
    private javax.swing.JComboBox<String> cmbbeds;
    private javax.swing.JComboBox<String> cmbubeds;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblfees;
    private javax.swing.JLabel lblfees1;
    private javax.swing.JLabel lblhead;
    private javax.swing.JTable tblresults;
    private javax.swing.JTextField txtfees;
    private javax.swing.JTextField txtroomno;
    private javax.swing.JTextField txtufrre;
    private javax.swing.JTextField txturoomno;
    // End of variables declaration//GEN-END:variables
}