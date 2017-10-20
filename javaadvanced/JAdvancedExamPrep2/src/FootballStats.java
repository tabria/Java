import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, List<String>>> teamStats = new HashMap<>();

        while(true){
            String[] game = reader.readLine().split("\\s+-\\s+|\\s+result\\s+|:");
            if ("Season End".equals(game[0].trim())){
                break;
            }

            String hostName = game[0];
            String visitorName = game[1];
            String hostGoals = game[2];
            String visitorGoals = game[3];

            addGameToStat(teamStats, hostName, visitorName, hostGoals, visitorGoals);
            addGameToStat(teamStats, visitorName, hostName, visitorGoals, hostGoals);
        }

        String[] teamsToShow = reader.readLine().split(", ");
        for (int i = 0; i <teamsToShow.length ; i++) {
            String team = teamsToShow[i];

            teamStats.get(team).entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).forEach(v-> {
                v.getValue().stream().forEach(res -> {
                    System.out.println(team + " - " + v.getKey() + " -> " + res);
                });
            });
        }
    }

    private static void addGameToStat(Map<String, Map<String, List<String>>> teamStats, String hostName, String visitorName, String hostGoals, String visitorGoals) {
        teamStats.putIfAbsent(hostName, new HashMap<>());
        teamStats.get(hostName).putIfAbsent(visitorName, new ArrayList<>());
        teamStats.get(hostName).get(visitorName).add(hostGoals + ":" + visitorGoals);
    }
}
