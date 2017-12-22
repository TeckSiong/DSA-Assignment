/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Java.foodOrder;

/**
 *
 * @author User
 */
public class orders {
    
    private int classify;
    private int restaurantName;
    private String name;
    private int quantity;
    private double price;
    private String Status;
    private int custID;
    
    public orders(){}
    
    public static void OrderList(){
        foodOrder.orders1.add(new orders(1001,3001,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1001,3002,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1002,3001,"KK",1,12.0,"Pending",101002));
        foodOrder.orders1.add(new orders(1003,3003,"KK",1,12.0,"Pending",101003));
        foodOrder.orders1.add(new orders(1003,3004,"KK",1,12.0,"Pending",101003));
        foodOrder.orders1.add(new orders(1004,3005,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1004,3001,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1004,3002,"KK",1,12.0,"Pending",101001));
        foodOrder.orders1.add(new orders(1005,3004,"KK",1,12.0,"Pending",101005));
        
    } 
    
    public orders(int clas, int res, String name, int quant, double price, String sta,int c){
        this.classify = clas;
        this.restaurantName = res;
        this.name = name;
        this.quantity = quant;
        this.price = price;
        this.Status = sta;
        this.custID = c;
    
    }
    
    public int getclassify() {
        return classify;
    }

    public void setclassify(int classify) {
        this.classify = classify;
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
