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
public interface MenuInterface<T> {
    void addData(T newEntry);
    T getData(int element);
    int getSize();
    boolean isEmpty();
    String toStringReverse();
}
