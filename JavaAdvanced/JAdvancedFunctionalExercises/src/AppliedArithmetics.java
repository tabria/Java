import java.util.*;
import java.util.function.Predicate;

public class AppliedArithmetics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (true){
            String input = scanner.nextLine();
            if("end".equals(input)){
                break;
            }
            switch (input){
                case "print":System.out.println(Arrays.toString(inputNumbers).replace("]","").replace("[","").replace(",",""));break;
                case "add": inputNumbers = Arrays.stream(inputNumbers).map(a -> a + 1 ).toArray();break;
                case "multiply" : inputNumbers = Arrays.stream(inputNumbers).map(a -> a * 2 ).toArray();break;
                case "subtract" : inputNumbers = Arrays.stream(inputNumbers).map(a -> a - 1 ).toArray();break;
            }
        }

    }


}
