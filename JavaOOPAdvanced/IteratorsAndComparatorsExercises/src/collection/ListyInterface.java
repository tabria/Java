package collection;

public interface ListyInterface<T> {


    void create(T... elements);

    boolean move();

    boolean hasNext();

    void print();


    void PrintAll();
}
