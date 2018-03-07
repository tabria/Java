package entities;

import enums.ReportLevel;
import interfaces.Layout;

public class SimpleLayout implements Layout {

    public SimpleLayout() {}

    @Override
    public String stringFormat(String dateTime, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", dateTime, reportLevel, message);
    }
}