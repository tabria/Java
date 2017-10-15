import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WeakStudents {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int badGradeFilter = 3;
        int badGradeCount =2;
        LinkedHashMap<String, ArrayList<Integer>> students = new LinkedHashMap<>();
        fillStudents(students, scanner);

        students.entrySet().stream().filter( kv -> kv.getValue().stream().filter(g-> g.compareTo(badGradeFilter) < 1).count() >= badGradeCount)
                .sorted(Comparator.comparing(st -> st.getValue().stream().mapToInt(x -> x).sum())).forEach(print());
    }

    private static Consumer<Map.Entry<String,ArrayList<Integer>>> print() {
        return kv-> {
            System.out.print(kv.getKey());
            kv.getValue().stream().sorted((x, y) -> x.compareTo(y)).forEach(res-> System.out.print(" " + res.toString()));
            System.out.println();
        };
    }

    private static Predicate<Map.Entry<String,ArrayList<Integer>>> byGrades(Integer needle) {
        return stu -> stu.getValue().stream().anyMatch(i-> i<=needle);
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
