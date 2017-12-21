/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Domain.ProductStatus;

public class SortList<T> implements SortInterface<T>{

    @Override
    public void bubble_srt(DelManInterface<ProductStatus> ds) {
        
       
        int n = ds.getSize();
        int k;
        
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                k = i + 1;
            
                if (ds.getData(i).getTrip()< ds.getData(k).getTrip()) {
                    swap(i, k, (DelManADT<ProductStatus>) ds);
                }
            }
            
        }
    }
  
    private void swap(int i, int j, DelManADT<ProductStatus> ds) {
  
        ProductStatus temp;
        temp = ds.getData(i);
        ds.setItem(i, ds.getData(j)); 
        ds.setItem(j, temp); 
    }
}
