
package com.order;

public class Order {
    private String mobileName;
    private int quantity;
    private double price;
    
    public Order(){
        
    }

    public Order(String mobileName, int quantity, double price) {
        this.mobileName = mobileName;
        this.quantity = quantity;
        this.price = price;
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
    
    
}
