/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                
                LoginController lc = new LoginController();
               // lc.userData(username, password);
                lc.doPost(request,response);
                break;
            case "home":
                //implemntar home depois de logado;
                break;
        }
        
        
    }// </editor-fold>

}
