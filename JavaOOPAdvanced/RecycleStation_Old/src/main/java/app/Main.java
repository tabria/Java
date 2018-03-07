package app;

import app.waste_disposal.interpreters.CommandInterpreter;
import app.waste_disposal.contracts.Interpreter;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.engines.Engine;

public class Main {
    public static void main(String[] args) {

        Interpreter interpreter = new CommandInterpreter();
	    GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(new DefaultStrategyHolder());
	    Runnable engine = new Engine(garbageProcessor, interpreter);
        engine.run();


    }



}
