/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.Product;

public class ProductDBContext extends DBContext {

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from product";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImageUrl(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTiltle(rs.getString(5));
                product.setDescription(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                product.setSell_ID(rs.getInt(8));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product where Product.cateID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImageUrl(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTiltle(rs.getString(5));
                product.setDescription(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                product.setSell_ID(rs.getInt(8));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getProductsWithPagging(int page, int PAGE_SIZE) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select *  from Product order by id\n"
                    + "offset (?-1)*? row fetch next ? rows only";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, page);
            stm.setInt(2, PAGE_SIZE);
            stm.setInt(3, PAGE_SIZE);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImageUrl(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTiltle(rs.getString(5));
                product.setDescription(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                product.setSell_ID(rs.getInt(8));
                product.setQuantity(rs.getInt(9)); // Add this line
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTotalProducts() {
        try {
            String sql = "select count(id)  from Product ";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Product> search(String keyword) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select *  from Product where name like ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + keyword + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImageUrl(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTiltle(rs.getString(5));
                product.setDescription(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                product.setSell_ID(rs.getInt(8));
                list.add(product);

            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

 public Product getProductById(int productId) {
    Product product = null;
    try {
        String sql = "SELECT * FROM product WHERE id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, productId);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setImageUrl(rs.getString("image"));
            product.setPrice(rs.getDouble("price"));
            product.setQuantity(rs.getInt("quantity")); // Ensure this matches your column name
            product.setTiltle(rs.getString("title")); // Typo corrected to "title"
            product.setDescription(rs.getString("description"));
            product.setCategoryId(rs.getInt("cateID")); // Ensure this matches your column name
            product.setSell_ID(rs.getInt("sell_ID")); // Ensure this matches your column name
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
    }
    return product;
}


    public List<Product> getProductsBySellId(int Id) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product where sell_ID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImageUrl(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTiltle(rs.getString(5));
                product.setDescription(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                product.setSell_ID(rs.getInt(8));
                product.setQuantity(rs.getInt(9)); // Add this line
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

   
    public void inSertProduct(Product product) {
        try {
            String sql = "INSERT INTO [product]\n"
                    + "           ([name]\n"
                    + "           ,[image]\n"
                    + "           ,[price]\n"
                    + "           ,[title]\n"
                    + "           ,[description]\n"
                    + "           ,[cateID]\n"
                    + "           ,[sell_ID]\n"
                    + "           ,[quantity])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, product.getName());
            stm.setString(2, product.getImageUrl());
            stm.setDouble(3, product.getPrice());
            stm.setString(4, product.getTiltle());
            stm.setString(5, product.getDescription());
            stm.setInt(6, product.getCategoryId());
            stm.setInt(7, product.getSell_ID());
            stm.setInt(8, product.getQuantity());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM [Product]\n"
                    + "WHERE id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void updateProduct(Product p) {
    try {
        String sql = "UPDATE [product] SET \n"
                + "    [name] = ?,\n"
                + "    [image] = ?,\n"
                + "    [price] = ?,\n"
                + "    [title] = ?,\n"
                + "    [description] = ?,\n"
                + "    [cateID] = ?,\n"
                + "    [sell_ID] = ?,\n"
                + "    [quantity] = ?\n"  // Update this line to match your column name
                + "WHERE \n"
                + "    [id] = ?";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, p.getName());
        stm.setString(2, p.getImageUrl());
        stm.setDouble(3, p.getPrice());
        stm.setString(4, p.getTiltle());
        stm.setString(5, p.getDescription());
        stm.setInt(6, p.getCategoryId());
        stm.setInt(7, p.getSell_ID());
        stm.setInt(8, p.getQuantity()); // Make sure this corresponds to your product's quantity property
        stm.setInt(9, p.getId()); // Ensure this matches the product ID
        stm.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    public List<Product> getAllProductsLast() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 4 * FROM product ORDER BY ID DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setImageUrl(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setTiltle(rs.getString(5));
                product.setDescription(rs.getString(6));
                product.setCategoryId(rs.getInt(7));
                product.setSell_ID(rs.getInt(8));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
    public void updateQuantityAfterPurchase(int productId, int quantityPurchased) {
        String sql = "UPDATE [Assgn_PRJ_WEB_Ban_Noi_That1].[dbo].[product] SET " +
                     "[quantity] = [quantity] - ? " +
                     "WHERE [id] = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, quantityPurchased);
            stm.setInt(2, productId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//  
//     public static void main(String[] args) {
//        try {
//            // Assuming you have already established a connection in your DBContext
//            ProductDBContext dbContext = new ProductDBContext(); // Initialize your DBContext here
//
//            // Assuming Product class and its properties
//            Product productToUpdate = new Product();
//            productToUpdate.setId(1); // Replace with the ID of the product you want to update
//            productToUpdate.setName("King Size Bed Frame");
//            productToUpdate.setImageUrl("https://m.media-amazon.com/images/I/81etcPmRyZL._AC_UF894,1000_QL80_.jpg");
//            productToUpdate.setPrice(200.00);
//            productToUpdate.setTiltle("Majestic Comfort for Your Bedroom");
//            productToUpdate.setDescription("The King Size Bed Frame is the epitome of majestic comfort for your bedroom. "
//                    + "Crafted from high-quality materials, this bed frame features a sturdy hardwood construction that ensures durability and stability. "
//                    + "The headboard is upholstered in luxurious fabric, adding a touch of elegance to the overall design. "
//                    + "The slatted base provides excellent support for your mattress, promoting proper airflow and extending the life of your bedding. "
//                    + "The bed frame is available in various finishes, including classic walnut, sleek black, and modern white, allowing you to choose the perfect match for your bedroom decor. "
//                    + "Additionally, the frame is designed with easy assembly in mind, with all necessary hardware included. "
//                    + "The King Size Bed Frame is not only a statement piece but also a practical addition to your bedroom, providing a comfortable and stylish foundation for a restful night");
//            productToUpdate.setCategoryId(2);
//            productToUpdate.setSell_ID(1);
//            productToUpdate.setQuantity(72);
//
//            // Call the updateProduct method
//            dbContext.updateProduct(productToUpdate);
//
//            System.out.println("Product updated successfully.");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
}
