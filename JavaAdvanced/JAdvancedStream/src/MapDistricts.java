import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MapDistricts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<Integer>> towns = new HashMap<>();
        List<String> districts = Arrays.asList(scanner.nextLine().split("\\s+"));
        int boundary = Integer.parseInt(scanner.nextLine());

        for (String district : districts) {
            String[] token= district.split(":");
            String city = token[0];
            Integer population = Integer.parseInt(token[1]);

            towns.putIfAbsent(city, new ArrayList<>());
            towns.get(city).add(population);
        }

        towns.entrySet().stream().filter(filterBySum(boundary)).sorted(citiesByDesc()).forEach(print());


    }

    private static Consumer<? super Map.Entry<String,List<Integer>>> print() {

        return kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream().sorted((x1, x2) -> x2.compareTo(x1)).limit(5).forEach(dist -> System.out.print(dist + " "));
            System.out.println();
        };

    }

    private static Comparator<? super Map.Entry<String,List<Integer>>> citiesByDesc() {
        return (kv1, kv2) -> Integer.compare
                (kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        kv1.getValue().stream().mapToInt(Integer::valueOf).sum());

    }

    private static Predicate<Map.Entry<String,List<Integer>>> filterBySum(int boundary) {

        return kv -> kv.getValue().stream().mapToInt(Integer::valueOf).sum() >= boundary;
    }

}
