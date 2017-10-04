import java.util.Scanner;
public class StrudentsResults {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] name = scanner.nextLine().split(" - ");
        String[] grades = name[1].split(", ");

        double jAdv = Double.parseDouble(grades[0]);
        double jOOP = Double.parseDouble(grades[1]);
        double advOOP = Double.parseDouble(grades[2]);
        double average = (jAdv + jOOP + advOOP)/3;

        System.out.printf("%-10s|%7s|%7s|%7s|%7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%-10s|%7.2f|%7.2f|%7.2f|%7.4f|%n", name[0], jAdv, jOOP, advOOP, average);
    }
}
