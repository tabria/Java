    import java.util.Arrays;
    import java.util.Optional;
    import java.util.Scanner;
    public class FindAndSumIntegers {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Optional<Integer> optI = Arrays.stream(scanner.nextLine().split("\\s+")).filter(x-> isNumber(x)).map(Integer::valueOf).reduce((x1, x2) ->x1 +x2);

            if (optI.isPresent()){
                System.out.println(optI.get());
            } else {
                System.out.println("No match");
            }
        }

        private static boolean isNumber(String x) {

            return !x.isEmpty() && x.matches("[-]?\\d");

        }

    }
