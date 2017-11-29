
package Domain;

public class ProductStatus {
   
    private int orderID;
    private String status; 
    private int hour;
    private int minute;
    
    public ProductStatus(){}
    
    public ProductStatus(int id, String status,int hour,int minute){
        this.orderID = id;
        this.status = status;
        this.hour = hour;
        this.minute = minute;
    }
    
    public int getOrderID(){
        return orderID;
    }
    
    public void setOrderID(int id){
        this.orderID = id;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    public int getHour(){
        return hour;
    }
    
    public void setTime(int hour){
        this.hour = hour;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public void setMinute(int minute){
        this.minute = minute;
    }
}


