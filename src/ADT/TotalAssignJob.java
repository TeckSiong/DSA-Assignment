/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author khosit
 */
public class TotalAssignJob<T> implements TotalAssignJonInterface<T> {

    private Node firstNode, lastNode;
    private int size;

    @Override
    public void add(T newEntry) {
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

    @Override
    public T get(int element) {
        Node tmp = firstNode; //assign firstNode to tmp
        T tmpN = null; //set tmpN to null
        for (int i = 0; i <= element; i++) {
            tmpN = tmp.data; //get the tmp data
            tmp = tmp.next;
        }
        return tmpN;
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

}
