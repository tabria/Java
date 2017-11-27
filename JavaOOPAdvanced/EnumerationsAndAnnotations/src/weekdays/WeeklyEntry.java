package weekdays;

import java.util.Comparator;

public class WeeklyEntry {

    public final static Comparator<WeeklyEntry> BY_WEEKDAYS = getComparedByWeekDays();

    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekdays, String notes) {
        this.weekday = Weekday.valueOf(weekdays.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return this.weekday;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.weekday, this.notes);
    }

    private static Comparator<WeeklyEntry> getComparedByWeekDays() {
        return (e1, e2) -> Integer.compare(e1.getWeekday().ordinal(), e2.getWeekday().ordinal());
    }
}
