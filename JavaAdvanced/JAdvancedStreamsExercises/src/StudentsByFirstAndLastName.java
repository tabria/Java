import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> students = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] student = scanner.nextLine().split("\\s+");
            if ("END".equalsIgnoreCase(student[0])){
                break;
            }
            sb.append(student[1])
                    .append(" ")
                    .append(student[2]);
            students.add(sb.toString());
            sb.setLength(0);
        }

        students.stream().filter(checkNames()).forEach(System.out::println);

    }

    private static Predicate<String> checkNames() {
        return x-> x.trim().substring(0, x.indexOf(" ")).compareTo(x.trim().substring(x.trim().indexOf(" ")+1)) < 1;
    }
}
