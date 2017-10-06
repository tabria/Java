import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class HandsOfCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> cardTypeValues = new HashMap<Character, Integer>()
        {{
            put('S', 4); put('H', 3); put('D', 2); put('C', 1);
        }};

        Map<String, HashSet<String>> game = new LinkedHashMap<>();
        fillHashMap(game, scanner);
        //Map<String, Integer> results = calculateResults(game, cardTypeValues);
        printResults(game, cardTypeValues);

    }


    private static void printResults(Map<String, HashSet<String>> game, Map<Character, Integer> cardTypeValues) {
        //Map<String, Integer> res = new HashMap<>();
        for (Map.Entry<String, HashSet<String>> element : game.entrySet()) {

            long sum = 0;
            for (String card : element.getValue()) {
                String rawCardValue = card.substring(0, card.length()-1);

                int cardValue = getCardValue(rawCardValue);
                int cardType = cardTypeValues.get(card.charAt(card.length()-1));
                sum += cardValue * cardType;
            }
            System.out.println(element.getKey() + ": " + sum);
        }
       // Map <String, Integer> result = res.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
       // return result;
    }

    private static int getCardValue(String rawCardValue) {
        switch(rawCardValue){
            case "J": rawCardValue = "11"; break;
            case "Q": rawCardValue = "12"; break;
            case "K": rawCardValue = "13"; break;
            case "A": rawCardValue = "14"; break;
        }
        return Integer.parseInt(rawCardValue);
    }

    private static void fillHashMap(Map<String, HashSet<String>> game, Scanner scanner) {
        while(true){
            String[] playerInfo = scanner.nextLine().trim().split(": ");
            String name = playerInfo[0];
            if (name.equals("JOKER")){
                break;
            }
            String[] inputCards = playerInfo[1].split(", ");
            HashSet<String> cards = new HashSet<>();
            if (!game.containsKey(name)){
                cards.addAll(Arrays.asList(inputCards));
            } else {
                cards = game.get(name);
                cards.addAll(Arrays.asList(inputCards));
            }
            game.put(name, cards);

        }
    }
}
