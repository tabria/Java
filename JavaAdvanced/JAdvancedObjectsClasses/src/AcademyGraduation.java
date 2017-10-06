import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class AcademyGraduation {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<String>> student = new HashMap<>();

        for (int i = 0; i <number ; i++) {
            String name = scanner.nextLine();
            List<String> grades = Arrays.asList(scanner.nextLine().split(" "));
            student.put(name, grades);
        }

        for (String key : student.keySet()) {
            double sum = 0;
            for (String gra : student.get(key)) {
                sum += Double.parseDouble(gra);
            }
            double average = sum/student.get(key).size();
            System.out.println(key + " is graduated with " + average);
        }

    }

}
