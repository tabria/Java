package cresla.engines;

import cresla.core.SupplyId;
import cresla.interfaces.Identifiable;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.io.IOException;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Engine implements Runnable {


    private static final String EXIT_COMMAND = "Exit";

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }


    @Override
    public void run() {
        try {
            while(true){

                List<String> input = Arrays.asList(this.reader.readLine().split("\\s+"));
                this.dispatchCommands(input);

                if (EXIT_COMMAND.equals(input.get(0))){
                    break;
                }
            }
        } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    private void dispatchCommands(List<String> input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String commandType = input.get(0);
        switch(commandType){
            case "Reactor":
                this.writer.writeLine(this.manager.reactorCommand(input));
                break;
            case "Module":
                this.writer.writeLine(this.manager.moduleCommand(input));
                break;
            case "Report":
                this.writer.writeLine(this.manager.reportCommand(input));
                break;
            case "Exit":
                this.writer.writeLine(this.manager.exitCommand(input));
                break;
        }


    }
}
