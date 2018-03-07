package bg.softuni.contracts;

public interface Register<T> {

    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    T peekEmergency();

    Boolean isEmpty();

    Integer getCurrentSize();


}
