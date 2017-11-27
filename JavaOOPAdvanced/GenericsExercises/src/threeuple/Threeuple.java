package threeuple;

public class Threeuple<T, E, S> {

    private T item1;
    private E item2;
    private S item3;

    public Threeuple(T item1, E item2, S item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    public T getItem1() {
        return this.item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public E getItem2() {
        return this.item2;
    }

    public void setItem2(E item2) {
        this.item2 = item2;
    }

    public S getItem3() {
        return this.item3;
    }

    public void setItem3(S item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return this.getItem1() + " -> " + this.getItem2() + " -> " + this.getItem3();
    }
}
