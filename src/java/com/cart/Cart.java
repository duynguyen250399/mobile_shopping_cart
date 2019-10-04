
package com.cart;

import com.dto.mobile.MobileDTO;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private String userID;
    private Map<String, MobileDTO> items;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public Map<String, MobileDTO> getItems(){
        return this.items;
    }
    
//    public void addItemToCart(String itemName, ){
//        if(this.items == null){
//            this.items = new HashMap<>();
//        }
//        
//        int quantity = 1;
//        
//        if(this.items.containsKey(itemId)){
//            quantity += 1;
//        }
//        
//        this.items.put(itemId, quantity)
//    }
}
