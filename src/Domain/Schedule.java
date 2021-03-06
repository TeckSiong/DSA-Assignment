
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
    private float distance;
    private int orderID;

    public Schedule() {
    }

    public Schedule(int schduleID, String receiverName,
            String receiverAddress, String Date, String Time,
            float distance, int orderID) {
        this.schduleID = schduleID;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.Date = Date;
        this.Time = Time;
        this.distance = distance;
        this.orderID = orderID;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
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
