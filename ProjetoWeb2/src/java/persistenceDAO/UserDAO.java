/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenceDAO;

import model.User;

/**
 *
 * @author Hugo Magalhaes
 */
public interface UserDAO {
    public User searchUser(User user);
   // public User registration(User user);
   // public User updateUser(User user);
    
    
}
