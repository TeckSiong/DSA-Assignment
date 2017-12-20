/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Java.DelManMaintain;

/**
 *
 * @author Teck Siong
 */
public class foodDetails {
    int orderId;
    int foodId;
    String foodName;
    int quantity;

    public foodDetails(int orderId, int foodId, String foodName, int quantity) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.foodName = foodName;
        this.quantity = quantity;
    }
    
    public foodDetails() {
        
    }
    
    public static void fDetail() {
        DelManMaintain.fList.addData(new foodDetails(1001, 3001, "Burger", 3));
        DelManMaintain.fList.addData(new foodDetails(1001, 3002, "Ice Cream", 1));
        DelManMaintain.fList.addData(new foodDetails(1002, 3003, "Cake", 3));
        DelManMaintain.fList.addData(new foodDetails(1002, 3004, "Apple", 1));
        DelManMaintain.fList.addData(new foodDetails(1002, 3005, "Meat", 3));
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
}
