/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenceDAOPdo;

import factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.User;
import persistenceDAO.ProductDAO;

/**
 *
 * @author Hugo Magalhaes
 */
public class ProductDAOPdo implements ProductDAO{

    @Override
    public boolean insertProduct(Product product, User user) {
        
        
        try {
            Connection connection = new ConnectionFactory().getConnection();
            
            
           // inserir com imagem essa  seri  a string correta   
           // String sql  = "insert into product (productTitle, productPrice, productDescrpition, productImage, user_iduser, city, state) values (?,?,?,?)";
            
            String sql  = "insert into product (producTitle, productPrice, productDescrpition, user_iduser) values (?,?,?,?)";
           
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getTitle());
            stmt.setString(2, product.getPrice());
            stmt.setString(3, product.getDescription());
            stmt.setInt(4, user.getUserID());
            stmt.setString(5, user.getStreet());
            
            
            
            stmt.execute();
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
    return true;
    }

    @Override
    public boolean removeProduct(int idProduct) {
    
        boolean result = false;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql  = "DELETE * FROM  product WHERE idproduct = "+ idProduct+ " ;";
            
             PreparedStatement stmt = connection.prepareStatement(sql);
            result = stmt.execute(sql);
             stmt.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        return result;
    
    }

    @Override
    public boolean editProduct(Product product, User user) {
      
        try {
            Connection connection = new ConnectionFactory().getConnection();
            
            
           // inserir com imagem essa  seri  a string correta   
           // String sql  = "insert into product (productTitle, productPrice, productDescrpition, productImage, user_iduser, city, state) values (?,?,?,?)";
            
            String sql  = "UPDATE product SET productTitle = ?, productPrice = ? , productDescrpition = ? , user_iduser values =  ?";
           
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getTitle());
            stmt.setString(2, product.getPrice());
            stmt.setString(3, product.getDescription());
            stmt.setInt(4, user.getUserID());
            
            stmt.execute();
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
    return true;
    }

    @Override
    public List<Product> ListAllproducts() {
       
          List<Product> products = new ArrayList<Product>();  
          
        try {
            Connection connection = new ConnectionFactory().getConnection();
            
            
            String sql  = "SELECT * FROM product;";
           
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            
            ResultSet rs  = stmt.executeQuery(sql);
                while (rs.next()) {                
                    Product product  = new Product();
                    product.setIdProduct(rs.getByte("idProduct"));
                    product.setDescription(rs.getNString("productDescrpition")); //vai dar  pau ajeitar  no banco
                    product.setPrice(rs.getString("productPrice"));
                    product.setProductImage(rs.getString("productImage"));
                    product.setProductName(rs.getString("producTitle"));
                    product.setProductUserID(rs.getInt("user_iduser"));
                    products.add(product);
                  
                }
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return products;
    }

    @Override
    public List<Product> ListAllUserProducts(User user ) {
       
        List<Product> products = new ArrayList<Product>();  
          
        try {
            Connection connection = new ConnectionFactory().getConnection();
            
            
            String sql  = "SELECT * FROM product WHERE user_iduser="+ user.getUserID()+";";
           
            PreparedStatement stmt = connection.prepareStatement(sql); 
            ResultSet rs  = stmt.executeQuery(sql);
                while (rs.next()) {                
                    Product product  = new Product();
                    product.setIdProduct(rs.getByte("idProduct"));
                    product.setDescription(rs.getNString("productDescrpition")); //vai dar  pau ajeitar  no banco
                    product.setPrice(rs.getString("productPrice"));
                    product.setProductImage(rs.getString("productImage"));
                    product.setProductName(rs.getString("producTitle"));
                    product.setProductUserID(rs.getInt("user_iduser"));
                    products.add(product);
                  
                }
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return products;
    }

    @Override
    public List<Product> ListbyCategory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product searchProductById(int idProduct) {
           
          Product product = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            
            
            String sql  = "SELECT * FROM product WHERE idproduct= "+ idProduct+ ";";
           
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            
            ResultSet rs  = stmt.executeQuery(sql);
                while (rs.next()) {                
                    product  = new Product();
                    product.setIdProduct(rs.getByte("idProduct"));
                    product.setDescription(rs.getNString("productDescrpition")); //vai dar  pau ajeitar  no banco
                    product.setPrice(rs.getString("productPrice"));
                    product.setProductImage(rs.getString("productImage"));
                    product.setProductName(rs.getString("producTitle"));
                    product.setProductUserID(rs.getInt("user_iduser")); 
                }
            rs.close();
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
    return product;
    }

   
    
}
