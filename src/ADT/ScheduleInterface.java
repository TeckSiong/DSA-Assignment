/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author KD
 */
public interface ScheduleInterface<T> {
    int timeSpentTravel();
    boolean isEmpty();
    T returnItem(int index);
    void addItem (T item);
    void clearAll ();
    int getSize ();
    
}
