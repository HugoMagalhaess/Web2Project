/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jdk.nashorn.tools.Shell;
import persistenceDAOPdo.UserDAOPdo;

/**
 *
 * @author Hugo Magalhaes
 */
public class Authenticator {
        
        private UserDAOPdo udaop = null;
        private User user = null;
    
    public User authenticate(String username, String password) {
            
             udaop =  new UserDAOPdo();
             user =  new User();
             user.setEmail(username);
             user.setPassword(password);
             
             user = udaop.searchUserByEmail(user);
             
             System.out.println(user.getName());
             if (username.equalsIgnoreCase(user.getEmail())&& (password.equalsIgnoreCase(user.getPassword()) )) {
            
                  return user;
            }else{
                 return null;
             }
            
            
           

        }
}
