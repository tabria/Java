import core.EmergencyManagementSystem;
import core.ManagementSystem;
import engines.Engine;
import interpreters.Interpreter;
import interpreters.CommandInterpreter;
import io.ConsoleReader;
import io.ConsoleWriter;
import io.Reader;
import io.Writer;

public class main {


    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(managementSystem);
        Runnable engine = new Engine(reader, writer, interpreter);
        engine.run();

    }

}
