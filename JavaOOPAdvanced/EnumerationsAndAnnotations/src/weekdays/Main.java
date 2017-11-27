package weekdays;

public class Main {

    public static void main(String[] args) {

        WeeklyCalendar calendar = new WeeklyCalendar();
        calendar.addEntry("Friday", "sleep");
        calendar.addEntry("Monday", "sport");
        for (WeeklyEntry weeklyEntry :calendar.getWeeklySchedule()) {
            System.out.println(weeklyEntry);
        }

    }
}
