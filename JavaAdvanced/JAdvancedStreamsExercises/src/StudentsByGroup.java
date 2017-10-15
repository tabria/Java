import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StudentsByGroup {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        List<String> students = new ArrayList<>();
        while(true){
            String[] student = scanner.nextLine().split("\\s+");
            if ("END".equalsIgnoreCase(student[0])){
                break;
            }
            sb.append(student[1])
                    .append(" ")
                    .append(student[2])
                    .append(" ")
                    .append(student[5]);
            students.add(sb.toString());
            sb.setLength(0);
        }
        if (!students.isEmpty()){
            students.stream().filter(x -> !x.trim().isEmpty() && x.trim().charAt(x.trim().length()-1)== '2').sorted(sortEntries()).forEach(print());
        }

    }

    private static Consumer<String> print() {
        return x-> {
            System.out.println(x.substring(0, x.length()-2));
        };
    }

    private static Comparator<String> sortEntries() {
        return (y, x) -> y.trim().substring(0, y.indexOf(" ")).compareTo(x.trim().substring(0, x.indexOf(" ")));
    }

}
