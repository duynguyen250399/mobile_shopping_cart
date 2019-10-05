
package com.cart;

import com.dto.mobile.MobileDTO;
import com.order.Order;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String userID;
    private Map<String, Order> items;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public Map<String, Order> getItems(){
        return this.items;
    }
    
    public void addMobileToCart(String mobileId, String mobileName, double price){
        if(this.items == null){
            this.items = new HashMap<>();
        }
              
        int quantity = 1;    
       
        if(this.items.containsKey(mobileId)){
            Order prevOrder = this.items.get(mobileId);
            quantity = prevOrder.getQuantity() + 1;         
        }
        
        Order order = new Order(mobileName, quantity, price * quantity);
        
        this.items.put(mobileId, order);            
    }
    
    public void removeMobileFromCart(String mobileId){
        if(this.items.isEmpty()){           
            return;
        }
        
        this.items.remove(mobileId);
    }
}
