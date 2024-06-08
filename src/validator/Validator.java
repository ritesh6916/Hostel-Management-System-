/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;
import java.sql.Connection;
import connectivity.ConnectionProvider;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author ritesh Singh
 */
public class Validator {
    public static boolean validateStudent(String id)
    {
        
        Connection con=ConnectionProvider.getCon();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from admission where room_id="+id);
            while(rs.next())
            {
                if(id.equals(rs.getString(1)))
                {
                    return true;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
    public static boolean validateRegistration(String id)
    {
        Connection con=ConnectionProvider.getCon();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from studentregistrations where std_id="+id);
            
            while(rs.next())
            {
                
                System.out.println(id);
                if(id.equals(rs.getString(1)))
                {
                    //JOptionPane.showMessageDialog(null, "in if");
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    
    public static boolean validateRoom(String id)
    {
        Connection con=ConnectionProvider.getCon();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from rooms where room_id="+id);
            while(rs.next())
            {
                if(id.equals(rs.getString(1)))
                {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    public static boolean validateEmail(String email)
    {
        boolean b;
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        b=email.matches(regex);
        return b;
    }
    public static boolean validateStrongPassword(String password)
    {
        boolean b;
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,15}$";
        b=password.matches(regex);
        return b;
    }
    public static boolean validateMobile(String mobile)
    {
        boolean b;
        String regex ="\\d{10}";
        b=mobile.matches(regex);
        return b;
    }
    public static boolean validateAdhar(String adhar)
    {
        boolean b;
        String regex ="\\d{12}";
        b=adhar.matches(regex);
        return b;
    }
    public static boolean validatePhoto(File f)
    {
        boolean b=false;
        String name="";
        try {
            name=f.getName();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please Choose a file");
        }
        
        System.out.println(name);
        String extention = name.substring(name.lastIndexOf(".") + 1);
        if("jpeg".equalsIgnoreCase(extention)||"jpg".equalsIgnoreCase(extention)||"png".equalsIgnoreCase(extention))
        {
            b=true;
        }
        System.out.println(extention);
        return b;
    }
}
