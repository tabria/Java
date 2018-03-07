package bg.softuni.io;

import bg.softuni.contracts.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader implements Reader {

    private BufferedReader reader;

    public InputReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public String readLine() throws IOException {
        return this.reader.readLine();
    }
}
