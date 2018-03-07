package cresla.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface Manager {
    String reactorCommand(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    String moduleCommand(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    String reportCommand(List<String> arguments);

    String exitCommand(List<String> arguments) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException;
}
