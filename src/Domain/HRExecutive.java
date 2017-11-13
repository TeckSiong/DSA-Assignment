package Domain;

public class HRExecutive {
    private int hrID;
    private String hrPassword;
    private String hrName;
    
    public HRExecutive(){
        
    }

    public HRExecutive(int hrID, String hrPassword, String hrName) {
        this.hrID = hrID;
        this.hrPassword = hrPassword;
        this.hrName = hrName;
    }

    public int getHrID() {
        return hrID;
    }

    public void setHrID(int hrID) {
        this.hrID = hrID;
    }

    public String getHrPassword() {
        return hrPassword;
    }

    public void setHrPassword(String hrPassword) {
        this.hrPassword = hrPassword;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }
    
}
