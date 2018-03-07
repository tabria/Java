package interpreters;

import annotations.InjectType;
import annotations.InjectArgs;
import commands.Executable;
import core.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {


    private static final String COMMAND_PATH = "commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private ManagementSystem managementSystem;

    public CommandInterpreter(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    public Executable makeCommand(String text) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] commandInfo = text.split("\\|");
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_PATH + commandInfo[0] + COMMAND_SUFFIX);
        Constructor<Executable> commandConstructor = commandClass.getDeclaredConstructor(ManagementSystem.class);
        Executable command = commandConstructor.newInstance(this.managementSystem);
        this.injectDependency(command, commandInfo);
        return command;
    }

    private void injectDependency(Executable command, String[] commandInfo) throws IllegalAccessException {
        Field[] commandFields = command.getClass().getDeclaredFields();

        for (Field field:commandFields) {
            if (field.isAnnotationPresent(InjectArgs.class)){
                field.setAccessible(true);
                field.set(command, commandInfo);
            } else if (field.isAnnotationPresent(InjectType.class)){
                field.setAccessible(true);
                field.set(command, commandInfo[1]);
            }
        }
    }

}
