
package Domain;

import Java.DelManMaintain;

public class ProductStatus {
   
    private int delManId;
    private int orderID;
    private String status; 
    private int hour;
    private int minute;
    
    public ProductStatus(){}
    
    public ProductStatus(int delManId, int id, String status,int hour,int minute){
        this.delManId = delManId;
        this.orderID = id;
        this.status = status;
        this.hour = hour;
        this.minute = minute;
    }
    
    public static void Status() {
        DelManMaintain.sList.addData(new ProductStatus(601001, 1001,"Pending", 1, 0));
        DelManMaintain.sList.addData(new ProductStatus(601002, 1002,"Pending", 1, 0));
        DelManMaintain.sList.addData(new ProductStatus(601003, 1003,"Pending", 1, 0));
        DelManMaintain.sList.addData(new ProductStatus(601004, 1004,"Pending", 1, 0));
        DelManMaintain.sList.addData(new ProductStatus(601005, 1005,"Pending", 1, 0));
    }

    public int getDelManId() {
        return delManId;
    }

    public void setDelManId(int delManId) {
        this.delManId = delManId;
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


