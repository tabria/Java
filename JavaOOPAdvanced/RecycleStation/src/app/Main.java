package app;

import app.core.BalanceManager;
import app.core.BalanceManagerImpl;
import app.core.Engine;
import app.interpreters.CommandInterpreter;
import app.interpreters.Interpreter;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;
import app.io.Reader;
import app.io.Writer;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.GarbageProcessor;

public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        BalanceManager balanceManager = new BalanceManagerImpl();
        Interpreter interpreter = new CommandInterpreter();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor();
        Engine engine = new Engine(reader, writer, balanceManager, interpreter, garbageProcessor);
        engine.run();

    }
}
