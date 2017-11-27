package linked_list_traversal;

import java.util.function.Consumer;

public interface LinkedList<T> {
    void add(T data);

    boolean remove(T data);

    int getSize();

    void forEach(Consumer<? super T> action);
}
