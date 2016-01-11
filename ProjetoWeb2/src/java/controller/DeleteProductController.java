/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class DeleteProductController extends HttpServlet {

 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean result;
        
        RequestDispatcher rd = null;
        HttpSession session;
        session = request.getSession();
        ProductDAOPdo productDAOPdo =  new ProductDAOPdo();
        int productId = Integer.parseInt(request.getParameter("idproduct"));
        
        result = productDAOPdo.removeProduct(productId);
        
        if (result == true) {
           
            rd = request.getRequestDispatcher("HandlerController?action=myProducts");
            
        }else{
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
        
    
    
    }

}
