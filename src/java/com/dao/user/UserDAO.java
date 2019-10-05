package com.dao.user;

import com.db.DBConfig;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

public class UserDAO implements Serializable{

    public int authenticate(String username, String password) 
        throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        
        int role = -1;
        
        int passwordToInt;
        
        try {
            passwordToInt = Integer.parseInt(password);
        } catch (NumberFormatException e) {
            return role;
        }

        try {
            con = DBConfig.makeConnection();

            if (con != null) {
                String sql = "select userId, password, fullName, role "
                    + "from tblUser where userId = ? and password = ?";
                preStm = con.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setInt(2, passwordToInt);
                
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
