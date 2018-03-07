import core.Engine;
import interpreters.CommandInterpreter;
import interpreters.Interpreter;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.InputReader;
import io.OutputWriter;

public class Main {

    public static void main(String[] args) {

        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        ManagementSystem managementSystem = new Manager();
        Interpreter interpreter = new CommandInterpreter(managementSystem);

        Runnable engine = new Engine(reader, writer, interpreter);
        engine.run();
    }

}
