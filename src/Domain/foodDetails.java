/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Client.DelManMaintain;

/**
 *
 * @author Teck Siong
 */
public class foodDetails {
    int orderId;
    int foodId;
    String foodName;
    int quantity;
    String ci;


    public foodDetails(int orderId, int foodId, String foodName, int quantity, String custID) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.ci = custID;

    }
    
    public foodDetails() {
        
    }
    
    public static void fDetail() {
        DelManMaintain.fList.addData(new foodDetails(1001, 3001, "Burger", 3,"101001"));
        DelManMaintain.fList.addData(new foodDetails(1001, 3002, "Ice Cream", 1,"101001"));
        DelManMaintain.fList.addData(new foodDetails(1002, 3003, "Cake", 3,"101001"));
        DelManMaintain.fList.addData(new foodDetails(1002, 3004, "Apple", 1,"101002"));
        DelManMaintain.fList.addData(new foodDetails(1002, 3005, "Meat", 3,"101002"));
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getCustID() {
        return ci;
    }

    public void setCustID(String ci) {
        this.ci =ci;
    }
    
    
}
