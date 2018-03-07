package app.commands;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

    String execute(String... args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

}
