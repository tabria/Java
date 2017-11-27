package generic_swap_method_integers;

import java.util.LinkedList;
import java.util.List;

public class Box<T> implements IBox<T> {

    private List<T> elements;

    public Box() {
        this.elements = new LinkedList<>();
    }

    public void addElement(T element){
        this.elements.add(element);
    }

    public List<T> getElements() {
        return this.elements;
    }

    public <T> void swap(List<T> data, int index1, int index2){
        T temp = data.get(index1);
        data.set(index1, data.get(index2));
        data.set(index2, temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element:this.elements) {
            sb.append(String.format("%s: %s%n", element.getClass().getName(), element));
        }
        return sb.toString();
    }
}
