
package persistenceDAOPdo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



/**
 *
 * @author Hugo Magalhaes
 */
public class ConnectionDAOPdo {

    public ConnectionDAOPdo() {
    }
    
    
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        
        String dbuser = "root";
        String password = "password";
        String url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        
        Class.forName("com.mysql.jadc.Driver");
        con = DriverManager.getConnection(url,dbuser,password);
        
        return con;
    }
    
    
}
