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
public class ScheduleADT<T> implements ScheduleInterface<T>{
    
    
    private Node firstNode, lastNode;
    private int size;


   @Override
    public T returnItem(int index) {
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
    
}
