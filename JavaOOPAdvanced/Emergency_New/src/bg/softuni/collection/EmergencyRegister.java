package bg.softuni.collection;

import bg.softuni.contracts.Register;

public class EmergencyRegister<T> implements Register<T> {

    private static final Integer INITIAL_SIZE = 16;

    private T[] emergencyQueue;

    private Integer currentSize;

    private Integer nextIndex;

    public EmergencyRegister() {
        this.emergencyQueue = (T[]) new Object[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }


    public void enqueueEmergency(T emergency) {
        this.checkIfResizeNeeded();

        this.emergencyQueue[this.nextIndex] = emergency;
        this.nextIndex++;

        this.currentSize++;
    }

    public T dequeueEmergency() {
        T removedElement = this.emergencyQueue[0];

        for (int i = 0; i < this.currentSize-1 ; i++) {
            this.emergencyQueue[i] = this.emergencyQueue[i + 1];
        }

        this.nextIndex--;
        this.currentSize--;

        return removedElement;
    }

    public T peekEmergency() {
        T peekedElement = this.emergencyQueue[0];
        return peekedElement;
    }

    public Boolean isEmpty() {
        return this.currentSize == 0;
    }

    public Integer getCurrentSize() {
        return this.currentSize;
    }

    private void checkIfResizeNeeded() {
        if(this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    private void resize() {
        T[] newArray = (T[]) new Object[2 * this.currentSize];

        for (int i = 0; i < this.currentSize; i++) {
            newArray[i] = this.emergencyQueue[i];
        }

        this.emergencyQueue = newArray;
    }




}
