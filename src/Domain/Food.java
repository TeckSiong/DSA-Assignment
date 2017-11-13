/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Jeffrey
 */
public class Food {
    
    private static int FoodID = 3000;
    private String FoodName;
    private double Price;
    private int Quantity;
    private String Category;
    private String DayAvailable;
    private int CompanyID;
    
    
    public Food()
    {
        
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(int CompanyName) {
        this.CompanyID = CompanyName;
    }

    public Food(String FoodName, double Price, int Quantity, String Category, String DayAvailable) {
        this.FoodName = FoodName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Category = Category;
        this.DayAvailable = DayAvailable;
        
        FoodID++;
    }
    
    

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getDayAvailable() {
        return DayAvailable;
    }

    public void setDayAvailable(String DayAvailable) {
        this.DayAvailable = DayAvailable;
    }
    
    

    public int getFoodID() {
        return FoodID;
    }

    
    public void setFoodID(int FoodID) {
        Food.FoodID = FoodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

   
    public int  getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    
    
    
    
}
