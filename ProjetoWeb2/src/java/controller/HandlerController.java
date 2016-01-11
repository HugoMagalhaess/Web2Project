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
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String param = request.getParameter("action");
          
                
        switch(param){
            case "login":
                LoginController lc = new LoginController();
                lc.doPost(request,response);
                break;
            case "logout":
                LogoutController logout = new LogoutController();
                logout.doPost(request, response);
                break;
            case "myProducts":
                DisplayProduct displayProduct = new DisplayProduct();
                displayProduct.doPost(request, response);
                 break;
            case "register":
                RegisterController rc = new RegisterController();
                rc.doPost(request, response); 
                break;
            case "ProductDetails":
              int userId = Integer.parseInt(request.getParameter("idproduct"));
               ProductDetailsController detailsController = new ProductDetailsController();
               detailsController.doPost(request, response);
                break;
            case "deleteProduct":
                 DeleteProductController deleteProductController = new DeleteProductController();
                 deleteProductController.doPost(request, response);
                break;
                
        }
}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String param = request.getParameter("action");
        
                
        switch(param){
            case "login":
                LoginController lc = new LoginController();
                lc.doPost(request,response);
                break;
            case "logout":
                LogoutController logout = new LogoutController();
                logout.doPost(request, response);
                break;
            case "myProducts":
                DisplayProduct displayProduct = new DisplayProduct();
                displayProduct.doPost(request, response);
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
