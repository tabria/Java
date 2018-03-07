package app.models.logger;

import app.abstractClasses.AbstractLogger;
import app.enums.LogType;

public class EventLogger extends AbstractLogger {

    @Override
    public void handle(LogType type, String message) {

        if (type == LogType.EVENT) {
            System.out.println(type.name() + ": " + message);
        } else {
            super.passToSuccessor(type, message);
        }
    }
}