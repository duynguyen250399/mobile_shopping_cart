<%-- 
    Document   : cart_history
    Created on : Oct 5, 2019, 4:22:36 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="com.dto.order.OrderDTO"%>
<%@page import="com.dao.order.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping History</title>
    </head>
    <body>
        <h2>Your shopping history:</h2>
        <ul>
            <%              
                List<OrderDTO> orders = (List<OrderDTO>) request.getAttribute("Orders");

                if (orders != null) {
                    for (OrderDTO dto : orders) {
            %>
            <li>You bought <%= dto.getQuantity()%> <%= dto.getMobileName()%>, total: <%= dto.getPrice()%> at <b><%= dto.getBuyDate() %></b></li>
                <%
                        }
                    }
                %>
        </ul>
    </body>
</html>
