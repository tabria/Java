package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T>, ListyInterface<T> {

    private List<T> list;
    private int index;

    public ListyIterator(T... elements) {
        this.list = Arrays.asList(elements);
        this.index = 0;
    }

    private List<T> getList() {
        return Collections.unmodifiableList(this.list);
    }

    protected int getIndex() {
        return this.index;
    }

    protected void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void create(T[] elements) {
            this.list = Arrays.asList(elements);
    }

    @Override
    public boolean move() {
        if (this.hasNext()){
            index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return index < this.getList().size() - 1 ;
    }

    @Override
    public void print() {
        if (!this.getList().isEmpty()){
            System.out.println(this.getList().get(this.getIndex()));
            return;
        }
        throw new UnsupportedOperationException("Invalid Operation!");
    }

    @Override
    public void PrintAll(){

        this.getList().forEach(e-> System.out.print(e + " "));
    }

    @Override
    public Iterator<T> iterator() {
        return new ListyIterater() ;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        while(this.iterator().hasNext()){
            action.accept(this.iterator().next());
        }

    }

    private final class ListyIterater implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return index < list.size() ;
        }

        @Override
        public T next() {
            return getList().get(index++);
        }
    }
}
