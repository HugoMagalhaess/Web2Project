/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import persistenceDAOPdo.UserDAOPdo;

/**
 *
 * @author Hugo Magalhaes
 */
public class RegisterUser {
    
    public boolean registerUser(User user){
    boolean result = false;
        UserDAOPdo pickmethod =  new UserDAOPdo();
            
       result = pickmethod.registration(user);
        
       return  result;
    }
    
}
