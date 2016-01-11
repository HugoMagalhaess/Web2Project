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

/**
 *
 * @author Hugo Magalhaes
 */
public class HandlerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String param = request.getParameter("action");
       
                
        switch(param){
            case "login":
                
                //utilizar  request dispatcher  para  encaminhar 
                
                LoginController lc = new LoginController();
               // lc.userData(username, password);
                lc.doPost(request,response);
                break;
            case "logout":
                LogoutController logout = new LogoutController();
                logout.doPost(request, response);
                break;
            case "myaccout":
                //link para a pagina minha conta;
                 break;
            case "register":
                RegisterController rc = new RegisterController();
                rc.doPost(request, response); 
                break;
            case "update":
                break;
                
        }
        
        
    }// </editor-fold>

}
