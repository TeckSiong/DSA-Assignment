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
    boolean setItem(int index, T item);
    int getSize ();
    
    void distanceBetweenPlaces();
    float calculateDistance(String restaurant,String deliverAddress);
    void sortByDate(ScheduleInterface<Schedule> schedule);
    
}
