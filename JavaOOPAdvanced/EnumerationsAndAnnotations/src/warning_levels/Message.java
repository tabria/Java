package warning_levels;

public class Message {

    private Importance type;
    private String message;

    public Message(Importance type, String message) {
        this.type = type;
        this.message = message;
    }

    public Importance getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.type.name(), this.message);
    }
}
