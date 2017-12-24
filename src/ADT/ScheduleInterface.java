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
    
    void minimunDistance(ADTTheListInterface<Schedule> Sch) ; 
    void distanceBetweenPlaces();
    int calculateDistance(String restaurant,String deliverAddress);
     //use to sorting the item based on condition such as
     //alphabetical order in descending or ascending order
    
   
}
