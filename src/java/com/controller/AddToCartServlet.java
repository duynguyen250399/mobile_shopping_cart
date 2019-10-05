
package com.controller;

import com.cart.Cart;
import com.order.Order;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddToCartServlet", urlPatterns = {"/AddToCartServlet"})
public class AddToCartServlet extends HttpServlet {
       

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String userId = request.getParameter("userId");
        
        String mobileId = request.getParameter("mobileId");
        String mobileName = request.getParameter("mobileName");
        String mobilePrice = request.getParameter("mobilePrice");
        
        String lastMinSearchValue = request.getParameter("lastMinSearchValue");
        String lastMaxSearchValue = request.getParameter("lastMaxSearchValue");
        
        String url = "";
        
        try{
            HttpSession session = request.getSession(true);
           
            // Get cart
            Cart cart = (Cart) session.getAttribute("CART");
            if(cart == null){
                cart = new Cart();
            }
            
            // Drop order to cart
            cart.addMobileToCart(mobileId, mobileName, Double.parseDouble(mobilePrice));
            cart.setUserID(userId);
            
            // update cart
            session.setAttribute("CART", cart);
        }
        finally{
            url = "DispatcherServlet?btnAction=Search&"
                    + "txtSearchMinValue=" + lastMinSearchValue
                    + "&txtSearchMaxValue=" + lastMaxSearchValue;
            
            response.sendRedirect(url);
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
