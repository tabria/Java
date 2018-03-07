package enums;

public enum EmergencyLevel {
    MINOR, MAJOR, DISASTER;


    @Override
    public String toString() {
        String smallText = this.name().substring(1).toLowerCase();
        return this.name().charAt(0) + smallText;
    }
}
