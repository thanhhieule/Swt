package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

public class AcountDBContext extends DBContext {

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Account WHERE isAdmin != 1";

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setUid(rs.getInt("uid"));
                account.setUser(rs.getString("username"));
                account.setPass(rs.getString("password"));
                account.setIsSell(rs.getInt("isSell"));
                account.setIsAdmin(rs.getInt("isAdmin"));
                account.setActive(rs.getBoolean("isActive"));
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                account.setAddress(rs.getString("address"));
                account.setPhone(rs.getString("phone"));

                list.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing ResultSet", e);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing PreparedStatement", e);
                }
            }
        }
        return list;
    }

    public Account login(String user, String pass) {
        Account account = null;
        String sql = "SELECT * FROM Account WHERE [user] = ? AND [pass] = ?";

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            rs = stm.executeQuery();

            if (rs.next()) {
                account = new Account();
                account.setUid(rs.getInt("uid"));
                account.setUser(rs.getString("user"));
                account.setPass(rs.getString("pass"));
                account.setIsSell(rs.getInt("isSell"));
                account.setIsAdmin(rs.getInt("isAdmin"));
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                account.setAddress(rs.getString("address"));
                account.setPhone(rs.getString("phone"));
                account.setActive(rs.getBoolean("active"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing ResultSet", e);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing PreparedStatement", e);
                }
            }
        }
        return account;
    }

    public Account checkAccountExistByUserPass(String user, String pass) {
        Account account = null;
        String sql = "SELECT * FROM Account WHERE [user] = ? AND [pass] = ?";

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            rs = stm.executeQuery();

            if (rs.next()) {
                account = new Account();
                account.setUid(rs.getInt("uid"));
                account.setUser(rs.getString("user"));
                account.setPass(rs.getString("pass"));
                account.setIsSell(rs.getInt("isSell"));
                account.setIsAdmin(rs.getInt("isAdmin"));
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                account.setAddress(rs.getString("address"));
                account.setPhone(rs.getString("phone"));
                account.setActive(rs.getBoolean("active"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error checking account", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing ResultSet", e);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing PreparedStatement", e);
                }
            }
        }
        return account;
    }

    public Account checkAccountExist(String user) {
        Account account = null;
        String sql = "SELECT * FROM Account WHERE [user] = ?";

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            rs = stm.executeQuery();

            if (rs.next()) {
                account = new Account();
                account.setUid(rs.getInt("uid"));
                account.setUser(rs.getString("user"));
                account.setPass(rs.getString("pass"));
                account.setIsSell(rs.getInt("isSell"));
                account.setIsAdmin(rs.getInt("isAdmin"));
                account.setActive(rs.getBoolean("active"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing ResultSet", e);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing PreparedStatement", e);
                }
            }
        }
        return account;
    }

    public void insertAccount(String user, String pass, String firstName, String lastName, String address, String phone) {
        String sql = "INSERT INTO [Account] ([user], [pass], [isSell], [isAdmin], [firstName], [lastName], [address], [phone], [active]) VALUES (?, ?, 0, 0, ?, ?, ?, ?, 1)";

        PreparedStatement stm = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.setString(3, firstName);
            stm.setString(4, lastName);
            stm.setString(5, address);
            stm.setString(6, phone);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing PreparedStatement", e);
                }
            }
        }
    }

    public Account getAccountById(int accountId) {
        Account account = null;
        String sql = "SELECT * FROM Account WHERE uid = ?";

        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, accountId);
            rs = stm.executeQuery();

            if (rs.next()) {
                account = new Account();
                account.setUid(rs.getInt("uid"));
                account.setUser(rs.getString("user"));
                account.setPass(rs.getString("pass"));
                account.setIsSell(rs.getInt("isSell"));
                account.setIsAdmin(rs.getInt("isAdmin"));
                account.setFirstName(rs.getString("firstName"));
                account.setLastName(rs.getString("lastName"));
                account.setAddress(rs.getString("address"));
                account.setPhone(rs.getString("phone"));
                account.setActive(rs.getBoolean("active"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing ResultSet", e);
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error closing PreparedStatement", e);
                }
            }
        }
        return account;
    }

 public Account getAccountByUser(String username) {
        Account account = null;
        String sql = "SELECT * FROM [Account] WHERE [user] = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, username);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    account = new Account();
                    account.setUid(rs.getInt("uID"));
                    account.setUser(rs.getString("user"));
                    account.setPass(rs.getString("pass"));
                    account.setIsSell(rs.getInt("isSell"));
                    account.setIsAdmin(rs.getInt("isAdmin"));
                    account.setFirstName(rs.getString("firstName"));
                    account.setLastName(rs.getString("lastName"));
                    account.setAddress(rs.getString("address"));
                    account.setPhone(rs.getString("phone"));
                    account.setActive(rs.getBoolean("active"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error getting account", ex);
            throw new RuntimeException("Error retrieving account from database", ex); //Improved error handling
        }
        return account;
    }


    public void updateAccount(Account account) {
        updateAccount2(account); //Consolidate update functions.
    }

    public void updatePassword(String pass, String user) {
        try (PreparedStatement stm = connection.prepareStatement("UPDATE [Account] SET [pass] = ? WHERE [user] = ?")) {
            stm.setString(1, pass);
            stm.setString(2, user);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AcountDBContext.class.getName()).log(Level.SEVERE, "Error updating password", ex);
            throw new RuntimeException("Error updating password in database", ex); //Improved error handling
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
            throw new RuntimeException("Error updating account in database", ex); //Improved error handling
        }
    }
   
}

