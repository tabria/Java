package bg.softuni.core;

import bg.softuni.contracts.Executable;
import bg.softuni.contracts.Interpreter;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.contracts.Reader;
import bg.softuni.contracts.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private static final String TERMINATING_COMMAND = "EmergencyBreak";

    private Reader reader;
    private Writer writer;
    private Interpreter interpreter;

    public Engine(Reader reader, Writer writer,Interpreter interpreter) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {

        try {
            while(true){

                String line = this.reader.readLine();
                if (TERMINATING_COMMAND.equals(line)){
                    break;
                }

                String[] commandInput = line.split("\\|");
                Executable command = this.interpreter.makeCommand(commandInput);
                System.out.println(command.execute());

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
