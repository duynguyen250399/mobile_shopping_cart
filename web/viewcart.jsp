<%-- 
    Document   : viewcart
    Created on : Oct 5, 2019, 9:32:27 AM
    Author     : Admin
--%>

<%@page import="java.util.Map"%>
<%@page import="com.order.Order"%>
<%@page import="com.cart.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
    </head>
    <body>

        <%
            if (session != null) {
                // Get cart
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart != null) {
                    Map<String, Order> items = cart.getItems();
                    if (items != null) {
        %>
        <h1>Your cart</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price($)</th>
                    <th></th>

                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    int totalPrice = 0;
                    for (String itemId : items.keySet()) {
                        Order order = items.get(itemId);
                        totalPrice += order.getPrice();
                %>
                <tr>
                    <td><%= (++count)%></td>
                    <td><%= order.getMobileName()%></td>
                    <td><%= order.getQuantity()%></td>
                    <td><%= order.getPrice()%></td>
                    <td>
                        <form action="DispatcherServlet">
                            <input type="hidden" name="mobileId" value="<%= itemId%>" />
                            <input type="submit" name="btnAction" value="Remove" />
                        </form>
                    </td>
                    <td>             
                </tr>
                <%
                    }
                %>

                <tr>
                    <td colspan="5"><b>Total: </b><%= totalPrice%>$</td>                   
                </tr>

                <tr>
                    <td colspan="5">
                        <form action="DispatcherServlet">
                            <input style="width: 100%" type="submit" name="btnAction" value="Check Out" />
                        </form>
                    </td>                   
                </tr>
            </tbody>
        </table>
        <%
                        return;
                    }
                }
            }
        %>

        <h2 style="color: red">Cart is empty!</h2>
    </body>
</html>
