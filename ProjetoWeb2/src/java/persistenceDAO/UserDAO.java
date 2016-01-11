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
 * T
 */
public interface UserDAO {
    public User searchUserByEmail(User user);
    public boolean registration(User user);
    public void updateUser(User user);
    public void deleteUser (User user);
    public void insertUser(User user);
}
