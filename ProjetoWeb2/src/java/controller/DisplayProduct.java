/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

/**
 *
 * @author Hugo Magalhaes
 */
public class DisplayProduct extends HttpServlet {

    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         List<Product>  products =   null; 
        ProductDAOPdo productDAOpdo = new ProductDAOPdo();
        RequestDispatcher rd = null;
        HttpSession session;
        session = request.getSession();
                
        products = productDAOpdo.ListAllproducts();
        if (products != null) {
            session.setAttribute("products", products);
            rd = request.getRequestDispatcher("/myProducts.jsp");
            rd.forward(request, response);
        }else{
            rd = request.getRequestDispatcher("/error.jsp");
        }
 
        }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 List<Product>  products =   null; 
        
        User user = null;
        ProductDAOPdo productDAOpdo = new ProductDAOPdo();
        RequestDispatcher rd = null;
        HttpSession session;
        session = request.getSession();
        user =  (User)session.getAttribute("user");
        
        products = productDAOpdo.ListAllUserProducts(user);
        if (products != null) {
            session.setAttribute("products", products);
            rd = request.getRequestDispatcher("/myProducts.jsp");
            
        }else{
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
        
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

}
