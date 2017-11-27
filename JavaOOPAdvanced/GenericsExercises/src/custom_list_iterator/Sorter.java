package custom_list_iterator;

public class Sorter {

    static <T extends Comparable>void sort(CustomList<T> elements){
        elements.getElements().sort((t1, t2) -> t1.compareTo(t2));
    }
}
