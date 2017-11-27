package custom_list_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomList<T extends Comparable> implements Iterable<T> {

    private List<T> elements;

    public CustomList() {
        this.elements = new LinkedList<>();
    }

    public List<T> getElements() {
        return this.elements;
    }

    void add(T element){
        this.elements.add(element);
    }

     T remove(int index){
         return this.elements.remove(index);
     }

     boolean contains(T element){
         return this.elements.contains(element);
     }

     void swap(int index1, int index2){
        T temp = this.elements.get(index1);
        this.elements.set(index1, this.elements.get(index2));
        this.elements.set(index2, temp);
     }

     int countGreaterThan(T element){
        int count = 0;
         for (T el:this.elements) {
             if (element.compareTo(el) < 0){
                 count++;
             }
         }
         return count;
     }
     T getMax(){
         T max = this.elements.get(0);
         for (T element:this.elements) {
             if (max.compareTo(element) < 0){
                 max = element;
             }
         }
         return max;
     }
     T getMin() {
         T min = this.elements.get(0);
         for (T element:this.elements) {
             if (min.compareTo(element) > 0){
                 min = element;
             }
         }
         return min;
     }


    @Override
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }
}
