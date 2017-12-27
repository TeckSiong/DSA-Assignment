package ADT;

import Client.ScheduleOrder;
import static Client.ScheduleOrder.SC;
import Domain.Distance;
import Domain.Schedule;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KD
 */
public class ScheduleADT<T> implements ScheduleInterface<T>{
    
    
    private Node firstNode, lastNode;
    private int size;


   @Override
    public T getIndexItem(int index) {
        Node tmp = firstNode;
        T indexItem = null;
        for(int i=0;i<=index;i++){
            indexItem= tmp.data;
            tmp = tmp.next;
        }
        return  indexItem;
    }
    
    @Override
    public boolean isEmpty() {
        return firstNode ==null;
    }

    @Override
    public void addItem(T item) {
       Node tmp = new Node(item, null, lastNode);
        if(lastNode != null) {
            lastNode.next = tmp;
        }
        lastNode = tmp;
        if(firstNode == null) {
            firstNode = tmp;
        }
        size++;
        
    }
     @Override
    public int getSize() {
        return size;
    }
     @Override
    public void clearAll() {
       firstNode=null;
       lastNode=null;
       size=0;
    }
    private class Node {

        T data;
        Node next, previous;
        

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
    @Override
    public void distanceBetweenPlaces() {
       ScheduleOrder.distanceList.addItem(new Distance("taman "
               + "melawati","taruc", 4.3f));
       ScheduleOrder.distanceList.addItem(new Distance("taman "
               + "melawati","pv12",  5.6f));
       ScheduleOrder.distanceList.addItem(new Distance("taman "
               + "melawati","pv15",  5.7f));
       ScheduleOrder.distanceList.addItem(new Distance("taman "
               + "melawati","taman sentul utama",  8.3f));
       ScheduleOrder.distanceList.addItem(new Distance("taruc"
               ,"pv12",  2.2f));
       ScheduleOrder.distanceList.addItem(new Distance("taruc"
               ,"pv15", 2.3f));
       ScheduleOrder.distanceList.addItem(new Distance("taruc"
               ,"taman sentul utama",5.0f));
       ScheduleOrder.distanceList.addItem(new Distance("taman "
               + "sentul utama","pv12",  3.4f));
       ScheduleOrder.distanceList.addItem(new Distance("taman "
               + "sentul utama","pv15",  3.7f));
       ScheduleOrder.distanceList.addItem(new Distance("pv12",
               "pv15",1.0f));
    }
    
    @Override
    public void sortByDate(ScheduleInterface<Schedule> schedule){
        int n = schedule.getSize();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
                if (schedule.getIndexItem(i).getTime().compareTo(
                        schedule.getIndexItem(k).getTime())>0) {
                        swap(i, k, (ScheduleADT<Schedule>) schedule);
                }
            }
        }
        int z;
        for (int x = n; x >= 0; x--) {
            for (int y = 0; y < n - 1; y++) {
                z = y + 1;
                if (schedule.getIndexItem(y).getTime().compareTo(
                        schedule.getIndexItem(z).getTime())==0) {
                    if(schedule.getIndexItem(y).getDistance()>
                            schedule.getIndexItem(z).getDistance())
                        swap(y, z, (ScheduleADT<Schedule>) schedule);
                }
            }
        }
    }
    
    private void swap(int i, int j, ScheduleInterface<Schedule> ds) {
  
        Schedule temp;
        temp = ds.getIndexItem(i);
        ds.setItem(i, ds.getIndexItem(j)); 
        ds.setItem(j, temp); 
    }
    
    
    
    @Override
    public boolean setItem(int index, T item) {
        boolean suc = true;

        if ((index >= 0) && (index < size)) {
            Node currentNode = firstNode; 
        // assign the firstNode to currentNode
            for (int i = 0; i < index; ++i) {
                currentNode = currentNode.next;	
        // point currentnode to get nextnode
            }
            currentNode.data = item; 
        // currentNode data is point to the item position
        } else {
            suc = false;
        }
        return suc;
    }
    
    @Override
    public float calculateDistance(String restaurant,
            String deliverAddress) {
        for(int i = 0; i < ScheduleOrder.distanceList.getSize();i++){
            if((restaurant.toLowerCase().compareTo(ScheduleOrder.
                    distanceList.getIndexItem(i).getPlaceA())==0
            &&deliverAddress.toLowerCase().compareTo(ScheduleOrder
                    .distanceList.getIndexItem(i).getPlaceB())==0)||
                    (restaurant.toLowerCase().compareTo(ScheduleOrder
                            .distanceList.getIndexItem(i).getPlaceB())==0
            &&deliverAddress.toLowerCase().compareTo(ScheduleOrder
                    .distanceList.getIndexItem(i).getPlaceA())==0)){
                return ScheduleOrder.distanceList.getIndexItem(i)
                        .getDistance();//travered distance
            }else if(restaurant.toLowerCase().compareTo(deliverAddress.
                    toLowerCase())==0){
                return 0.5f;//same place
            }
        
        }
        return -2;//error code finished loop not found
    }
    
    
}
