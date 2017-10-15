import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class StudentsByAge {

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
                    .append(student[2])
                    .append(" ")
                    .append(student[4]);
            students.add(sb.toString());
            sb.setLength(0);
        }

        students.stream().filter(filterByAge()).forEach(x -> System.out.println(x));

    }

    private static Predicate<? super String> filterByAge() {

        return x-> 18 <=  getAge(x.trim()) && getAge(x.trim()) <= 24;
    }

    private static int getAge(String x) {
        int lastSpaceIndex = x.lastIndexOf(" ");
        String age = x.substring(lastSpaceIndex+1);
        return Integer.parseInt(age);
    }
}
