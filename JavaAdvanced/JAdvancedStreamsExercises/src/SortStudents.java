import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class SortStudents {

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

        students.stream().sorted(byLastNameASC()).sorted(byFirstNameDSC()).forEach(s-> System.out.println(s));

    }

    private static Comparator<String> byFirstNameDSC() {
        return (str1, str2) -> getFirstName(str2, str1).compareTo(str1.substring(0, str1.indexOf(" ")));
    }

    private static  Comparable<String> getFirstName(String secondUser, String firstUser) {
        if(secondUser.substring(secondUser.indexOf(" ")+1).equals(firstUser.substring(firstUser.indexOf(" ")+1))) {
            return secondUser.substring(0, secondUser.indexOf(" "));
        }
        return firstUser.substring(0, firstUser.indexOf(" "));
    }

    private static Comparator<String> byLastNameASC() {
        return (str1, str2) -> getLastName(str1.trim()).compareTo(getLastName(str2.trim()));
    }

    private static String getLastName(String user) {
        return user.substring(user.indexOf(" ")+1);
    }


}
