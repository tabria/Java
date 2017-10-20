import java.util.*;
import java.util.function.Consumer;

public class Task4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, HashMap<String, List<String>>> teamStats = new HashMap<>();

        while(true) {
            String[] currentMatch = scanner.nextLine().split(" - | result |:");
            String hostTeam = currentMatch[0];
            if ("Season End".equals(hostTeam)){
                break;
            }
            String result = currentMatch[2] + ":" + currentMatch[3];
            fillStatistic(teamStats, hostTeam, currentMatch[1], result);
            result = currentMatch[3] + ":" + currentMatch[2];
            fillStatistic(teamStats, currentMatch[1], hostTeam, result);
        }

        String[] showTeams = scanner.nextLine().split(", ");

        for (int i = 0; i <showTeams.length ; i++) {
            String currentTeam = showTeams[i];
            teamStats.get(currentTeam).entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).forEach(print(currentTeam));
        }
    }

    private static Consumer<Map.Entry<String, List<String>>> print(String currentTeam) {
        return kv -> {
            kv.getValue().stream().forEach(res -> {
                System.out.print(currentTeam + " - " + kv.getKey() + " -> " + res);
                System.out.println();
            });
        };
    }

    private static void fillStatistic(Map<String, HashMap<String, List<String>>> teamStats, String hostTeam, String oppositeTeam, String result) {
        teamStats.putIfAbsent(hostTeam, new HashMap<>());
        teamStats.get(hostTeam).putIfAbsent(oppositeTeam, new ArrayList<>());
        teamStats.get(hostTeam).get(oppositeTeam).add(result);
    }
}
