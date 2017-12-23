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
    boolean setItem(int index, T item);
}

interface SortInterface<T> {
    void bubble_srt(DelManInterface<ProductStatus> ls);
}