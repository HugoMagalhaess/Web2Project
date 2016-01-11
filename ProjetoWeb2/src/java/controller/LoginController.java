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

import model.Authenticator;
import model.User;
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
        
        Authenticator authenticator = new Authenticator();
                   
                User user = authenticator.authenticate(username, password);
		if (user != null) {
			//rd = request.getRequestDispatcher("/success.jsp");
			
			                // UserDAOPdo teste = new UserDAOPdo();
                                        // teste.insertUser(user);
                        HttpSession session = request.getSession();
                        session.setAttribute("username", user.getName());
                        
                        //request.setAttribute("user", user);
                        rd = request.getRequestDispatcher("/success.jsp");
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
}

   

