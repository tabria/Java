package app.abstractClasses;

import app.interfaces.Handler;
import app.enums.LogType;

public abstract class AbstractLogger implements Handler {

    private Handler successor;

    protected Handler getSuccessor(){
        return this.successor;
    }

    protected void passToSuccessor(LogType type, String message) {
        if (successor != null) {
            successor.handle(type, message);
        }
    }

    @Override
    public abstract void handle(LogType logType, String message);

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}