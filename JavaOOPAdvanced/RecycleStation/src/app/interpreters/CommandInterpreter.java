package app.interpreters;

import app.commands.Executable;
import app.waste_disposal.annotations.InjectBalance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMAND_PATH = "app.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private static final String ENGINE_PATH = "app.core.";
    private static final String ENGINE_NAME = "Engine";

    @Override
    public Executable makeCommand(String text) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] commandInput = text.split("\\s+");
        String commandName = commandInput[0];

        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_PATH + commandName + COMMAND_SUFFIX);
        Constructor<Executable> commandConstructor = commandClass.getDeclaredConstructor();
        Executable command = (Executable) commandConstructor.newInstance();
        return command;
    }




}
