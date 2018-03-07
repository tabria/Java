package app.models.logger;

import app.abstractClasses.AbstractLogger;
import app.enums.LogType;

public class TargetLogger extends AbstractLogger {

    @Override
    public void handle(LogType type, String message) {

        if (type == LogType.TARGET) {
            System.out.println(type.name() + ": " + message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}