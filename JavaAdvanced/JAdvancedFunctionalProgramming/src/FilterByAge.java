import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> students = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <n ; i++) {
            String[] nameAge = scanner.nextLine().split(", ");
            students.put(nameAge[0], Integer.parseInt(nameAge[1]));
        }



        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> testBorderAge = testAge(condition, age);
        Consumer<Map.Entry<String,Integer>> printer = createPrinter(format);
        printStudents(students, testBorderAge, printer);
    }

    private static void printStudents(LinkedHashMap<String, Integer> students, Predicate<Integer> testBorderAge, Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : students.entrySet()) {
            if (testBorderAge.test(person.getValue())){
                printer.accept(person);
            }
        }
    }


    private static Consumer<Map.Entry<String,Integer>> createPrinter(String format) {
        switch(format){
            case "name":
                return person-> System.out.println(person.getKey());
            case "age":
                return person-> System.out.println(person.getValue());
        }
        return person-> System.out.println(person.getKey() + " - " + person.getValue());
    }

    private static Predicate<Integer> testAge(String condition, int age) {
        if (condition.equalsIgnoreCase("younger")){
            return x -> x <= age;
        }
        return x->x >= age;
    }

}
