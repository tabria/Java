package entities;

import interfaces.File;

public class LogFile implements File {

    private int size;

    public LogFile() {
        this.setSize(0);
    }

    @Override
    public void write(String message) {

        this.increaseSize(message);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private void increaseSize(String message) {
        int currentSize = 0;
        for (char symbol : message.toCharArray()) {
            if (Character.isAlphabetic(symbol)) {
                currentSize += symbol;
            }
        }
        this.setSize(this.getSize() + currentSize);
    }
}