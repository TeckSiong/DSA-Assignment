/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Domain.DeliveryMan;

public class SortList<T> implements SortInterface<T>{

    @Override
    public void bubble_srt(DelManInterface<DeliveryMan> ls) {
        
       
        int n = ls.getSize();
        int k;
        
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
                if (ls.getData(i).getTrip() < ls.getData(k).getTrip()) {
                    swap(i, k, (DelManADT<DeliveryMan>) ls);
                }
            }
            
        }
    }
  
    private void swap(int i, int j, DelManADT<DeliveryMan> ls) {
  
        DeliveryMan temp;
        temp = ls.getData(i);
        ls.setItem(i, ls.getData(j)); 
        ls.setItem(j, temp); 
    }
    
  
    private  void printList(DelManADT<DeliveryMan> input) {
          
        for (int i = 0; i < input.getSize(); i++) {
            System.out.print(input.getData(i).getTrip());
        }
        System.out.println("\n");
    } 
}
