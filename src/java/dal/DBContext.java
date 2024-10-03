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
            String user = System.getenv("DB_USER");  // Lấy user từ biến môi trường
            String pass = System.getenv("DB_PASS");  // Lấy mật khẩu từ biến môi trường
            String url = System.getenv("DB_URL");    // Lấy URL từ biến môi trường
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        DBContext a = new DBContext();
        System.out.println(a.connection);
    }
}
