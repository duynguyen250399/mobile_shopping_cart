<%-- 
    Document   : user
    Created on : Sep 27, 2019, 9:12:13 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="false" %>
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
            if(cookies != null){
                username = cookies[cookies.length - 1].getName();
            }
        %>
        <p style="color: red">Welcome, <%= username %>!</p>       
        <form>
            <h2>Search mobile devices</h2>
            <input type="number" name="txtSearchMinValue" placeholder="Min" /> 
            <input type="number" name="txtSearchMaxValue" placeholder="Max" /> 
            <input type="submit" name="btnAction" value="Search" />
        </form>
    </body>
</html>
