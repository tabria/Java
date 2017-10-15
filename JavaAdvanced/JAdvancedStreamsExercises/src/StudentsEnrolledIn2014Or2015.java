import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StudentsEnrolledIn2014Or2015 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] years = new int[]{14, 15};
        LinkedHashMap<String, List<Integer>> students = new LinkedHashMap<>();
        fillStudents(students, scanner);

        students.entrySet().stream().filter(byYear(years)).forEach(print());

    }

    private static Consumer<Map.Entry<String,List<Integer>>> print() {
        return kv-> {
            kv.getValue().stream().forEach(grade -> System.out.print(grade + " "));
            System.out.println();
        };
    }

    private static Predicate<Map.Entry<String, List<Integer>>> byYear(int[] years) {
        return kv->  isInRange(kv, years);

    }

    private static boolean isInRange(Map.Entry<String, List<Integer>> kv, int[] years) {
        String number = kv.getKey().trim();
        String yearNumber = number.substring(4, 6);

        return isNumber(yearNumber) && (Integer.parseInt(yearNumber) == years[0] || Integer.parseInt(yearNumber) == years[1]) ? true  : false;
    }

    private static void fillStudents(LinkedHashMap<String, List<Integer>> students, Scanner scanner) {
        while (true) {
            String[] user = scanner.nextLine().split("\\s+");
            if ("END".equals(user[0])) {
                break;
            }
            students.putIfAbsent(user[0].trim(), new ArrayList<>());
            for (int i = 6; i < user.length-1; i++) {
                students.get(user[0].trim()).add(Integer.parseInt(user[i].trim()));
            }
        }
    }

    private static boolean isNumber(String element) {
        return !element.isEmpty() && element.matches("\\d+");
    }
}
