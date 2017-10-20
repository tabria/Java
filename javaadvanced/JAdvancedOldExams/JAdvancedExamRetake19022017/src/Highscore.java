import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Highscore {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> playersInfo = new LinkedHashMap<>();
        Map<String, List<String>> battles = new HashMap<>();

        while(true){
            String[] duel = reader.readLine().split("<->|\\s+");
            if ("osu!".equals(duel[0])){
                break;
            }
            String firstPlayerName = duel[1];
            String secondPlayerName = duel[2];
            Long firstPlayerScore = Long.parseLong(duel[0]);
            Long secondPlayerScore = Long.parseLong(duel[3]);

            fillInfo(playersInfo, battles, firstPlayerName, secondPlayerName, firstPlayerScore, secondPlayerScore);
            fillInfo(playersInfo, battles, secondPlayerName, firstPlayerName, secondPlayerScore, firstPlayerScore);
        }

        playersInfo.entrySet().stream().sorted((x, y) -> y.getValue().compareTo(x.getValue())).forEach(kv -> {
            System.out.println(kv.getKey() + " - (" + kv.getValue() + ")");
            battles.get(kv.getKey()).forEach(s-> System.out.println(s));
        });

    }

    private static void fillInfo(Map<String, Long> playersInfo, Map<String, List<String>> battles, String firstPlayerName, String secondPlayerName, Long firstPlayerScore, Long secondPlayerScore) {

        playersInfo.putIfAbsent(firstPlayerName, 0L);
        playersInfo.put(firstPlayerName, playersInfo.get(firstPlayerName) + firstPlayerScore - secondPlayerScore);
        battles.putIfAbsent(firstPlayerName, new ArrayList<>());
        StringBuilder sb = new StringBuilder();
        sb.append("*   ")
                .append(secondPlayerName)
                .append(" <-> ")
                .append(firstPlayerScore-secondPlayerScore);
        battles.get(firstPlayerName).add(sb.toString());
    }
}
