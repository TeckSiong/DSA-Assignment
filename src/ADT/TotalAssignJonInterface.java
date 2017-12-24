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
interface TotalAssignJonInterface<T> {
    void add(T newEntry);
    T get(int element);
    int getSize();
    boolean isEmpty();
}
