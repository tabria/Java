package interpreters;

import java.lang.reflect.Executable;

public interface  Interpreter {

    Executable makeCommand(String... args);

}
