
package com.dao.mobile;

import com.db.DBConfig;
import com.dto.mobile.MobileDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

public class MobileDAO implements Serializable{
    private List<MobileDTO> mobileItems;

    public List<MobileDTO> getMobileItems() {
        return mobileItems;
    }
    
    public void searchMobileDevicesInRange(int minPrice, int maxPrice)
                throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;
        
        try {
            con = DBConfig.makeConnection();
            if(con != null){
                //String sql = "select "
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
    }
    
}
