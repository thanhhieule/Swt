package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

  protected Connection connection;

    public DBContext() {
        try {
            String user = "anhnq";
            String pass = "ninhchi2023";
            String url = "jdbc:sqlserver://DESKTOP-A8V77FL\\\\SQLEXPRESS:1433;databaseName=Assgn_PRJ_WEB_Ban_Noi_That";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        DBContext a = new DBContext();
        System.out.println(a.connection);
    }
}
