
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class VLogger {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, TreeSet<String>> vloggerFollowers = new LinkedHashMap<>();
        Map<String, TreeSet<String>> vloggerFollow = new LinkedHashMap<>();

        addVlogersStat(vloggerFollow, vloggerFollowers, reader);
        System.out.printf("The V-Logger has a total of %s vloggers in its logs.%n", vloggerFollowers.size());

        LinkedHashMap<String, TreeSet<String>> sortedMap = vloggerFollowers.entrySet().stream()
                .sorted(sortVloggers(vloggerFollow)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        boolean isFirst = false;
        int count = 1;
        for (String vlogger : sortedMap.keySet()) {
            if(!isFirst){
                System.out.println(count + ". " + vlogger + " : " + vloggerFollowers.get(vlogger).size() + " followers, " + vloggerFollow.get(vlogger).size() + " following");
                for(String entry : vloggerFollowers.get(vlogger)) {
                    System.out.println("*  " + entry);
                }
                isFirst = true;
                count++;
            } else {
                System.out.println(count + ". " + vlogger + " : " + vloggerFollowers.get(vlogger).size() + " followers, " + vloggerFollow.get(vlogger).size() + " following");
                count++;
            }
        }
    }

    private static Comparator<Map.Entry<String,TreeSet<String>>> sortVloggers(Map<String, TreeSet<String>> vloggerFollow) {
        return (x, y) -> {
            int followersSizeX = x.getValue().size();
            int followersSizeY = y.getValue().size();
            if (followersSizeX == followersSizeY){
                int followX = vloggerFollow.get(x.getKey()).size();
                int followY =  vloggerFollow.get(y.getKey()).size();
                return Integer.compare(followX, followY);
            }
            return Integer.compare(followersSizeY, followersSizeX);
        };
    }

    private static void addVlogersStat(Map<String, TreeSet<String>> vloggerFollow, Map<String, TreeSet<String>> vloggerFollowers, BufferedReader reader) throws IOException {
        while(true){
            String[] currentVlogger = reader.readLine().split("\\s+");
            String followerName =currentVlogger[0];
            if ("Statistics".equals(followerName)){
                break;
            }
            String command = currentVlogger[1];
            if ("joined".equals(command)){
                vloggerFollowers.putIfAbsent(followerName, new TreeSet<String>());
                vloggerFollow.putIfAbsent(followerName, new TreeSet<String>());
            }else if ("followed".equals(command)){
                String vloggerName = currentVlogger[2];
                if (!vloggerName.equals(followerName) && vloggerFollowers.containsKey(vloggerName) && vloggerFollowers.containsKey(followerName)){
                    vloggerFollowers.get(vloggerName).add(followerName);
                    vloggerFollow.get(followerName).add(vloggerName);
                }
            }
        }
    }
}
