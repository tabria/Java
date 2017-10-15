import java.util.*;
import java.util.function.Predicate;

public class ExcellentStudents {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer filterValue = 6;
        LinkedHashMap<String, ArrayList<Integer>> students = new LinkedHashMap<>();
        fillStudents(students, scanner);
        students.entrySet().stream().filter(byGrades(filterValue)).forEach(kv-> {
            System.out.print(kv.getKey());
            kv.getValue().stream().sorted((gr1, gr2) -> gr2.compareTo(gr1)).forEach(g->  System.out.print(" " + g.toString()));
            System.out.println();
        });


    }

    private static Predicate<Map.Entry<String,ArrayList<Integer>>> byGrades(Integer needle) {
        return kv -> kv.getValue().contains(needle);
    }

    private static void fillStudents(LinkedHashMap<String, ArrayList<Integer>> students, Scanner scanner) {
        while (true) {
            String[] user = scanner.nextLine().split("\\s+");
            if ("END".equals(user[0])) {
                break;
            }
            List<Integer> grades = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            sb.append(user[1])
                    .append(" ")
                    .append(user[2]);
            for (int i = 6; i < user.length-1; i++) {
                String element = user[i].trim();
                if (isNumber(element)){
                    grades.add(Integer.parseInt(element));
                }
            }
            students.putIfAbsent(sb.toString().trim(), new ArrayList<>());
            students.get(sb.toString().trim()).addAll(grades);
            sb.setLength(0);

        }

    }

    private static boolean isNumber(String element) {
        return !element.isEmpty() && element.matches("\\d");
    }
}
