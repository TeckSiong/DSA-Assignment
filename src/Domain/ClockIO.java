package Domain;

import Java.ClockInClockOut;

public class ClockIO {

    
    private int delmenId;
    
    private int chour;
    private int cmin;
    
    public ClockIO(){
        
    }

    public ClockIO(int delmenId,int hour, int min) {
        this.delmenId = delmenId;
        
        this.chour = hour;
        this.cmin = min;
        
    }
    
    public static void WorkingDuration() {
        ClockInClockOut.cio.addData(new ClockIO(601001,1,0));
        ClockInClockOut.cio.addData(new ClockIO(601002,5,0));
        ClockInClockOut.cio.addData(new ClockIO(601003,6,0));
        ClockInClockOut.cio.addData(new ClockIO(601004,7,0));
        ClockInClockOut.cio.addData(new ClockIO(601005,2,0));
        
    }

    public int getDelmenId() {
        return delmenId;
    }

    public void setDelmenId(int delmenId) {
        this.delmenId = delmenId;
    }


    
    public int getHour(){
        return chour;
    }
    
    public void setHour(int h){
        this.chour = h;
        
    }
    
    public int getMin(){
        return chour;
    }
    
    public void setMin(int m){
        this.cmin = m;
        
    }
    
}
