package generic_swap_method_strings;

import java.util.List;

public interface IBox<T> {


    void addElement(T element);
    List<T> getElements();
    <T> void swap(List<T> data, int index1, int index2);
}
