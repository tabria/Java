
import entities.Engine;
import factories.AppenderFactoryImpl;
import interfaces.*;
import interfaces.Runnable;
import io.ConsoleReader;
import io.ConsoleWriter;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ReflectiveOperationException {


        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        AppenderFactory appenderFactory = new AppenderFactoryImpl();
        Runnable engine =  new Engine(reader,writer,appenderFactory);
        engine.run();
    }
}