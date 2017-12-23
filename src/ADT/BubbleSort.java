/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import ADT.ADTTheListInterface;
import ADT.ADTTheList;
import Domain.Food;


public class BubbleSort<T> implements BubbleSortInterface<T>{ // class to implement bubble sort list
    

    public void bubble_srt(ADTTheListInterface<Food> ls, int option) { //method of bubble sort to sort 
                                                                         //the food menu that display to customer
        
        if(option==1) //if option 1 then sort the food name
        {
            int n = ls.getSize(); //get the list size
        int k;
        
        for (int m = n; m >= 0; m--) {  
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
          if (ls.returnItem(i).getFoodName().toUpperCase().compareTo(ls.returnItem(k).getFoodName().toUpperCase())>0) {
                    swap(i, k, (ADTTheList<Food>) ls); //swap position between two elements if the elements 
                                                        // on left hands side if bigger than right side
                }
            }
            
        }
        }else if(option==2) //if option 2 then sort the food category
        {
            int n = ls.getSize();
        int k;
        
        for (int m = n; m >= 0; m--) { //serach and sort in the list
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
          if (ls.returnItem(i).getCategory().toUpperCase().compareTo(ls.returnItem(k).getCategory().toUpperCase())>0) {
                    swap(i, k, (ADTTheList<Food>) ls); //swap position between two elements if the elements 
                                                        // on left hands side if bigger than right side
                }
            }}
        }else{ //if other opptions then sort the food price
        int n = ls.getSize(); //get food size
        int k; 
        
        for (int m = n; m >= 0; m--) {  //serach and sort in the list
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
                if (ls.returnItem(i).getPrice() > ls.returnItem(k).getPrice()) {
                    swap(i, k, (ADTTheList<Food>) ls); //swap position between two elements if the elements 
                                                        // on left hands side if bigger than right side
                }
            }
           
        }}
       
    }
  
    private void swap(int i, int j, ADTTheList<Food> ls) { //swap the postion in the list according to order 
  
        Food temp; //declare a temp food object
        temp = ls.returnItem(i); //set the food item that high order in the temp
        ls.setItem(i, ls.returnItem(j)); // set the item with low order to the front position
        ls.setItem(j, temp); // set the item with high order to the back position
    }
    
  

   
}
