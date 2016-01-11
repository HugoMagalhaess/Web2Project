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
import model.RegisterUser;
import model.User;

/**
 *
 * @author Hugo Magalhaes
 */
public class RegisterController extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       User user = new User();
       RegisterUser register =  new RegisterUser();
       boolean result = false;
        
       user.setName(request.getParameter("name"));
       user.setEmail(request.getParameter("email"));
       user.setPassword(request.getParameter("password"));
       
       result = register.registerUser(user);
       
       if(result == true){
           RequestDispatcher redirect =  request.getRequestDispatcher("/login.jsp");
           redirect.forward(request, response);
       }else{
           RequestDispatcher redirect =  request.getRequestDispatcher("/index.html");
           redirect.forward(request, response);
       }
      
       
       
        
    }

  
}
