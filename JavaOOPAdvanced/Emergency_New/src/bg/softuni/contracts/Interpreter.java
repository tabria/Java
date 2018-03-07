package bg.softuni.contracts;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    Executable makeCommand(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
