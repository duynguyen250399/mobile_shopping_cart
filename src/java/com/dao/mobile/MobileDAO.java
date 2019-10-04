package com.dao.mobile;

import com.db.DBConfig;
import com.dto.mobile.MobileDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class MobileDAO implements Serializable {

    private List<MobileDTO> mobileItems;

    public List<MobileDTO> getMobileItems() {
        return mobileItems;
    }

    public void searchMobileDevicesInRange(double minPrice, double maxPrice)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;

        try {
            con = DBConfig.makeConnection();
            if (con != null) {
                String sql = "select mobileName, yearOfProduction, price, quantity, notSale "
                        + "from tblMobile "
                        + "where price > ? and price < ?";
                
                preStm = con.prepareStatement(sql);
                
                preStm.setDouble(1, minPrice);
                preStm.setDouble(2, maxPrice);
                
                rs = preStm.executeQuery();
                
                while(rs.next()){
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    
                    MobileDTO dto = new MobileDTO();
                    dto.setMobileName(mobileName);
                    dto.setYearOfProduction(yearOfProduction);
                    dto.setPrice(price);
                    dto.setQuantity(quantity);
                    dto.setNotSale(notSale);
                    
                    if(this.mobileItems == null){
                        this.mobileItems = new ArrayList<>();
                    }
                    
                    this.mobileItems.add(dto);                   
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

}
