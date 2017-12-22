package Domain;

import Java.DelManMaintain;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeliveryMan {

    private static int delmenID = 601001;
    private int delmenId;
    private String icNum;
    private String password;
    private String delmenName;
    private String ContactNum;
    private String homeAddress;
    private String joinDate;
    private String status;
    private String acc;
    private double totalDistance;
    
    public DeliveryMan(){
        
    }

    public DeliveryMan(int delmenId, String icNum, String password, String delmenName, String ContactNum, String homeAddress, String jonDate, String status, String acc, double totalDistance) {
        this.delmenId = delmenId;
        this.icNum = icNum;
        this.password = password;
        this.delmenName = delmenName;
        this.ContactNum = ContactNum;
        this.homeAddress = homeAddress;
        this.joinDate = jonDate;
        this.status = status;
        this.acc = acc;
        this.totalDistance = totalDistance;
        delmenID++;
    }
    
    public static void DeliveryMenDetails() {
        DelManMaintain.dList.addData(new DeliveryMan(601001,"930616-03-6131", "ABC123", "Jorn Lim", "011-12345678", "Pertaling Jaya", "13/11/2016", "Not Available", "Active", 10.6));
        DelManMaintain.dList.addData(new DeliveryMan(601002,"961007-03-7163", "Hii123", "Mark    ", "018-1234567", "Wangsa Maju", "10/11/2016", "Available", "Active", 7.5));
        DelManMaintain.dList.addData(new DeliveryMan(601003,"963031-03-7361", "Waa123", "Jolin   ", "017-1234567", "Setapak", "17/11/2016", "Available", "Active", 11.3));
        DelManMaintain.dList.addData(new DeliveryMan(601004,"310317-03-3311", "Qzz123", "Sam     ", "016-1234567", "Seremban", "21/11/2016", "Available", "Active", 10.6));
        DelManMaintain.dList.addData(new DeliveryMan(601005,"980103-03-1378", "Zaa123", "Zack    ", "013-1234567", "Port Dickson", "30/11/2016", "Available", "Active", 3.0));
    }

    public int getDelmenId() {
        return delmenId;
    }

    public void setDelmenId(int delmenId) {
        this.delmenId = delmenId;
    }

    public String getIcNum() {
        return icNum;
    }

    public void setIcNum(String icNum) {
        this.icNum = icNum;
    }

    public static int getDelmenID() {
        return delmenID;
    }

    public static void setDelmenID(int delmenID) {
        DeliveryMan.delmenID = delmenID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDelmenName() {
        return delmenName;
    }

    public void setDelmenName(String delmenName) {
        this.delmenName = delmenName;
    }

    public String getContactNum() {
        return ContactNum;
    }

    public void setContactNum(String ContactNum) {
        this.ContactNum = ContactNum;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getJoinDate() {
        DateFormat joinDate = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return joinDate.format(date);
    }

    public void setJoinDate(String jonDate) {
        this.joinDate = jonDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }
    
}
