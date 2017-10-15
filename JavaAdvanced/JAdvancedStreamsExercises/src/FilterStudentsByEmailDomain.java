import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterStudentsByEmailDomain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> users = new LinkedHashMap<>();
        String email ="@gmail.com";
        fillUsers(users, scanner);

        users.entrySet().stream().filter(getOnlyByEmail(email)).forEach(kv -> System.out.println(kv.getKey() + " " + kv.getValue()));
    }

    private static Predicate<Map.Entry<String,String>> getOnlyByEmail(String email) {
        return kv -> kv.getValue().trim().contains(email);
    }

    private static void fillUsers(LinkedHashMap<String, String> users, Scanner scanner) {
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] student = scanner.nextLine().split("\\s+");
            if ("END".equalsIgnoreCase(student[0])){
                break;
            }
            sb.append(student[1])
                    .append(" ")
                    .append(student[2]);
            users.put(sb.toString(), student[3]);
            sb.setLength(0);
        }
    }

}
