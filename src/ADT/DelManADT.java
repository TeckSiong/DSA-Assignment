/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Teck Siong
 * @param <T>
 */
public class DelManADT<T> implements DelManInterface<T> {

    private Node firstNode, lastNode;
    private int size;

    // Add data to the list
    @Override
    public void addData(T newEntry) {
        Node newNode = new Node(newEntry); // add newNode
        if (isEmpty()) {
            firstNode = newNode; // assign newNode  to firstNode
        } else {
            lastNode.next = newNode;
            newNode.previous = lastNode;
        }
        lastNode = newNode; // assign lastNodeto newNode
        size++;
    }

    // display data
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

    //get data from list
    @Override
    public T getData(int element) {
        Node tmp = firstNode; //assign firstNode to tmp
        T tmpN = null; //set tmpN to null
        for (int i = 0; i <= element; i++) {
            tmpN = tmp.data; //get the tmp data
            tmp = tmp.next;
        }
        return tmpN;
    }

    //get the list size
    @Override
    public int getSize() {
        return size;
    }

    //check the list is empty or not
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
    public boolean setItem(int index, T item) {
        boolean suc = true;

        if ((index >= 0) && (index < size)) {
            Node currentNode = firstNode; // assign the firstNode to currentNode
            for (int i = 0; i < index; ++i) {
                currentNode = currentNode.next;	// assign currentNode to next node
            }
            currentNode.data = item; // currentNode data is point to the item position
        } else {
            suc = false;
        }
        return suc;
    }

}
