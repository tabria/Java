import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterStudentsByPhone {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> users = new LinkedHashMap<>();
        fillUsers(users, scanner);
        String[] areaCode = new String[]{"02", "+3592"};
        users.entrySet().stream().filter(filterByPhone(areaCode)).forEach(kv -> System.out.println(kv.getKey() + " " + kv.getValue()));

    }

    private static Predicate<Map.Entry<String,String>> filterByPhone(String[] areaCode) {
        return kv -> kv.getValue().trim().startsWith(areaCode[0]) || kv.getValue().trim().startsWith(areaCode[1]);
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
            users.put(sb.toString(), student[10]);
            sb.setLength(0);
        }
    }



}
