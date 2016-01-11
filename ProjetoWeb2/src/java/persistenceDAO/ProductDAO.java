/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenceDAO;

import java.util.List;
import model.Product;
import model.User;

/**
 *
 * @author Hugo Magalhaes
 */
public interface ProductDAO {
    
    public boolean insertProduct(Product product, User user);
    public boolean removeProduct(int idProduct);
    public boolean editProduct(Product product, User user);
    public List<Product> ListAllproducts();
    public List<Product> ListAllUserProducts(User user);
    public List<Product> ListbyCategory(); 
    public Product searchProductById(int idProduct);
}
