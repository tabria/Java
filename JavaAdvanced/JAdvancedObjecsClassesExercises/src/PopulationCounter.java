import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> populationStatistic = new LinkedHashMap<>();

        while (true){
            String[] rawInfo = scanner.nextLine().split("[|]");
            if (rawInfo[0].equals("report")){
                break;
            }
            String country = rawInfo[1];
            String city = rawInfo[0];
            long population = Long.parseLong(rawInfo[2]);
            if(!populationStatistic.containsKey(country)){
                LinkedHashMap<String, Long> cityPopulation = new LinkedHashMap<>();
                populationStatistic.put(country, cityPopulation);
            }
            populationStatistic.get(country).put(city, population);
        }

        LinkedHashMap<String, Long> resultByTowns = new LinkedHashMap<>();
        for (String popCountry: populationStatistic.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(popCountry);
            sb.append(" (total population: replaceHere)\r\n");
            LinkedHashMap<String, Long> sortByTownPop = populationStatistic.get(popCountry).entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            long population = 0;
            for (String town:sortByTownPop.keySet()) {
               long townPopulation= populationStatistic.get(popCountry).get(town);
               population += townPopulation;
               sb.append("=>");
               sb.append(town);
               sb.append(": ");
               sb.append(townPopulation);
               sb.append("\r\n");
            }
            sb.delete(sb.length()-2, sb.length());
            String result = sb.toString().replace("replaceHere", String.valueOf(population));
            resultByTowns.put(result, population);
        }

        LinkedHashMap<String, Long> resultByCountry = resultByTowns.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                                                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String country : resultByCountry.keySet()) {
            System.out.println(country);
        }
    }

}
