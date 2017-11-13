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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
/**
 *
 * @author KD
 */
public class Schedule {
    Calendar cal = Calendar.getInstance();
    private String orderID;
    private String custName;
    private String custAddress;
    private String scheduleOrderDate;
    private String scheduleOrderTime;

    public String getScheduleOrderTime() {
        return scheduleOrderTime;
    }

    public void setScheduleOrderTime(String scheduleOrderTime) {
        this.scheduleOrderTime = scheduleOrderTime;
    }

    public Schedule(String orderID, String custName, String custAddress, String scheduleOrderDate, String scheduleOrderTime) {
        this.orderID = orderID;
        this.custName = custName;
        this.custAddress = custAddress;
        this.scheduleOrderDate = scheduleOrderDate;
        this.scheduleOrderTime = scheduleOrderTime;
    }

    
    

    public Calendar getCal() {
        return cal;
    }

    public void setCal(Calendar cal) {
        this.cal = cal;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public String getScheduleOrderDate() {
        return scheduleOrderDate;
    }

    public void setScheduleOrderDate(String scheduleOrderDate) {
        this.scheduleOrderDate = scheduleOrderDate;
    }

  

   

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

   

    
    
    
}

