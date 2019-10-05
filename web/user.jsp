<%-- 
    Document   : user
    Created on : Sep 27, 2019, 9:12:13 AM
    Author     : Admin
--%>

<%@page import="com.dao.mobile.MobileDAO"%>
<%@page import="com.dto.mobile.MobileDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mobile Shopping Cart</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            String username = "";
            if (cookies != null) {
                username = cookies[0].getName();             
            }
        %>
        <%
            String logoutURL = "DispatcherServlet?btnAction=Logout";
            String viewCartURL = "DispatcherServlet?btnAction=Cart";
            String shoppingHistoryURL = "DispatcherServlet?btnAction=ShoppingHistory"
                    + "&userId=" + username;
        %>
        <p style="color: red;display: inline">Welcome, <%= username%>!</p>
        <a href="<%= logoutURL %>" style="margin-left: 5px">Sign Out</a>
        <a href="<%= shoppingHistoryURL %>" style="margin-left:10px">Shopping History</a>
        <a href="<%= viewCartURL %>" style="display: block;margin-top:10px">View Cart</a>
        
        <form action="DispatcherServlet">
            <h2>Search mobile devices</h2>
            <input type="number" name="txtSearchMinValue" placeholder="Min Price" /> 
            <input type="number" name="txtSearchMaxValue" placeholder="Max Price" /> 
            <input type="submit" name="btnAction" value="Search" />
        </form>

        <%
            String minSearchValue = request.getParameter("txtSearchMinValue");
            String maxSearchValue = request.getParameter("txtSearchMaxValue");
            if (minSearchValue != null && maxSearchValue != null) {
                List<MobileDTO> searchResult = (List<MobileDTO>) request.getAttribute("searchResult");
                if (searchResult != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Mobile Name</th>
                    <th>Year of Production</th>
                    <th>Price($)</th>
                    <th>Quantity</th>
                    <th>Not Sale</th>     
                    <th>Add to Cart</th>                       
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (MobileDTO dto : searchResult) {
                %>
            <form action="DispatcherServlet">
                <tr>
                    <td><%= (++count)%></td>
                    <td>
                        <%= dto.getMobileName()%>                    
                    </td>
                    <td>
                        <%= dto.getYearOfProduction()%>
                    </td>
                    <td>
                        <%= dto.getPrice()%>
                    </td>
                    <td><%= dto.getQuantity()%></td>
                    <td>
                        <input type="checkbox" <%
                            if (dto.isNotSale()) {
                               %>
                               checked
                               <%
                                   }
                               %>
                    </td>    
                    <td>
                        <%
                            if (!dto.isNotSale()) {
                        %>                   
                        <form action="DispatcherServlet" method="POST">                          
                            <input type="hidden" name="userId" value="<%= username %>" />
                            <input type="hidden" name="lastMinSearchValue" value="<%= minSearchValue%>" />
                            <input type="hidden" name="lastMaxSearchValue" value="<%= maxSearchValue%>" />
                            <input type="hidden" name="mobileId" value="<%= dto.getMobileId()%>" />
                            <input type="hidden" name="mobileName" value="<%= dto.getMobileName()%>" />
                            <input type="hidden" name="mobilePrice" value="<%= dto.getPrice()%>" />                            
                            <input type="submit" value="Add to Cart" name="btnAction" />
                        </form>
                        <%
                            }
                        %>
                    </td>
                </tr>
            </form>
            <%                    }
            %>

        </tbody>
    </table>
    <%                } else {
    %>
    <h2>Mobiles not found!</h2>
    <%
            }
        }
    %>



</body>
</html>
