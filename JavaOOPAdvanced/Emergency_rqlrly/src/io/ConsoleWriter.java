package io;

public class ConsoleWriter implements Writer {
    @Override
    public void writeLine(String text) {
        System.out.println(text);

    }
}
