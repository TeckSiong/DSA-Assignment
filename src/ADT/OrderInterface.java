/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author User
 */
public interface OrderInterface<T> {
    
    public boolean add(T newEntry);
    public T getEntry(int givenPosition);
    public boolean isEmpty();
    public void clear();
    
}
