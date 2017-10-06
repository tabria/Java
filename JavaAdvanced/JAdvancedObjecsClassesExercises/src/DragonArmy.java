import java.util.*;

public class DragonArmy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonsMegaStats = new LinkedHashMap<>();
        int cycles = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <cycles ; i++) {
            String[] dragonInfo = scanner.nextLine().split(" ");
            String dragonType = dragonInfo[0];
            String dragonName = dragonInfo[1];
            createDragonType(dragonsMegaStats, dragonType);
            createDragon(dragonsMegaStats, dragonType, dragonName);
            fillDragonStat(dragonsMegaStats, dragonInfo);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder dragonSb = new StringBuilder();
        for (String dType : dragonsMegaStats.keySet()) {
            double totalDamage = 0.0;
            double totalHealth = 0.0;
            double totalArmor = 0.0;
            int count = dragonsMegaStats.get(dType).size();
            dragonSb.setLength(0);
            for (String dName : dragonsMegaStats.get(dType).keySet()) {
                int damage = dragonsMegaStats.get(dType).get(dName).get(0);
                int health = dragonsMegaStats.get(dType).get(dName).get(1);
                int armor = dragonsMegaStats.get(dType).get(dName).get(2);

                totalDamage += damage;
                totalHealth += health;
                totalArmor += armor;

                dragonSb.append("-")
                        .append(dName)
                        .append(" -> damage: ")
                        .append(damage)
                        .append(", health: ")
                        .append(health)
                        .append(", armor: ")
                        .append(armor)
                        .append("\r\n");
            }
            sb.append(dType)
                    .append("::(")
                    .append(String.format("%.2f",totalDamage/count))
                    .append("/")
                    .append(String.format("%.2f", totalHealth/count))
                    .append("/")
                    .append(String.format("%.2f", totalArmor/count))
                    .append(")\r\n")
                    .append(dragonSb);
        }
        System.out.println(sb.toString().trim());
    }

    private static void fillDragonStat(LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonsMegaStats, String[] dragonInfo) {
        int count = 0;
        for (int j = 2; j <5 ; j++) {
            if (!dragonInfo[j].equalsIgnoreCase("null")){
                dragonsMegaStats.get(dragonInfo[0]).get(dragonInfo[1]).set(count, Integer.parseInt(dragonInfo[j]));
            }
            count++;
        }
    }

    private static void createDragon(LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonsMegaStats, String dragonType, String dragonName) {
        if (!dragonsMegaStats.containsKey(dragonsMegaStats.get(dragonType).get(dragonName))){
            ArrayList<Integer> dragonStat = new ArrayList<>();
            dragonStat.add(45);
            dragonStat.add(250);
            dragonStat.add(10);
            dragonsMegaStats.get(dragonType).put(dragonName, dragonStat);
        }
    }

    private static void createDragonType(LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonsMegaStats, String dragonType) {
        if (!dragonsMegaStats.containsKey(dragonType)){
            TreeMap<String, ArrayList<Integer>> dragonTypeMap = new TreeMap<>();
            dragonsMegaStats.put(dragonType, dragonTypeMap);
        }
    }
}
