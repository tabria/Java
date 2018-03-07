package app.core;

import app.commands.Executable;
import app.interpreters.Interpreter;
import app.io.Reader;
import app.io.Writer;
import app.waste_disposal.annotations.InjectBalance;
import app.waste_disposal.annotations.InjectGarbageProcessor;
import app.waste_disposal.contracts.GarbageProcessor;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String TERMINATING_COMMAND = "TimeToRecycle";

    private Reader reader;
    private Writer writer;
    private BalanceManager balanceManager;
    private Interpreter interpreter;
    private GarbageProcessor garbageProcessor;

    public Engine(Reader reader, Writer writer, BalanceManager balanceManager, Interpreter interpreter, GarbageProcessor garbageProcessor) {
        this.reader = reader;
        this.writer = writer;
        this.balanceManager = balanceManager;
        this.interpreter = interpreter;
        this.garbageProcessor = garbageProcessor;
    }

    @Override
    public void run() {

        try {
            while(true){

                String input = this.reader.readLine();
                if (TERMINATING_COMMAND.equals(input)){
                    break;
                }

                String[] commandInfo = input.split("\\s+");
                String commandName =commandInfo[0];
                Executable command = this.interpreter.makeCommand(commandName);
                this.injectDependencies(command);

                String[] wasteInfo = commandInfo.length > 1 ? commandInfo[1].split("\\|") : commandInfo;
                this.writer.writeLine(command.execute(wasteInfo));




            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void injectDependencies(Executable command) throws IllegalAccessException {

        Field[] commandFields = command.getClass().getDeclaredFields();
        for (Field commandField:commandFields) {
            if (commandField.isAnnotationPresent(InjectBalance.class)){
                commandField.setAccessible(true);
                commandField.set(command, this.balanceManager);
            }
            if (commandField.isAnnotationPresent(InjectGarbageProcessor.class)){
                commandField.setAccessible(true);
                commandField.set(command, this.garbageProcessor
                );
            }
        }

    }
}
