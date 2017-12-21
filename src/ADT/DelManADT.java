/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Domain.ClockIO;


/**
 *
 * @author Teck Siong
 * @param <T>
 */
public class DelManADT<T> implements DelManInterface<T> {

    private Node firstNode, lastNode;
    private int size;

    @Override
    public void addData(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
            newNode.previous = lastNode;
        }
        lastNode = newNode;
        size++;
    }

    @Override
    public String toString() {
        String str = "";
        Node temp = firstNode;
        while (temp != null) {
            str += temp.data + " ";
            temp = temp.next;
        }
        return str;
    }

    @Override
    public T getData(int element) {
        Node tmp = firstNode;
        T tmp1 = null;
        for (int i = 0; i <= element; i++) {
            tmp1 = tmp.data;
            tmp = tmp.next;
        }
        return tmp1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
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
    public boolean setItem(int index,T item) {
       boolean isSuccessful = true;

    if ((index >= 0) && (index < size)) {
      Node currentNode = firstNode;
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

}
