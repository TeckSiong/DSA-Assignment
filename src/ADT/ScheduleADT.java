/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Client.ScheduleOrder;
import static Client.ScheduleOrder.SC;
import Domain.Distance;
import Domain.Schedule;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        T tmp1 = null;
        for(int i=0;i<=index;i++){
               tmp1=tmp.data;
            tmp = tmp.next;
        }
        return  tmp1;
    }

    @Override
    public int timeSpentTravel() {
        
        
        return 0; }

    @Override
    public boolean isEmpty() {
        return firstNode ==null;
    }

    @Override
    public void addItem(T item) {
       
       Node tmp = new Node(item, null, lastNode);
       
        if(lastNode != null) {lastNode.next = tmp;}
        lastNode = tmp;
        if(firstNode == null) { firstNode = tmp;}
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
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","taruc", 4.3f));
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","pv12",  5.6f));
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","pv15",  5.7f));
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","taman sentul utama",  8.3f));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","pv12",  2.2f));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","pv15", 2.3f));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","taman sentul utama",5.0f));
       ScheduleOrder.distanceList.addItem(new Distance("taman sentul utama","pv12",  3.4f));
       ScheduleOrder.distanceList.addItem(new Distance("taman sentul utama","pv15",  3.7f));
       ScheduleOrder.distanceList.addItem(new Distance("pv12","pv15",1.0f));
    }
    
    
     

    
    
    @Override
    public void sortByDate(ScheduleInterface<Schedule> schedule){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(); 
        String currentDateFormat = dateFormat.format(currentDate);//stuck
         int n = schedule.getSize();
        int k;
        
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
                if (schedule.getIndexItem(i).getTime()schedule.getIndexItem(i).getTime()) {
                    swap(i, k, (ScheduleADT<Schedule>) schedule);
                }
            }
            
        }
    }
    public void viewTodayScheduleOrder(){
       
       
           
        if(!SC.isEmpty()){
        for (int i = 0; i < SC.getSize(); i++) {
        try {
            Date comp1 = dateFormat.parse(SC.getIndexItem(i).getDate());
            Date comp2 = dateFormat.parse(currentDateFormat);
            if (comp1.compareTo(comp2) == 0)
            {
                System.out.printf("%15s %15s %15s %15s\n","Receiver Name","Receiver Address","Date","Time");
                System.out.printf("================================================================\n");
                System.out.printf("%15s %15s %15s %15s\n",SC.getIndexItem(i).getReceiverName(),SC.getIndexItem(i).getReceiverAddress(),SC.getIndexItem(i).getDate(),SC.getIndexItem(i).getTime());
            }
                
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       
                    }
        }else
                System.out.println("Nothing to be deliver today");
       
       
   }
    
  
    private void swap(int i, int j, ScheduleInterface<Schedule> ds) {
  
        Schedule temp;
        temp = ds.getIndexItem(i);
        ds.addItem(i, ds.getIndexItem(j)); 
        ds.addItem(j, temp); 
    }
    
     @Override
    public float minimunDistance(ADTTheListInterface<Schedule> Sch,String A, String B) {
        
        
        return 3.2f;
    }

    

    @Override
    public float calculateDistance(String restaurant, String deliverAddress) {
        for(int i = 0; i < ScheduleOrder.distanceList.getSize();i++){
            if((restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceA())==0
            &&deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceB())==0)||
                    (restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceB())==0
            &&deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceA())==0)){
                return ScheduleOrder.distanceList.getIndexItem(i).getDistance();//travered distance
            }else if(restaurant.toLowerCase().compareTo(deliverAddress.toLowerCase())==0){
                return 0;//same place
            }else if((restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceA())==0&&
                deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceB())!=0)//first match condition
                    ||(restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceB())==0
            &&deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceA())!=0)//second match condition,either one correct
                    ){//start if else comment
                for(int m = 0 ; m< ScheduleOrder.distanceList.getSize();m++){//return whatever found
                    if(restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceA())==0&&
                deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceB())!=0){
                        
                    }
                    
                    /*if((restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(m).getPlaceA())==0
            &&deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(m).getPlaceB())==0)||
                    (restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(m).getPlaceB())==0
            &&deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(m).getPlaceA())==0)){
                        
                        return ScheduleOrder.distanceList.getIndexItem(m).getDistance()+ScheduleOrder.distanceList.getIndexItem(i).getDistance();//travered distance
                        }*/
                    /*if(restaurant.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceA())==0&&
                deliverAddress.toLowerCase().compareTo(ScheduleOrder.distanceList.getIndexItem(i).getPlaceB())!=0)//firstcorrect second wrong
                    {
                        
                    }*/
                
                    }//inner forloop-close
                }//else-if close
        
        }
        return -2;//error code finished loop
            }
    
    
}
