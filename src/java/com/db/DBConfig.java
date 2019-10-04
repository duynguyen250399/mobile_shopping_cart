
package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConfig {
    public static Connection makeConnection()
    throws NamingException, SQLException{
        Connection con = null;     
        
        Context initialContext = new InitialContext();
        Context tomcatContext = (Context) initialContext.lookup("java:comp/env");
        
        DataSource ds = (DataSource) tomcatContext.lookup("MobileDataSource");
        
        con = ds.getConnection();
      
        return con;
    }
   
}
