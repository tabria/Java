package bg.softuni.exceptions;

public class KeyNotFoundException extends RuntimeException {

    private static final String NOT_ENROLLED_IN_COURSE = "Student must be enrolled in course before you set this mark.";

    public KeyNotFoundException() {
        super(NOT_ENROLLED_IN_COURSE);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}
