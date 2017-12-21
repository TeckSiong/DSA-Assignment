/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import Domain.ProductStatus;

/**
 *
 * @author Teck Siong
 */
public interface DelManInterface<T> {
    void addData(T newEntry);
    T getData(int element);
    int getSize();
    boolean isEmpty();
     boolean setItem(int index,T item);
    
}

interface SortInterface<T>{
    void bubble_srt(DelManInterface<ProductStatus> ls);
    
}
