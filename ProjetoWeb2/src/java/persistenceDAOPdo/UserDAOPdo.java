/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenceDAOPdo;

import java.sql.Connection;
import model.User;
import persistenceDAO.UserDAO;

/**
 *
 * @author Hugo Magalhaes
 */
public class UserDAOPdo implements UserDAO{

    @Override
    public User searchUser(User user) {
        ConnectionDAOPdo con = null;
        Connection connection = null;
        String querry = ("Select * from users");
        
        con =  new ConnectionDAOPdo();
        connection =  con. getConnection();
        
        stmt  =  c
        
   return user;
    
    }

}