/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Client.DelManMaintain;
import Client.foodOrder;

/**
 *
 * @author User
 */
public class orders {
    
    private int orderID;
    private int foodId;
    private int restaurantName;
    private String name;
    private int quantity;
    private double price;
    private String Status;
    private int custID;
    
    public orders(){}
    
    public static void OrderList(){
        foodOrder.orders1.add(new orders(1001,11,3001,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1001,22,3002,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1002,33,3001,"KK",1,12.0,"Pending",101002));
        foodOrder.orders1.add(new orders(1003,33,3003,"KK",1,12.0,"Pending",101003));
        foodOrder.orders1.add(new orders(1003,55,3004,"KK",1,12.0,"Pending",101003));
        foodOrder.orders1.add(new orders(1004,6,3005,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1004,77,3001,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1004,88,3002,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1005,99,3004,"KK",1,12.0,"Pending",101005));
        
    } 
    
    public static void OrderList1(){
        DelManMaintain.oList.addData(new orders(1001,11,3001,"Burger",1,12.0,"Pending",101001));
        DelManMaintain.oList.addData(new orders(1001,22,3002,"Ice Cream",1,12.0,"Pending",101001));
        DelManMaintain.oList.addData(new orders(1002,33,3001,"Nasi Lemak",1,12.0,"Pending",101002));
        DelManMaintain.oList.addData(new orders(1003,33,3003,"Orange Juice",1,12.0,"Pending",101003));
        DelManMaintain.oList.addData(new orders(1003,55,3004,"Apple Pie",1,12.0,"Pending",101003));
        DelManMaintain.oList.addData(new orders(1004,6,3005,"Papaya Milk",1,12.0,"Pending",101001));
        DelManMaintain.oList.addData(new orders(1004,77,3001,"Pizza",1,12.0,"Pending",101001));
        DelManMaintain.oList.addData(new orders(1004,88,3002,"Plasta",1,12.0,"Pending",101001));
        DelManMaintain.oList.addData(new orders(1005,99,3004,"Mee Goreng",1,12.0,"Pending",101005));
        
    } 
    
    public orders(int clas,int fi, int res, String name, int quant, double price, String sta,int c){
        this.orderID = clas;
        this.foodId = fi;
        this.restaurantName = res;
        this.name = name;
        this.quantity = quant;
        this.price = price;
        this.Status = sta;
        this.custID = c;
    
    }
    
    public int getorderID() {
        return orderID;
    }

    public void setorderID(int orderID) {
        this.orderID = orderID;
    }
    public int getfoodId() {
        return foodId;
    }

    public void setfoodId(int orderID) {
        this.foodId = orderID;
    }
    
    
    public int getrestaurantName() {
        return restaurantName;
    }

    public void setrestaurantName(int restaurantName) {
        this.restaurantName = restaurantName;
    }
    
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    
    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }
    
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    
    public int getcustID() {
        return custID;
    }

    public void setCustID(int quantity) {
        this.custID = quantity;
    }
    
    
    
}
