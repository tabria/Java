package app.models.commands;

import app.interfaces.command.Command;
import app.interfaces.command.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}