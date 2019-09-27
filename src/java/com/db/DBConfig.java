
package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    public static Connection getSQLServerConnection(String username, String password, int port, String db)
    throws ClassNotFoundException, SQLException{
        Connection con = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String connectionString = "jdbc:sqlserver://localhost:" + port + ";databaseName=" + db;
        
        Class.forName(driver);
        
        con = DriverManager.getConnection(connectionString, username, password);
      
        return con;
    }
   
}
