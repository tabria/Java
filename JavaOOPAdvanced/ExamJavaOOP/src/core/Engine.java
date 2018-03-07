package core;

import interpreters.Interpreter;
import io.InputReader;
import io.OutputWriter;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;
    private Interpreter interpreter;


    public Engine(InputReader reader, OutputWriter writer, Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {

    }
}
