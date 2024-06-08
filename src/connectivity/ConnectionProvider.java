
package connectivity;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectionProvider {
    public static Connection getCon()
    {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel?zeroDateTimeBehavior=CONVERT_TO_NULL","Ritesh","Ritesh@123");
            //jdbc:mysql://localhost:336/hostel
            //System.out.println(con);
            return con;
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, "Please Connect To Database");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Connect To Database");
            return null;
        }
        return con;
    }
}
