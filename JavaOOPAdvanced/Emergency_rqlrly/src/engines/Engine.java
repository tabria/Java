package engines;

import commands.Executable;
import interpreters.Interpreter;
import io.Reader;
import io.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {


    private static final String EXIT_COMMAND = "EmergencyBreak";

    private Reader reader;
    private Writer writer;
    private Interpreter interpreter;

    public Engine(Reader reader, Writer writer, Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {

            try {

                while(true) {
                    String line = reader.readLine();
                    if (EXIT_COMMAND.equals(line)){
                        break;
                    }
                    Executable command = this.interpreter.makeCommand(line);
                    String commandNotification = command.execute();
                    writer.writeLine(commandNotification);
                }
            } catch (IOException | InstantiationException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }


    }
}
