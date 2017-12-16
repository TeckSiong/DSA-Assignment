/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import ADT.ADTTheListInterface;
import ADT.ADTTheList;
import Domain.Food;


public  class BubbleSort {
    
 
  static ADTTheList<Food> ls = new ADTTheList<Food>();
   
     
  
    // logic to sort the elements
    
    public static void bubble_srt(ADTTheListInterface<Food> ls, int option) {
        
        if(option==1)
        {
            int n = ls.getSize();
        int k;
        
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
                if (ls.returnItem(i).getFoodName().toUpperCase().compareTo(ls.returnItem(k).getFoodName().toUpperCase())>0) {
                    swap(i, k, (ADTTheList<Food>) ls);
                }
            }
            //printNumbers(ls);
        }
        }else if(option==2)
        {
            int n = ls.getSize();
        int k;
        
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
                if (ls.returnItem(i).getCategory().toUpperCase().compareTo(ls.returnItem(k).getCategory().toUpperCase())>0) {
                    swap(i, k, (ADTTheList<Food>) ls);
                }
            }}
        }else{
        int n = ls.getSize();
        int k;
        
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
                if (ls.returnItem(i).getPrice() > ls.returnItem(k).getPrice()) {
                    swap(i, k, (ADTTheList<Food>) ls);
                }
            }
           
        }}
         printNumbers((ADTTheList<Food>) ls);
    }
  
    private static void swap(int i, int j, ADTTheList<Food> ls) {
  
        Food temp;
        temp = ls.returnItem(i);
        ls.setItem(i, ls.returnItem(j)); //use for loop to travel the node and set ele
        ls.setItem(j, temp);  // getMethod use forloop to travel the node
    }
    
  
    private static void printNumbers(ADTTheList<Food> input) {
          
        for (int i = 0; i < input.getSize(); i++) {
            System.out.print(input.returnItem(i).getFoodName() + ", ");
        }
        System.out.println("\n");
    }

   
   
    
   
}
