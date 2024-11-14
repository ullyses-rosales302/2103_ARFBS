
package MyConnection;
import java.sql.*;
import javax.swing.JOptionPane;

public class MyConnection {
    private static Connection connect;
    private static MyConnection DBconn;
   
    private static String url = "jdbc:mysql://localhost:3306/semprojdb";
    private static String user = "root";
    private static String password = "";

   
    public MyConnection() {
        connect = null;
        try {
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage(), 
                                          "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public static MyConnection getMyConnection() {
        if (DBconn == null) {
            synchronized (MyConnection.class) {
                if (DBconn == null) {
                    DBconn = new MyConnection();
                }
            }
        }
        return DBconn;
    }
 
    public static Connection getConnection() {
        return connect;
    }
    
    public static void main(String[] args) {
        
    }
}
