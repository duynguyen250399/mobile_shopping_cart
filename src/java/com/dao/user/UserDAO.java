package com.dao.user;

import com.db.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public int authenticate(String username, int password) 
        throws SQLException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        
        int role = -1;

        try {
            con = DBConfig.getSQLServerConnection("sa", "123", 1433, "MobileDB");

            if (con != null) {
                String sql = "select userId, password, fullName, role "
                    + "from tblUser where userId = ? and password = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setInt(2, password);
                
                rs = preStm.executeQuery();
                
                if(rs.next()){
                    role = rs.getInt("role");                   
                }
            }            
            
        } 
        finally{
            if(rs != null){
                rs.close();
            }
            if(preStm != null){
                preStm.close();
            }
            if(con != null){
                con.close();
            }
        }

        return role;
    }
}
