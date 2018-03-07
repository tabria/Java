package interfaces;


import enums.ReportLevel;

public interface Layout {
    String stringFormat(String dateTime , String message, ReportLevel reportLevel);
}