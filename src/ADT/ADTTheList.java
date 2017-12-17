/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Domain.Food;
import java.util.NoSuchElementException;

/**
 *
 * @author Jeffrey
 */
public class ADTTheList<T> implements ADTTheListInterface<T>{
    
    int size=0;
    Node head;
    Node tail;


    class Node{
        Node prev;
        Node next;
        T data;

        public Node(T data, Node prev, Node next) {
            this.prev = head;
            this.next = next;
            this.data = data;
        }

      

        public Node() {
        }
        
        
    }
    

    @Override
    public T returnItem(int index) {
        Node tmp = head;
        T tmp1 = null;
        for(int i=0;i<=index;i++){
               tmp1=tmp.data;
            tmp = tmp.next;
        }
        return  tmp1;
    }

    @Override
    public boolean setItem(int index,T item) {
       boolean isSuccessful = true;

    if ((index >= 0) && (index < size)) {
      Node currentNode = head;
      for (int i = 0; i < index ; ++i) {
        // System.out.println("Trace| currentNode.data = " + currentNode.data + "\t, i = " + i);
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      currentNode.data = item;	// currentNode is pointing to the node at givenPosition
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }

    @Override
    public void addItem(T item) {
       
       Node tmp = new Node(item, null, tail);
       
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
        
    }


    @Override
    public void clearAll() {
       head=null;
       tail=null;
       size=0;
    }

    @Override
    public void addItem(int Position, T item) {
    
    Node newNode = new Node();
    newNode.data = item;
    newNode.next = null;
    //Position-=1;
    
    Node prev = null;
    Node current = head;
    if(Position==0)
    {
        Node tmp = new Node(item, null, head);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
    }else{
    int i = 0; if ((Position >= 1) && (Position <= size )) {
    while (current !=null && i < Position) {
        prev = current;
        current = current.next;
        i++;
    }
    newNode.next = prev.next;
    prev.next = newNode;}}
    size++;
    
    }

   

    @Override
    public int indexOfItem(T item) {
        
        Node tmp = head;
        int counter=0;
        int position=0;
        for(int i=0;i<size;i++)
        {
            if(tmp.data.equals(item))
            {
                position=i;
                counter++;
            }
            tmp = tmp.next;
            
        }if(counter==0)
        {
            position=-1;
        }
        return position;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean checkEmpty() {
      return size == 0;
    }

     @Override
    public boolean contains(T element)
   {

    Node cursor = head;

    while(cursor != null){

               if(cursor.data.equals(element))

                  return true;

               cursor = cursor.next;

            }

    return false;  

    }
    
    public String toString()
    {
        String x = "";
          Node tmp = tail;
        while(tmp != null){
            x+=tmp.data+",";
            tmp = tmp.prev;
        }
        return x;
    }
    
   public boolean deleteItem(int position) {
    // Complete this method
    Node current = head;
    Node parent = null;
    int index = 0;
    if(position<size){
    while (current != null && index < position) {
        parent = current;
        current = current.next;
        
        index++;
    }
    
    if (current != null && parent == null) {
        // Delete head.
        if (current.next != null) {
            // Move head to next value.
            head = current.next;
        }
        else {
            // Just set the head to null.
            head = null;
        }
    }
    else if (current != null) {
        // Delete current, link parent to child..
        parent.next = current.next;
        
    }
    size--;
    return true;
    }
    
   return false;
}
   
     public void addFirst(T element) {
        Node tmp = new Node(element, head, null);
        if(head != null ) {head.prev = tmp;}
        head = tmp;
        if(tail == null) { tail = tmp;}
        size++;
       
    }
     
     public T deleteFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: "+tmp.data);
        return tmp.data;
    }

     





}
