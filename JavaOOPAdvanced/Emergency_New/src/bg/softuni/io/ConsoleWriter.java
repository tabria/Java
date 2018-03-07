package bg.softuni.io;

import bg.softuni.contracts.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void WriteLine(String text) {
        System.out.println(text);
    }
}
