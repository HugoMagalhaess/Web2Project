/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hugo Magalhaes
 */
public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        
        String dbuser = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/olxbaby";
        Connection con = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,dbuser,password);
        
        return con;
    }
}
