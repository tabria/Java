import java.util.*;
import java.util.function.Predicate;

public class InfernoIII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] gemsPowerInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, Predicate<Integer>> predicatesForExclude = new HashMap<>();

        while (true) {
            String[] command = scanner.nextLine().split(";");
            if ("Forge".equals(command[0])){
                break;
            }
            Predicate<Integer> condition = makePredicate (command[1], Integer.valueOf(command[2]), gemsPowerInput);
            switch (command[0]) {
                case "Exclude":
                    predicatesForExclude.put(command[1] + command[2], condition);
                    break;
                case "Reverse":
                    predicatesForExclude.remove(command[1] + command[2]);
                    break;
            }
        }

        for (int i = 0; i < gemsPowerInput.length; i++) {
            boolean found = false;
            for(Predicate<Integer> predicate : predicatesForExclude.values()){
                if(predicate.test(i)){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.print(gemsPowerInput[i] + " ");
            }
        }
    }

    private static Predicate<Integer> makePredicate(String condition, Integer targetSum, int[] inputArr) {
        switch (condition){
            case "Sum Left":
                return index -> (index > 0 ? inputArr[index - 1] : 0) + inputArr[index] == targetSum;
            case "Sum Right":
                return index -> (index < inputArr.length-1 ? inputArr[index + 1] : 0) + inputArr[index] == targetSum;
            default:
                return index -> (index > 0 ? inputArr[index - 1] : 0) + inputArr[index] +
                        (index < inputArr.length-1 ? inputArr[index + 1] : 0) == targetSum;
        }
    }
}
