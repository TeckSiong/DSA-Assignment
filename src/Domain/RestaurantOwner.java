/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Client.Restaurant;

/**
 *
 * @author Jeffrey
 */
public class RestaurantOwner {
    
    private int id;
    private String RestaurantName;
    private String ContactNo;
    private String address;
    private String style;
    private String AvailableTime;
    private String password;
    private String Status;
    
    public RestaurantOwner()
    {
        
    }
    
    public static void RestList(){
        Restaurant.Ro.addItem(new RestaurantOwner(3001,"Papa","010-91999292","ABC123","adsad","Thai Style","12:00 - 18:00"));
        Restaurant.Ro.addItem(new RestaurantOwner(3002,"Mama","010-91999292","ABC123","adsad","Thai Style","12:00 - 18:00"));
        Restaurant.Ro.addItem(new RestaurantOwner(3003,"Kaka","010-91999292","ABC123","adsad","Thai Style","12:00 - 18:00"));
        Restaurant.Ro.addItem(new RestaurantOwner(3004,"Sasa","010-91999292","ABC123","adsad","Thai Style","12:00 - 18:00"));
        Restaurant.Ro.addItem(new RestaurantOwner(3005,"caca","010-91999292","ABC123","adsad","Thai Style","12:00 - 18:00"));
    }
    
    public RestaurantOwner(int id,String RestaurantName,String ContactNo,String password, String address,String style,String AvailableTime)
    {
        
        this.RestaurantName = RestaurantName;
        this.ContactNo = ContactNo;
        this.address = address;
        this.style = style;
        this.AvailableTime = AvailableTime;
        this.password = password;
        this.Status="Activated";
        this.id=id;
        
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAvailableTime() {
        return AvailableTime;
    }

    public void setAvailableTime(String AvailableTime) {
        this.AvailableTime = AvailableTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}


