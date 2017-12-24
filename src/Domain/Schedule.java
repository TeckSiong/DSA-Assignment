/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author KD
 */
public class Schedule {
    private int schduleID;
    private String receiverName;
    private String receiverAddress;
    private String Date;
    private String Time;
    private int orderID;
    

    public Schedule() {
    }

    public Schedule(int schduleID, String receiverName, String receiverAddress, String Date, String Time, int orderID) {
        this.schduleID = schduleID;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.Date = Date;
        this.Time = Time;
        this.orderID = orderID;
    }

    public int getSchduleID() {
        return schduleID;
    }

    public void setSchduleID(int schduleID) {
        this.schduleID = schduleID;
    }
    
    


   

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

  
    
    
}
