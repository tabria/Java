package bg.softuni.exceptions;

public class InvalidCommandException extends RuntimeException {

    private static final String INVALID_COMMAND = "Invalid command %s is invalid";

    public InvalidCommandException(String command) {
        super(String.format(INVALID_COMMAND, command));
    }
}
