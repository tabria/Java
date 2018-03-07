package app.interpreters;

import app.commands.Executable;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {
    Executable makeCommand(String text) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
