package bg.softuni.interpreters;

import bg.softuni.annotations.InjectData;
import bg.softuni.contracts.Executable;
import bg.softuni.contracts.Interpreter;
import bg.softuni.contracts.ManagementSystem;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter {

    private static final String COMMAND_PATH = "bg.softuni.commands.";
    private static final String COMMAND_SUFFIX = "Command";

    private ManagementSystem managementSystem;

    public CommandInterpreter(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    @Override
    public Executable makeCommand(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String commandName = args[0];
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_PATH + commandName + COMMAND_SUFFIX);
        Constructor<Executable> commandConstructor = commandClass.getDeclaredConstructor(ManagementSystem.class);
        Executable command = commandConstructor.newInstance(this.managementSystem);
        this.dependencyInject(command, args);

        return command;
    }

    private void dependencyInject(Executable command, String[] args) throws IllegalAccessException {
        Field[] commandFields = command.getClass().getDeclaredFields();
        for (Field field:commandFields) {
            if (field.isAnnotationPresent(InjectData.class)){
                field.setAccessible(true);
                field.set(command, args);
                break;
            }
        }

    }


}
