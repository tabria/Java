package stack_iterator;

import java.util.*;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T>, StackInterface<T> {

    private List<T> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    private List<T> getStack() {
        return Collections.unmodifiableList(this.stack);
    }

    @Override
    public void push(T[] element){
        Collections.addAll(this.stack, element);
    }

    @Override
    public void pop(){
        int stackSize = this.getStack().size();
        if (stackSize > 0){
            this.stack.remove(stackSize-1);
            return;
        }
        throw new NoSuchElementException("No elements");
    }


    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterator<T> itr = this.iterator();
        while(itr.hasNext()){
            action.accept(itr.next());
        }
    }

    private final class StackIterator implements Iterator<T>{
        private int index;

        public StackIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < stack.size();
        }

        @Override
        public T next() {
            return stack.get(index++);
        }
    }
}
