package pr0304Barracks.interpreters;

import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMAND_PACKAGE_NAME = "pr0304Barracks.core.commands.";
    private static final String COMMAND_SUFFIX = "Command";


    public CommandInterpreterImpl() {
    }

    @Override
    public Executable interpretCommand(String commandName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

       String baseCommandName = commandName.substring(0,1).toUpperCase() + commandName.substring(1);

        Class<?> commandInterClass;
        try {
            commandInterClass = Class.forName(COMMAND_PACKAGE_NAME + baseCommandName + COMMAND_SUFFIX);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Invalid command!");
        }

        Constructor<?> construct = commandInterClass.getDeclaredConstructor();
        Executable command = (Executable) construct.newInstance();
        return command;
    }
}
