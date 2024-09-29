/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Product;


/**
 *
 * @author Admin
 */
public class AcountDBContext extends DBContext {

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Account where isAdmin != 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setUid(rs.getInt(1));
                account.setUser(rs.getString(2));
                account.setPass(rs.getString(3));
                account.setIsSell(rs.getInt(4));
                account.setIsAdmin(rs.getInt(5));
                account.setActive(rs.getBoolean(6));
                
                account.setFirstName(rs.getString(6));
                account.setLastName(rs.getString(7));
                account.setAddress(rs.getString(8));
                account.setPhone(rs.getString(9));
                list.add(account);
            }
        } catch (Exception ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public Account login(String user, String pass) {
    Account a = null;
    try {
        String sql = "SELECT * FROM Account WHERE [user] = ? AND [pass] = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, user);
        stm.setString(2, pass);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            a = new Account();
            a.setUid(rs.getInt("uID"));
            a.setUser(rs.getString("user"));
            a.setPass(rs.getString("pass"));
            a.setIsSell(rs.getInt("isSell"));
            a.setIsAdmin(rs.getInt("isAdmin"));
            a.setFirstName(rs.getString("firstName"));  // Nếu cần thiết
            a.setLastName(rs.getString("lastName"));    // Nếu cần thiết
            a.setAddress(rs.getString("address"));      // Nếu cần thiết
            a.setPhone(rs.getString("phone"));          // Nếu cần thiết
            a.setActive(rs.getBoolean("active"));       // Đảm bảo tên cột đúng
        }
    } catch (SQLException ex) {
        Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
    }
    return a;
}


   public Account checkAccountExistByUserPass(String user, String pass) {
    try {
        // Câu lệnh SQL để kiểm tra tài khoản
        String sql = "SELECT * FROM Account WHERE [user] = ? AND pass = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, user);
        stm.setString(2, pass);
        
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            // Tạo đối tượng Account và gán dữ liệu từ ResultSet
            Account a = new Account();
            a.setUid(rs.getInt("uID"));          // Thay vì rs.getInt(1)
            a.setUser(rs.getString("user"));     // Thay vì rs.getString(2)
            a.setPass(rs.getString("pass"));     // Thay vì rs.getString(3)
            a.setIsSell(rs.getInt("isSell"));    // Thay vì rs.getInt(4)
            a.setIsAdmin(rs.getInt("isAdmin"));  // Thay vì rs.getInt(5)
            a.setActive(rs.getBoolean("active")); // Thay vì rs.getBoolean(6)
            a.setFirstName(rs.getString("firstName")); // Nếu cần thiết
            a.setLastName(rs.getString("lastName"));   // Nếu cần thiết
            a.setAddress(rs.getString("address"));     // Nếu cần thiết
            a.setPhone(rs.getString("phone"));         // Nếu cần thiết
            return a;
        }
    } catch (SQLException ex) {
        Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error checking account", ex);
    }
    return null;
}

    
    public Account checkAccountExist(String user) {
        try {
            String sql = "SELECT * FROM Account where [user] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setUid(rs.getInt(1));
                a.setUser(rs.getString(2));
                a.setPass(rs.getString(3));
                a.setIsSell(rs.getInt(4));
                a.setIsAdmin(rs.getInt(5));
                a.setActive(rs.getBoolean(6));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
public void insertAccount(String user, String pass, String firstName, String lastName, String address, String phone) {
    try {
        String sql = "INSERT INTO [Account]\n"
                + "           ([user]\n"
                + "           ,[pass]\n"
                + "           ,[isSell]\n"
                + "           ,[isAdmin]\n"
                + "           ,[firstName]\n"
                + "           ,[lastName]\n"
                + "           ,[address]\n"
                + "           ,[phone]\n"
                + "           ,[active])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,0\n"
                + "           ,0\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,1)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, user);
        stm.setString(2, pass);
        stm.setString(3, firstName);
        stm.setString(4, lastName);
        stm.setString(5, address);
        stm.setString(6, phone);
        stm.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
    }
}



  public Account getAccountById(int accountId) {
    try {
        // Câu lệnh SQL để lấy thông tin tài khoản
        String sql = "SELECT * FROM Account WHERE uID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, accountId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Account account = new Account();
            // Đọc dữ liệu từ ResultSet
            account.setUid(rs.getInt("uID"));
            account.setUser(rs.getString("user"));  // Sử dụng tên cột đúng
            account.setPass(rs.getString("pass"));
            account.setIsSell(rs.getInt("isSell"));
            account.setIsAdmin(rs.getInt("isAdmin"));
            account.setFirstName(rs.getString("firstName"));
            account.setLastName(rs.getString("lastName"));
            account.setAddress(rs.getString("address"));
            account.setPhone(rs.getString("phone"));
            account.setActive(rs.getBoolean("active"));
            return account;
        }
    } catch (Exception ex) {
        // Ghi log lỗi
        Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

public Account getAccountByUser(String username) {
    try {
        // Câu lệnh SQL để lấy thông tin tài khoản dựa trên cột user
        String sql = "SELECT * FROM [Account] WHERE [user] = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, username); // Thay thế tham số với giá trị username
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Account account = new Account();
            // Đọc dữ liệu từ ResultSet
            account.setUid(rs.getInt("uID"));
            account.setUser(rs.getString("user"));  // Sử dụng tên cột đúng
            account.setPass(rs.getString("pass"));
            account.setIsSell(rs.getInt("isSell"));
            account.setIsAdmin(rs.getInt("isAdmin"));
            account.setFirstName(rs.getString("firstName"));
            account.setLastName(rs.getString("lastName"));
            account.setAddress(rs.getString("address"));
            account.setPhone(rs.getString("phone"));
            account.setActive(rs.getBoolean("active"));
            return account;
        }
    } catch (Exception ex) {
        // Ghi log lỗi
        Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}


   
    public void updateAccount(Account account) {

        try {
            String sql = "UPDATE [Account]\n"
                    + "   SET [active] = ?\n"
                    + " WHERE uId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setBoolean(1, account.isActive());
            stm.setInt(2, account.getUid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


   

    public void UpDatePassWord(String pass,String user) {
        try {
            String sql = "UPDATE [Account]\n"
                    + "   SET [pass] = ?\n"
                    + " WHERE [user] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pass);
            stm.setString(2, user);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void updateAccount2(Account account) {
        String sql = "UPDATE Account SET [user] = ?, pass = ?, active = ?, firstName = ?, lastName = ?, address = ?, phone = ? WHERE uID = ?";
        
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, account.getUser());
            stm.setString(2, account.getPass());
            stm.setBoolean(3, account.isActive());
            stm.setString(4, account.getFirstName());
            stm.setString(5, account.getLastName());
            stm.setString(6, account.getAddress());
            stm.setString(7, account.getPhone());
            stm.setInt(8, account.getUid());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error updating account", ex);
        }
    }
   
}

