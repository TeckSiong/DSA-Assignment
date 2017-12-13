/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

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
    
    public orders(){}
    
    public orders(int clas, int res, String name, int quant, double price){
        this.classify = clas;
        this.restaurantName = res;
        this.name = name;
        this.quantity = quant;
        this.price = price;
    
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

    
    
    
    
    
}
