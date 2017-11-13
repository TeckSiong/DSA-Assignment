package Domain;

public class DeliveryMen {

    private static int delmenID = 601001;
    private int delmenId;
    private String password;
    private String delmenName;
    private String ContactNum;
    private String homeAddress;
    private String joinDate;
    private String status;

    public DeliveryMen() {

    }

    public DeliveryMen(int delmenId, String password, String delmenName, String ContactNum, String homeAddress, String jonDate, String status) {
        this.delmenId = delmenId;
        this.password = password;
        this.delmenName = delmenName;
        this.ContactNum = ContactNum;
        this.homeAddress = homeAddress;
        this.joinDate = jonDate;
        this.status = status;
        delmenID++;
    }

    public int getDelmenId() {
        return delmenId;
    }

    public void setDelmenId(int delmenId) {
        this.delmenId = delmenId;
    }

    public static int getDelmenID() {
        return delmenID;
    }

    public static void setDelmenID(int delmenID) {
        DeliveryMen.delmenID = delmenID;
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
        return joinDate;
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
}
