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

import model.Authenticator;
import model.Product;
import model.User;
import persistenceDAOPdo.ProductDAOPdo;
import persistenceDAOPdo.UserDAOPdo;

/**
 *
 * @author Hugo Magalhaes
 */
public class LoginController extends HttpServlet {

    
    
    public LoginController(){
        super();
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String username = request.getParameter("username");// lembrar de trocar para email na pagina jsp  e trocar todos para email
         String password =  request.getParameter("password");
         RequestDispatcher rd = null;
         List<Product> products;
         ProductDAOPdo plist = new ProductDAOPdo();
         products =  plist.ListAllproducts();
                 
         Authenticator authenticator = new Authenticator();
                 
                User user = authenticator.authenticate(username, password);
                
                
		if (user != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);   
                        if(products != null){
                        session.setAttribute("products", products);
                        }
                        rd = request.getRequestDispatcher("/success.jsp");
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
}

   

