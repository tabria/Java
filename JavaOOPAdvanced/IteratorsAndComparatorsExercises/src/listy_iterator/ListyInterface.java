package listy_iterator;

public interface ListyInterface<T> {


    void create(T... elements);

    boolean move();

    boolean hasNext();

    void print();

}
