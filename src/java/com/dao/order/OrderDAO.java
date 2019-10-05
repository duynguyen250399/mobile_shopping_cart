
package com.dao.order;

import com.db.DBConfig;
import com.dto.order.OrderDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class OrderDAO implements Serializable{
    
    public void insertOrder(String userId, String mobileName, int quantity, double price, Date buyDate) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        
        try{
            con = DBConfig.makeConnection();
            if(con != null){
                String sql = "insert into tblOrder values(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, userId);
                stm.setString(2, mobileName);
                stm.setInt(3, quantity);
                stm.setDouble(4, price);                            
                stm.setDate(5, buyDate);
                
                int result = stm.executeUpdate();
               
            }
        }
        finally{
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
     
    }
    
    private List<OrderDTO> orders;
    
    public List<OrderDTO> getOrders(){
        return this.orders;
    }
    
    public void createOrders(String userId) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try{
            con = DBConfig.makeConnection();
            if(con != null){
                String sql = "select mobileName, quantity, price, buy_date from "
                        + "tblOrder where userId = ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, userId);
                
                rs = stm.executeQuery();
                
                while(rs.next()){
                    String mobileName = rs.getString("mobileName");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    Date buyDate = rs.getDate("buy_date");
                    
                    OrderDTO dto = new OrderDTO(userId, mobileName, quantity, price, buyDate);
                    
                    if(this.orders == null){
                        this.orders = new ArrayList<>();
                    }
                    
                    this.orders.add(dto);
                }
            }
        }
        finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        
        
    }
    
}
