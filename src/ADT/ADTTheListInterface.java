/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Domain.Food;

/**
 *
 * @author Jeffrey
 */
public interface ADTTheListInterface<T> {
    
    T returnItem(int index);   //return the item of given specific position
    boolean setItem(int index,T item);  //
    void addItem (T item);  //add new item in the back of the list
    boolean deleteItem(int position);   //delete item of the given specific position
    void clearAll ();       //clear all item in the list and now the list is empty
    void addItem (int position, T item);  //add item in the list with given specific position
    int indexOfItem (T item);  //return the index of the position of specific item
    int getSize ();     //return the length of the list with number of element inside the list
    boolean checkEmpty ();   //check the list whether it is empty
    boolean contains(T element);   //check if the item is contain in the list
    void addFirst(T element);  //add item in the first position method
    T deleteFirst();   //delete first position and return the item method

}

interface BubbleSortInterface<T>{
    void bubble_srt(ADTTheListInterface<Food> ls, int option) ; 
     //use to sorting the item based on condition such as
     //alphabetical order in descending or ascending order
    
}
