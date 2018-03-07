package bg.softuni;

import bg.softuni.contracts.Interpreter;
import bg.softuni.contracts.Reader;
import bg.softuni.contracts.Writer;
import bg.softuni.core.EmergencyManagementSystem;
import bg.softuni.core.Engine;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.interpreters.CommandInterpreter;
import bg.softuni.io.ConsoleWriter;
import bg.softuni.io.InputReader;

public class Main {

    public static void main(String[] args) {

        Reader reader = new InputReader();
        Writer writer = new ConsoleWriter();
        ManagementSystem managementSystem = new EmergencyManagementSystem();
        Interpreter interpreter = new CommandInterpreter(managementSystem);

        Runnable engine = new Engine(reader, writer, interpreter);
        engine.run();

    }

}
