/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Client.ScheduleOrder;
import Domain.Distance;
import Domain.Schedule;

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
    public void minimunDistance(ADTTheListInterface<Schedule> Sch) {
        
        
        
    }

    @Override
    public void distanceBetweenPlaces() {
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","taruc",6));
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","pv12",4));
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","pv15",5));
       ScheduleOrder.distanceList.addItem(new Distance("taman melawati","taman sentul utama",5));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","pv12",2));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","pv15",3));
       ScheduleOrder.distanceList.addItem(new Distance("taruc","taman sentul utama",3));
       ScheduleOrder.distanceList.addItem(new Distance("taman sentul utama","taruc",4));
       ScheduleOrder.distanceList.addItem(new Distance("taman sentul utama","pv12",4));
       ScheduleOrder.distanceList.addItem(new Distance("taman sentul utama","pv15",4));
    }

    @Override
    public int calculateDistance(String restaurant, String deliverAddress) {
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
