package weekdays;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY , FRIDAY, SATURDAY, SUNDAY;


    @Override
    public String toString() {
        char firstLetter = super.name().charAt(0);
        String lowerCaseLetters = super.name().toLowerCase().substring(1);
        return firstLetter + lowerCaseLetters;
    }
}
