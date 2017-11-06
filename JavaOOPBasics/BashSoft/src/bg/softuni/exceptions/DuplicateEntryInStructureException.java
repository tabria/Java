package bg.softuni.exceptions;

public class DuplicateEntryInStructureException extends RuntimeException {

    private static final String DUPLICATE_ENTRY ="Student is already enrolled for this course.";

    public DuplicateEntryInStructureException(String entryName, String structureName) {
        super(String.format(DUPLICATE_ENTRY, entryName, structureName));
    }

    public DuplicateEntryInStructureException(String message) {
        super(message);
    }
}
