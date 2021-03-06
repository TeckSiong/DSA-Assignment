package Domain;

import Client.DelManMaintain;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductStatus {

    private int delManId;
    private int orderID;
    private String status;
    private int trip;
    private int hour;
    private int minute;
    private String date;
    private String add;
    private int custID;

    public ProductStatus() {
    }

    public ProductStatus(int delManId, int id, String status, int trip, int hour, int minute, String date,String add,int id2) {
        this.delManId = delManId;
        this.orderID = id;
        this.status = status;
        this.trip = trip;
        this.hour = hour;
        this.minute = minute;
        this.date = date;
        this.add = add;
        this.custID = id2;
    }

    public static void Status() {
        DelManMaintain.sList.addData(new ProductStatus(601001, 1001, "Delivered",5, 0, 0, "21/12/2017","Wangsa Maju",101001));
        DelManMaintain.sList.addData(new ProductStatus(601002, 1002, "Delivering",3, 1, 0, "21/12/2017","Wangsa Maju",101002));
        DelManMaintain.sList.addData(new ProductStatus(601003, 1003, "Delivered",6, 1, 0, "21/12/2017","Wangsa Maju",101003));
        DelManMaintain.sList.addData(new ProductStatus(601004, 1004, "Pending",7, 0, 0, "21/12/2017","Wangsa Maju",101001));
        DelManMaintain.sList.addData(new ProductStatus(601005, 1005, "Delivered",1, 1, 0, "21/12/2017","Wangsa Maju",101005));
    }

    public int getDelManId() {
        return delManId;
    }

    public void setDelManId(int delManId) {
        this.delManId = delManId;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int id) {
        this.orderID = id;
    }

    public String getStatus() {
        return status;
    }

    public int getTrip() {
        return trip;
    }

    public void setTrip(int trip) {
        this.trip = trip;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
    
    public String getDate1(){
        return date;
    }

    public String getDate() {
        DateFormat joinDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return joinDate.format(date);
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getAddress() {
        return add;
    }

    public void setAddress(String add) {
        this.add = add;
    }
    
    public int getCustID() {
        return custID;
    }

    public void setCustID(int id) {
        this.custID = id;
    }

}
