package stack_iterator;

import java.util.function.Consumer;

public interface StackInterface<T> {
    void push(T... element);

    void pop();

    void forEach(Consumer<? super T> action);
}
