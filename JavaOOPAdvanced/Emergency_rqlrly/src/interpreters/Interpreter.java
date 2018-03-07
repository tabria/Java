package interpreters;

import commands.Executable;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    Executable makeCommand(String text) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
