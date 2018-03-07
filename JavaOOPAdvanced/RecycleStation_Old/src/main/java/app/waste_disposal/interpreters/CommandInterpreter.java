package app.waste_disposal.interpreters;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.annotations.InjectEngine;
import app.waste_disposal.contracts.Executable;
import app.waste_disposal.contracts.Interpreter;
import app.waste_disposal.engines.Engine;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMAND_PATH = "app.waste_disposal.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    @Override
    public Executable makeCommand(String input, Engine engine) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String[] commandInfo = input.split("\\s+");
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_PATH + commandInfo[0] + COMMAND_SUFFIX);
        Constructor<Executable> commandConstructor = commandClass.getDeclaredConstructor();
        Executable command = commandConstructor.newInstance();
        String commandsInput = commandInfo.length > 1 ? commandInfo[1] : "";
        this.dependencyInject(commandsInput, engine, command);
        return command;
    }

    private void dependencyInject(String commandInfo, Engine engine,  Executable command) throws IllegalAccessException {

        String[] commandData = commandInfo.split("\\|");

        Field[] commandFields = command.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            if (commandField.isAnnotationPresent(Inject.class)){
                commandField.setAccessible(true);
                commandField.set(command, commandData);
            }
            if (commandField.isAnnotationPresent(InjectEngine.class)){
                commandField.setAccessible(true);
                commandField.set(command, engine);
            }
        }
    }
}
