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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import persistenceDAO.UserDAO;

/**
 *
 * @author Hugo Magalhaes
 */
public class UserDAOPdo implements UserDAO{

    @Override
    public void insertUser(User user) {
         try {
            Connection connection = new ConnectionFactory().getConnection();
            System.out.println("Conexao aberta");
            
            String sql  = "insert into user (username,password, email, name, street, city, state) values (?,?,?,?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getName());
            stmt.setString(5, user.getStreet());
            stmt.setString(6, user.getCity());
            stmt.setString(7, user.getState());
            
            
            stmt.execute();
            stmt.close();
            
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
         
    }

    @Override
    public boolean registration(User user) { // Falta colocar o registro geral
       boolean result = false;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            System.out.println("Conexao aberta");
            
            String sql  = "insert into user (password, email, name) values (?,?,?)";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
       
            stmt.setString(1, user.getPassword());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getName());
           // stmt.setString(5, user.getStreet());
           // stmt.setString(6, user.getCity());
           // stmt.setString(7, user.getState());
            
            
            result = stmt.execute();
            stmt.close();
            
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  result;
    }
    
    @Override
    public void updateUser(User user) {
       
        try {
            Connection connection = new ConnectionFactory().getConnection();
            System.out.println("Conexao aberta");
            
            
            String sql  = "UPDATE user set username=?, email=?, name=?, street=?, city=?, state=? where id =?";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getStreet());
            stmt.setString(5, user.getCity());
            stmt.setString(6, user.getState());
            stmt.setInt(7, user.getUserID());
            
            
            stmt.execute();
            stmt.close();
            
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteUser(User user) {
    
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "DELETE FROM user WHERE email=?";
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.execute();
            stmt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public User searchUserByEmail(User user) {
        
        User fUser = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM user WHERE email = '"+ user.getEmail()+"';";
            System.out.println(sql);
            PreparedStatement stmt  =  connection.prepareStatement(sql); //ta dando erro aqui
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                fUser = new User();
                fUser.setName(rs.getString("name"));
                fUser.setEmail(rs.getString("email"));
                fUser.setPassword(rs.getString("password"));
                fUser.setStreet(rs.getString("street"));
                fUser.setUserID(rs.getInt("iduser"));
                fUser.setCity(rs.getString("city"));
                fUser.setPhone(rs.getString("phone"));
                fUser.setUrlImage(rs.getNString("image"));
                      
            }
            rs.close();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  fUser;
        
    }

    @Override
    public User searchUserById(int userId) {
       
        User fUser = null;
        try {
            Connection connection = new ConnectionFactory().getConnection();
            String sql = "SELECT * FROM user WHERE iduser = '"+ userId +"';";
            System.out.println(sql);
            PreparedStatement stmt  =  connection.prepareStatement(sql); //ta dando erro aqui
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                fUser = new User();
                fUser.setName(rs.getString("name"));
                fUser.setEmail(rs.getString("email"));
                fUser.setPassword(rs.getString("password"));
                fUser.setStreet(rs.getString("street"));
                fUser.setUserID(rs.getInt("iduser"));
                fUser.setCity(rs.getString("city"));
                fUser.setPhone(rs.getString("phone"));
                fUser.setUrlImage(rs.getNString("image"));
                      
            }
            rs.close();
            stmt.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOPdo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return  fUser;
    }

  

}