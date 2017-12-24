/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Client.ScheduleOrder;

/**
 *
 * @author KD
 */
public class Distance {
    String placeA;
    String placeB;
    int distance;

    public void distanceBetweenPlace(){
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","taruc",6));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","pv12",2));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","pv15",3));
       ScheduleOrder.distanceList.addItem(new Distance("taman sentul utama","taruc",4));
       ScheduleOrder.distanceList.addItem(new Distance("taman ayer panas","taman sentul utama",3));
    }
    
    public String getPlaceA() {
        return placeA;
    }

    public void setPlaceA(String placeA) {
        this.placeA = placeA;
    }

    public String getPlaceB() {
        return placeB;
    }

    public void setPlaceB(String placeB) {
        this.placeB = placeB;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Distance() {
    }

    public Distance(String placeA, String placeB, int distance) {
        this.placeA = placeA;
        this.placeB = placeB;
        this.distance = distance;
    }
    
}
