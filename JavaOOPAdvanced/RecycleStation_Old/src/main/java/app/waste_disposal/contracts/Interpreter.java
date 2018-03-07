package app.waste_disposal.contracts;

import app.waste_disposal.engines.Engine;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    Executable makeCommand(String input, Engine engine) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

}
