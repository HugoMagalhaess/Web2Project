/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.User;
import persistenceDAOPdo.ProductDAOPdo;
import persistenceDAOPdo.UserDAOPdo;

/**
 *
 * @author Hugo Magalhaes
 */
public class ProductDetailsController extends HttpServlet {

  
  
  
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Product product;
        User user = null;
        ProductDAOPdo productDAOpdo = new ProductDAOPdo();
        UserDAOPdo udao =  new UserDAOPdo();
        
        RequestDispatcher rd = null;
        HttpSession session;
        session = request.getSession();
        
        int productId = Integer.parseInt(request.getParameter("idproduct"));
        
        product = productDAOpdo.searchProductById(productId);
        user = udao.searchUserById(product.getProductUserID());
        if (product != null) {
            session.setAttribute("product", product);
            session.setAttribute("contato", user);
            rd = request.getRequestDispatcher("/productdetails.jsp");
            
        }else{
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
        
        
        
        
    }

}
