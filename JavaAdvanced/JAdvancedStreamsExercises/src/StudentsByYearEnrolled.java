import java.util.*;
import java.util.stream.Collectors;

public class StudentsByYearEnrolled {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> students = new HashMap<>();
        Set<String> yearsEnding = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] student = scanner.nextLine().split("\\s+");
            if ("END".equalsIgnoreCase(student[0])){
                break;
            }
            yearsEnding.add(student[0].substring(4,6));
            sb.append(student[1])
                    .append(" ")
                    .append(student[2]);
            students.put(student[0], sb.toString());
            sb.setLength(0);
        }

        LinkedHashMap<String, String> sortedStudents = students.entrySet().stream().sorted((x, y) -> x.getKey().substring(4, 6).compareTo(y.getKey().substring(4, 6)))
                .sorted((m,n)-> getName(m, n).compareTo(n.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e1, LinkedHashMap::new));

        for (String year: yearsEnding) {
            System.out.println("20" + year + ":");
            sortedStudents.entrySet().stream().filter(x->x.getKey().substring(4,6).equals(year)).forEach(element -> System.out.println("-- " + element.getValue()));
        }

    }

    private static Comparable<String> getName(Map.Entry<String, String> m, Map.Entry<String, String> n) {
        String lastNumber1 = m.getKey().substring(4,6);
        String lastNumber2 = n.getKey().substring(4,6);
        if (lastNumber1.equals(lastNumber2)){
            return m.getValue();
        } else {
            return n.getValue();
        }
    }

}
