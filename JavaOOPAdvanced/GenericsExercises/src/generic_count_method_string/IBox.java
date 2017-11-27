package generic_count_method_string;

import java.util.List;

public interface IBox<T> {


    void addElement(T element);
    List<T> getElements();
    <T extends Comparable<T>> int compare(List<T> elements, T element);
    <T> void swap(List<T> data, int index1, int index2);
}
