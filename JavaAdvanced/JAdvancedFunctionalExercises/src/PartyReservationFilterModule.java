import java.util.*;
import java.util.function.Predicate;

public class PartyReservationFilterModule {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] inputNames = scanner.nextLine().split(" ");

        List<String> names = new LinkedList<>(Arrays.asList(inputNames));
        Map<String, Set<String>> filters = new HashMap<>();

        Predicate<String> isAdd = value ->value.equals("Add filter");

        while(true){
            String[] filter = scanner.nextLine().split(";");
            String filterStatus = filter[0];
            if (filterStatus.equals("Print")){
                break;
            }
            addFilterOperations(filters, filter, isAdd);
        }
        applyFilters(filters, names);
        System.out.println(Arrays.toString(names.toArray()).replace("]", "").replace("[", "").replace(",", ""));
    }

    private static void applyFilters(Map<String, Set<String>> filters, List<String> names) {
        for (Map.Entry<String, Set<String>> type: filters.entrySet()) {
            switch (type.getKey()){
                case "Starts with":
                    type.getValue().forEach( element -> names.removeIf((string) -> (string).startsWith(element)));
                    break;
                case "Ends with":
                    type.getValue().forEach( element -> names.removeIf((string) -> (string).endsWith(element)));
                    break;
                case "Length":
                    type.getValue().forEach( element -> names.removeIf((string) -> (string).length()==Integer.parseInt(element)));
                    break;
                case "Contains":
                    type.getValue().forEach( element -> names.removeIf((string) -> (string).contains(element)));
                    break;
            }
        }
    }

    private static void addFilterOperations(Map<String, Set<String>> filters, String[] filter, Predicate<String> isAdd) {
        String filterType = filter[1];
        if (isAdd.test(filter[0])){
            if (!filters.containsKey(filterType)){
                Set<String> filterValues = new LinkedHashSet<>();
                filters.put(filterType, filterValues);
            }
            filters.get(filterType).add(filter[2]);
        } else {
            filters.get(filterType).remove(filter[2]);
        }
    }

}
