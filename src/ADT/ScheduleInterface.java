package ADT;

import Domain.Schedule;

/**
 *
 * @author KD
 */
public interface ScheduleInterface<T> {
    boolean isEmpty();
    T getIndexItem(int index);
    void addItem (T item);
    void clearAll ();
    int getSize ();
    
    
    void distanceBetweenPlaces();
    float calculateDistance(String restaurant,String deliverAddress);
    void sortByDate(ScheduleInterface<Schedule> schedule);
     //use to sorting the item based on condition such as
     //alphabetical order in descending or ascending order
    boolean setItem(int index, T item);
    
   
}
