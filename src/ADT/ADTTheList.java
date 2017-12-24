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
    
    int size=0;  //declare the keep track the number of node in the list
    Node head;   //use to store the head node / firstnode of the linked list
    Node tail;  //Use to store the tail node


    class Node{    //Create a class called Node to store the data and the position in the linked list
        Node prev;  //use to store the previous node that point by the current node to form a list
        Node next;  //use to store the next node that point by the current node to form a list
        T data;  //use to store the data in the node

        public Node(T data, Node prev, Node next) { //constructor of the node input local assign to global variable
            this.prev = prev; 
            this.next = next; 
            this.data = data; 
        }

        public Node(T data) {  //alternative constructor that input only the data
            this.data = data;
        }

        public Node() { // empty constructor
        }

    }

   
    @Override
    public T returnItem(int index) { //this is the method to get entry in the given specific position
        Node tmp = head; //assign head node to a temporary node
        T tmp1 = null;  // declare a temporary node
        for(int i=0;i<=index;i++){ //loop to retrieve the item based on the index
               tmp1=tmp.data; //assign the index value to the temp node;
            tmp = tmp.next;   
        }
        return  tmp1; //return the node that selected by user
    }

    @Override
    public boolean setItem(int index,T item) {  //set the entry of the specific position
       boolean isSuccessful = true;  //set boolean suceess to true

    if ((index >= 0) && (index < size)) {  //check the given position is valid
      Node currentNode = head; //point head node to the current temporary node 
      for (int i = 0; i <index ; ++i) { //loop to reach the specific index to retrieve the entry item
  
        currentNode = currentNode.next;	 // advance currentNode to next node
      }
      currentNode.data = item;	// currentNode is pointing to the node at givenPosition
    } else {
      isSuccessful = false; //set success to false if all above condition is not meet
    }

    return isSuccessful; // return successfully result
    }

    @Override
    public void addItem(T item) {  //add item to the back of the list
       
       Node tmp = new Node(item, tail, null); //declare new node and put data in the node assign 
       
        if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        size++;
        
    }


    @Override
    public void clearAll() {//clear all entries in the list
       head=null; //clear head to broke the list and sent all node to Java Garbage Collector
       tail=null;  //clear tail node
       size=0;  // reset the total element of node to zero
    }

    @Override
    public void addItem(int Position, T item) { //add item to specific position in the list
    
    Node newNode = new Node(); //create new node to store the element
    newNode.data = item; //assign data to the new node
    newNode.next = null; //assign next node to null;
    //Position-=1;
    
    Node prev = null;
    Node current = head; //set a current node point to head
    if(Position==0) // check if the position is zero
    {
        Node tmp = new Node(item, null, head); //assign the current head node to the next node of the new node
        if(head != null ) {head.prev = tmp;} //if head is null, point new node to head
        head = tmp; 
        if(tail == null) { tail = tmp;} //if tail is null, also point new node to the tail node
    }else{
    int i = 0; if ((Position >= 1) && (Position <= size )) { 
        //check the position is valid other than position in zero
    while (current !=null && i < Position) {//search the position abd insert the node
        prev = current; //point prev to current node
        current = current.next; // set current's node as current node
        i++; //increase and keep track th position
    }
    newNode.next = prev.next;
    prev.next = newNode;}}
    size++;//increase the size of the number element in the list
    
    }

   

    @Override
    public int indexOfItem(T item) { //search index on given specific entry/item
        
        Node tmp = head; //point head node to temporary node
        int counter=0; //declare a variable as zero
        int position=0;
        for(int i=0;i<size;i++) //loop through the list to search the position
        {
            if(tmp.data.equals(item)) // if found capture the i position
            {
                position=i;
                counter++; //set counter to acknowledged it is found
            }
            tmp = tmp.next; // loop to next node to make compare to the entries enter by user
            
        }if(counter==0) //if counter ==0 means that position is not found then return -1;
        {
            position=-1;
        }
        return position; // return the found position to the user
    }

    @Override
    public int getSize() { //return the number of node in the linked list
        return size;
    }

    @Override
    public boolean checkEmpty() {//check the linked list is empty
      return size == 0;
    }

     @Override
    public boolean contains(T element) //check if the list contains the elements
   {

    Node cursor = head; //assign the head to a temp node

    while(cursor != null){ //loop until the node is null

               if(cursor.data.equals(element)) //check if the node data is equal to the input element

                  return true; //if match will return true

               cursor = cursor.next; // keep point the cursor node point
                                      // to next node until it is found the node

            }

    return false;  

    }
    
    public String toString() //override to string method
    {
        String x = "";
          Node tmp = tail;
        while(tmp != null){
            x+=tmp.data+",";
            tmp = tmp.prev;
        }
        return x;
    }
    
   public boolean deleteItem(int position) { //delete item in the given specific position
    // Complete this method
    Node current = head; //point head node to a current temporary node
    Node parent = null; // set a null node
    int index = 0; // set index node to 0
    if(position<size){ //if the position less than the given position return false
    while (current != null && index < position) { //if given position is valid
        parent = current;   //point the current node to parent
        current = current.next; // loop to next node to search
        
        index++; // loop to next node to search
    }
    
    if (current != null && parent == null) { //if parent and current not null
    
        if (current.next != null) {
         
            head = current.next;    //Move head to next value and  Delete head node.
        }
        else {
           
            head = null; // set the head node to null.
        }
    }
    else if (current != null) {
       
        parent.next = current.next;  // Delete current, link parent node to child node
        
    }
    size--;
    return true; // return false if the item is successfully remove by the user
    }
    
   return false; //return false if the item is not successfully remove by the user
}
   
     public void addFirst(T element) { //add element to the first position of the list
        Node tmp = new Node(element, head, null); //add new element to the new node
        if(head != null ) {head.prev = tmp;} // declare as head is the head node is null currently
        head = tmp; //set the new node as head node
        if(tail == null) { tail = tmp;} //check if the tail is null, set as tail also if tail is null
        size++; // incrrease the number of elements in the list after add new entry
       
    }
     
     public T deleteFirst() { //delete node that store in the first position
        if (size == 0) throw new NoSuchElementException();  //check if the list is empty
        Node tmp = head;  //declare a temporary node that point to head node
        head = head.next; //assign second node as head node
        head.prev = null; //to make second as head so need declare head previous as null
        size--; //reduce the size of the list after remove the firstnode
        return tmp.data; //return the node that remove from the list
    }
    
}
