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
    
    T returnItem(int index);
    boolean setItem(int index,T item);
    void addItem (T item);
    boolean deleteItem(int position);
    void clearAll ();
    void addItem (int position, T item);
    int indexOfItem (T item);
    int getSize ();
    boolean checkEmpty ();
    boolean contains(T element);
    void addFirst(T element);
    T deleteFirst();


    
}

interface BubbleSortInterface<T>{
    void bubble_srt(ADTTheListInterface<Food> ls, int option) ;
    
}