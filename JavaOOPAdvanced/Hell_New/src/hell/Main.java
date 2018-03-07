package hell;

import hell.entities.engines.Engine;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.Reader;
import hell.io.Writer;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        Runnable engine = new Engine(reader, writer);
        engine.run();

    }
}