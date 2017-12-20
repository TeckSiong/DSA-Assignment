package Domain;

import Java.MainMenu;

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
    
    public static void HRStaffDetails() {
        MainMenu.hList.addData(new HRExecutive(301001, "ABC123", "Mark"));
        MainMenu.hList.addData(new HRExecutive(301002, "AAA123", "Sam"));
        MainMenu.hList.addData(new HRExecutive(301003, "ABB123", "Lily"));
        MainMenu.hList.addData(new HRExecutive(301004, "ACC123", "John"));
        MainMenu.hList.addData(new HRExecutive(301005, "AAB123", "Jerry"));
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
