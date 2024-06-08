/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ritesh Singh
 */
public class DashBoard extends javax.swing.JFrame implements Runnable{

    int tStudent,aStudent,pStudent;
    String time,day;
    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        
        initComponents();
        clear();
        scallBackground();
        scallCross();
        getTotalStd();
        getAbsentStd();
        getDate();
       gettime();
       getDayOfWeek();
    }
    private void clear()
    {
        lblbreak1.setText("");
        lblbreak2.setText("");
        lblbreak3.setText("");
        lbllunch1.setText("");
        lbllunch2.setText("");
        lbllunch3.setText("");
        lbldinner1.setText("");
        lbldinner2.setText("");
        lbldinner3.setText("");
    }
    private void getDayOfWeek()
    {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
        switch(day)
        {
            case 1:
            {
                lblweekday.setText("Sunday");
                lblbreak1.setText("Aalu-Parstha");
                lbllunch1.setText("Chawal-Dal");
                lbllunch3.setText("Sabji");
                lbldinner1.setText("Roti");
                lbldinner2.setText("Chicken");
                break;
            }
            case 2:
            {
                lblweekday.setText("Monday");
                lblbreak1.setText("Roti-Sabji");
                lbllunch1.setText("Chawal-Dal");
                lbllunch3.setText("Bhujia");
                lbldinner1.setText("Roti");
                lbldinner2.setText("Fried-Dal");
                break;
            }
            case 3:
            {
                lblweekday.setText("Tuesday");
                lblbreak1.setText("Paratha");
                lblbreak1.setText("Bhujia");
                lbllunch1.setText("Chawal-Dal");
                lbllunch3.setText("Sabji");
                lbldinner1.setText("Khir");
                lbldinner2.setText("Puri");
                lbldinner3.setText("Sabji");
                break;
            }
            case 4:
            {
                lblweekday.setText("Wednesday");
                lblbreak1.setText("Sattu-Paratha");
                lbllunch1.setText("Chawal-Dal");
                lbllunch3.setText("Sabji");
                lbldinner1.setText("Roti");
                lbldinner2.setText("Egg-Curry");
                break;
            }
            case 5:
            {
                lblweekday.setText("Thrusday");
                lblbreak1.setText("Puri");
                lblbreak2.setText("Sabji");
                lbllunch1.setText("Rajma");
                lbllunch2.setText("Chawal");
                lbldinner1.setText("Roti");
                lbldinner2.setText("Sabji");
                break;
            }
            case 6:
            {
                lblweekday.setText("Friday");
                lblbreak1.setText("Roti");
                lblbreak2.setText("Bhujia");
                lbllunch1.setText("Chawal-Dal");
                lbllunch2.setText("Chokha");
                lbldinner1.setText("Roti");
                lbldinner2.setText("Paneer");
                break;
            }
            case 7:
            {
                lblweekday.setText("Saturday");
                lblbreak1.setText("Roti");
                lblbreak2.setText("Sabji");
                lbllunch1.setText("Chawal-Dal");
                lbllunch2.setText("sabji");
                lbllunch3.setText("Papad");
                lbldinner1.setText("Liti");
                lbldinner2.setText("Chokha");
                break;
            }
        
        }
      
      
    }
    private void gettime() 
    {
        java.util.Date date=new java.util.Date();
        SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
        time=sdf.format(Calendar.getInstance().getTime());
        
        lbltime.setText(time);
        //clock();
        //gettime();
    }
    @Override
    public void run()
    {
        while(true)
        {
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
            time=sdf.format(Calendar.getInstance().getTime());
            lbltime.setText(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void getDate()
    {
        java.util.Date date=new java.util.Date();
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        lbldate.setText(""+sdf.format(date));
        
    }
    public final void scallBackground() {
        ImageIcon icon = new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\black_4.png");
        Image img = icon.getImage();
        Image sImage = img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(sImage);
        lblbackground.setIcon(finalImage);
    }

    public final void scallCross() {
        ImageIcon icon = new ImageIcon("C:\\Users\\rites\\OneDrive\\Documents\\NetBeansProjects\\HostelManagementSystem\\src\\images\\Exit_big.png");
        Image img = icon.getImage();
        Image sImage = img.getScaledInstance(btnexit.getWidth(), btnexit.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(sImage);
        btnexit.setIcon(finalImage);
    }
    private void getTotalStd()
    {
        java.sql.Connection con=connectivity.ConnectionProvider.getCon();
        if(con==null)
        {
            return;
        }
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select count(DISTINCT std_id) from admission");
            //System.out.println("home.DashBoard.getData()1");
            while (rs.next()) {
                tStudent=rs.getInt(1);
                lbltotalstd.setText(""+rs.getInt(1));
            }
        } catch (SQLException ex) {
            
        }  
    }
    private void getAbsentStd()
    {
        java.sql.Connection con=connectivity.ConnectionProvider.getCon();
        if(con==null)
        {
            return;
        }
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select count(DISTINCT student_id) from leaves where status='Absent'");
            //System.out.println("home.DashBoard.getData()1");
            while (rs.next()) {
                aStudent=rs.getInt(1);
                lblabsentstd.setText(""+rs.getInt(1));
                pStudent=tStudent-aStudent;
                lblpresentstd.setText(""+pStudent);
            }
        } catch (SQLException ex) {
            
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

        lblhead = new javax.swing.JLabel();
        btnexit = new javax.swing.JLabel();
        lblfname = new javax.swing.JLabel();
        lblfather = new javax.swing.JLabel();
        lblmother = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lblmobile = new javax.swing.JLabel();
        lbltotalstd = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lblabsentstd = new javax.swing.JLabel();
        lblpresentstd = new javax.swing.JLabel();
        lblbreakfast = new javax.swing.JLabel();
        lbladhar3 = new javax.swing.JLabel();
        lbllunch = new javax.swing.JLabel();
        lbldinner = new javax.swing.JLabel();
        lbllunch2 = new javax.swing.JLabel();
        lblfood = new javax.swing.JLabel();
        lbllunch3 = new javax.swing.JLabel();
        lbllunch1 = new javax.swing.JLabel();
        lbldinner2 = new javax.swing.JLabel();
        lbldinner1 = new javax.swing.JLabel();
        lbldinner3 = new javax.swing.JLabel();
        lblbreak2 = new javax.swing.JLabel();
        lblbreak1 = new javax.swing.JLabel();
        lblbreak3 = new javax.swing.JLabel();
        lblweekday = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblhead.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        lblhead.setForeground(java.awt.Color.red);
        lblhead.setText("\"dashboard\" The current status");
        getContentPane().add(lblhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 440, 40));

        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexitMouseClicked(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 60, 50));

        lblfname.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblfname.setForeground(java.awt.Color.white);
        lblfname.setText("Total number of students");
        getContentPane().add(lblfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 250, 30));

        lblfather.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblfather.setForeground(java.awt.Color.white);
        lblfather.setText("Number of Students present");
        getContentPane().add(lblfather, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 270, 30));

        lblmother.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblmother.setForeground(java.awt.Color.white);
        lblmother.setText("Number of Students Absent");
        getContentPane().add(lblmother, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 260, 30));

        lbltime.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbltime.setForeground(new java.awt.Color(0, 51, 255));
        lbltime.setText("time");
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 130, 30));

        lblmobile.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblmobile.setForeground(java.awt.Color.white);
        lblmobile.setText("Date:-");
        getContentPane().add(lblmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 70, 30));

        lbltotalstd.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbltotalstd.setForeground(java.awt.Color.white);
        lbltotalstd.setText("80");
        getContentPane().add(lbltotalstd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 70, 30));

        lbldate.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbldate.setForeground(java.awt.Color.white);
        lbldate.setText("date");
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 120, 30));

        lblabsentstd.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblabsentstd.setForeground(java.awt.Color.white);
        lblabsentstd.setText("78");
        getContentPane().add(lblabsentstd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 80, 30));

        lblpresentstd.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblpresentstd.setForeground(java.awt.Color.white);
        lblpresentstd.setText("78");
        getContentPane().add(lblpresentstd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 80, 30));

        lblbreakfast.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblbreakfast.setForeground(new java.awt.Color(255, 204, 255));
        lblbreakfast.setText("Breakfast");
        getContentPane().add(lblbreakfast, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 100, 30));

        lbladhar3.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbladhar3.setForeground(java.awt.Color.white);
        lbladhar3.setText("Time:-");
        getContentPane().add(lbladhar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 70, 30));

        lbllunch.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbllunch.setForeground(new java.awt.Color(255, 204, 255));
        lbllunch.setText("Lunch");
        getContentPane().add(lbllunch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 70, 30));

        lbldinner.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbldinner.setForeground(new java.awt.Color(255, 204, 255));
        lbldinner.setText("Dinner");
        getContentPane().add(lbldinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 110, 30));

        lbllunch2.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbllunch2.setForeground(java.awt.Color.white);
        lbllunch2.setText("Adhar Number");
        getContentPane().add(lbllunch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 160, 30));

        lblfood.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblfood.setForeground(java.awt.Color.white);
        lblfood.setText("Food menu:-");
        getContentPane().add(lblfood, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 120, 30));

        lbllunch3.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbllunch3.setForeground(java.awt.Color.white);
        lbllunch3.setText("Adhar Number");
        getContentPane().add(lbllunch3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 160, 30));

        lbllunch1.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbllunch1.setForeground(java.awt.Color.white);
        lbllunch1.setText("Adhar Number");
        getContentPane().add(lbllunch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 160, 30));

        lbldinner2.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbldinner2.setForeground(java.awt.Color.white);
        lbldinner2.setText("Adhar Number");
        getContentPane().add(lbldinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 170, 30));

        lbldinner1.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbldinner1.setForeground(java.awt.Color.white);
        lbldinner1.setText("Adhar Number");
        getContentPane().add(lbldinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 170, 30));

        lbldinner3.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lbldinner3.setForeground(java.awt.Color.white);
        lbldinner3.setText("Adhar Number");
        getContentPane().add(lbldinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 170, 30));

        lblbreak2.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblbreak2.setForeground(java.awt.Color.white);
        lblbreak2.setText("Adhar Number");
        getContentPane().add(lblbreak2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 160, 30));

        lblbreak1.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblbreak1.setForeground(java.awt.Color.white);
        lblbreak1.setText("Adhar Number");
        getContentPane().add(lblbreak1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 160, 30));

        lblbreak3.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblbreak3.setForeground(java.awt.Color.white);
        lblbreak3.setText("Adhar Number");
        getContentPane().add(lblbreak3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 160, 30));

        lblweekday.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        lblweekday.setForeground(java.awt.Color.white);
        lblweekday.setText("Lunch");
        getContentPane().add(lblweekday, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 110, 30));
        getContentPane().add(lblbackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        setBounds(170, 150, 692, 409);
        //gettime();
    }//GEN-LAST:event_formWindowOpened

    private void btnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseClicked
        HomePage.dashboard=true;
        this.setVisible(false);
    }//GEN-LAST:event_btnexitMouseClicked

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnexit;
    private javax.swing.JLabel lblabsentstd;
    private javax.swing.JLabel lbladhar3;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblbreak1;
    private javax.swing.JLabel lblbreak2;
    private javax.swing.JLabel lblbreak3;
    private javax.swing.JLabel lblbreakfast;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldinner;
    private javax.swing.JLabel lbldinner1;
    private javax.swing.JLabel lbldinner2;
    private javax.swing.JLabel lbldinner3;
    private javax.swing.JLabel lblfather;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblfood;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lbllunch;
    private javax.swing.JLabel lbllunch1;
    private javax.swing.JLabel lbllunch2;
    private javax.swing.JLabel lbllunch3;
    private javax.swing.JLabel lblmobile;
    private javax.swing.JLabel lblmother;
    private javax.swing.JLabel lblpresentstd;
    private javax.swing.JLabel lbltime;
    private javax.swing.JLabel lbltotalstd;
    private javax.swing.JLabel lblweekday;
    // End of variables declaration//GEN-END:variables
}
