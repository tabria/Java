package weekdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyCalendar {


    private List<WeeklyEntry> weeklyEntries;

    public WeeklyCalendar() {
        this.weeklyEntries = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        WeeklyEntry weeklyEntry = new WeeklyEntry(weekday, notes);
        this.weeklyEntries.add(weeklyEntry);
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        weeklyEntries.sort(WeeklyEntry.BY_WEEKDAYS);
        return weeklyEntries;
    }


}
