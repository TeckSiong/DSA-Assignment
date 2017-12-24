/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Domain.Schedule;

/**
 *
 * @author KD
 */
public interface ScheduleInterface<T> {
    int timeSpentTravel();
    boolean isEmpty();
    T getIndexItem(int index);
    void addItem (T item);
    void clearAll ();
    int getSize ();
    
    float minimunDistance(ScheduleInterface<Schedule> Sch,String restaurant,String deliverAddress) ; 
    void distanceBetweenPlaces();
    float calculateDistance(String restaurant,String deliverAddress);
    void sortByDate(ScheduleInterface<Schedule> schedule);
     //use to sorting the item based on condition such as
     //alphabetical order in descending or ascending order

    public void addItem(int i, Schedule indexItem);
    
   
}
