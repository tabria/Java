package bg.softuni.exceptions;

public class NullOrEmptyValueException extends RuntimeException {

    private static final String NULL_OR_EMPTY_VALUE = "The value of the variable CANNOT be null or empty!";

    public NullOrEmptyValueException() {
        super(NULL_OR_EMPTY_VALUE);

    }


    public NullOrEmptyValueException(String message) {
        super(message);
    }
}
