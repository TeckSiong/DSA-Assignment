/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;
import Domain.orders;
import java.util.NoSuchElementException;
/**
 *
 * @author User
 */
public class ADTOrder<T> implements OrderInterface<T> {
    
    private Node firstNode;
    private int numberOfEntries =0 ;
    
  
    
    public ADTOrder(){
     clear();
    }
    
    public boolean add(T newEntry) {
    Node newNode = new Node(newEntry);	// create the new node

    if (isEmpty()) // if empty list
    {
      firstNode = newNode;
    } else {                        // add to end of nonempty list
      Node currentNode = firstNode;					// traverse linked list with p pointing to the current node
      while (currentNode.next != null) {		// while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; // make last node reference new node
    }

    numberOfEntries = numberOfEntries +1;
    return true;
  }
    
    public T getEntry(int givenPosition) {
    T result = null;

    
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition -1 ; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    

    return result;
  }
   
    
    
    public boolean isEmpty() {
    boolean result;

    result = (numberOfEntries == 0);

    return result;
  }
     
    
    public final void clear() {
    firstNode = null;
    numberOfEntries = 0;
  }
    
    public int getSize() {
        return numberOfEntries;
    }
    
    private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
    
   
    
    
}
