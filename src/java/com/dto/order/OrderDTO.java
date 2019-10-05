
package com.dto.order;

import java.io.Serializable;
import java.sql.Date;

public class OrderDTO implements Serializable{
    private String userId;
    private String mobileName;
    private int quantity;
    private double price;
    private Date buyDate;
    
    public OrderDTO(){
        
    }

    public OrderDTO(String userId, String mobileName, int quantity, double price, Date buyDate) {
        this.userId = userId;
        this.mobileName = mobileName;
        this.quantity = quantity;
        this.price = price;
        this.buyDate = buyDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

}
