package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

//    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String START_UP_SERVLET = "StartupServlet";
    private final String LOGOUT_SERVLET = "LogoutServlet";
    private final String SEARCH_SERVLET = "SearchServlet";
    private final String ADD_TO_CART_SERVLET = "AddToCartServlet";
    private final String VIEW_CART_PAGE = "viewcart.jsp";
    private final String REMOVE_CART_ITEM_SERVLET = "RemoveCartItemServlet";
    private final String CHECK_OUT_SERVLET = "CheckoutServlet";
    private final String VIEW_SHOPPING_HISTORY_SERVLET = "ViewShoppingHistoryServlet";

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

        String button = request.getParameter("btnAction");
        String url = "";

        try {
            if (button == null) {
                url = START_UP_SERVLET;
            } else if (button.equals("Login")) {
                url = LOGIN_SERVLET;
            }
            else if(button.equals("Logout")){
                url = LOGOUT_SERVLET;
            }       
            else if(button.equals("Search")){
                url = SEARCH_SERVLET;
            }
            else if(button.equals("Add to Cart")){
                url = ADD_TO_CART_SERVLET;
            }
            else if(button.equals("Cart")){
                url = VIEW_CART_PAGE;
            }
            else if(button.equals("Remove")){
                url = REMOVE_CART_ITEM_SERVLET;
            }
            else if(button.equals("Check Out")){
                url = CHECK_OUT_SERVLET;
            }
            else if(button.equals("ShoppingHistory")){
                url = VIEW_SHOPPING_HISTORY_SERVLET;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
