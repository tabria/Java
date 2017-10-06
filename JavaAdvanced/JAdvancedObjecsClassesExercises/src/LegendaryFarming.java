import com.sun.corba.se.spi.orbutil.proxy.LinkedInvocationHandler;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyResources = new TreeMap<>();
        TreeMap<String, Integer> junkResources = new TreeMap<>();
        String[] legendaryInfo = new String[]{"empty"};

        while(legendaryInfo[0].equals("empty")){
            String[] rawMaterials = scanner.nextLine().split(" ");
            collectResources(keyResources, junkResources, rawMaterials, legendaryInfo);
        }

        addMissingKeyResources(keyResources);

        LinkedHashMap<String, Integer> sortKeyResourcesByValueDesc = keyResources.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println(legendaryInfo[0] + " obtained!");

        for (String sMaterial : sortKeyResourcesByValueDesc.keySet()) {
            System.out.println(sMaterial + ": " + sortKeyResourcesByValueDesc.get(sMaterial));
        }
        for (Map.Entry<String, Integer> jMaterial : junkResources.entrySet()) {
            System.out.println(jMaterial.getKey() + ": " + jMaterial.getValue());
        }


    }

    private static void addMissingKeyResources(TreeMap<String, Integer> keyResources) {
        if (!keyResources.containsKey("shards")){
            keyResources.put("shards", 0);
        }
        if (!keyResources.containsKey("motes")){
            keyResources.put("motes", 0);
        }
        if (!keyResources.containsKey("fragments")){
            keyResources.put("fragments", 0);
        }

    }

    private static void collectResources(Map<String, Integer> keyResources, Map<String, Integer> junkResources, String[] rawMaterials, String[] legendaryInfo) {
        for (int i = 1; i <rawMaterials.length ; i+=2) {
            String material = rawMaterials[i].toLowerCase();
            int quantity = Integer.parseInt(rawMaterials[i-1]);
            if (material.equalsIgnoreCase("Shards") || material.equalsIgnoreCase("Fragments") || material.equalsIgnoreCase("Motes")){
                fillResources(keyResources, legendaryInfo, material, quantity);
                if (!legendaryInfo[0].equals("empty")){
                    acquireLegendaryItem(keyResources, legendaryInfo);
                    break;
                }
            } else {
                fillResources(junkResources, legendaryInfo, material, quantity);
            }
        }
    }

    private static void acquireLegendaryItem(Map<String, Integer> keyResources, String[] legendaryInfo) {
        int legendaryQuantity = Math.abs(keyResources.get(legendaryInfo[0]) - 250);
        keyResources.put(legendaryInfo[0], legendaryQuantity);

        if (legendaryInfo[0].equalsIgnoreCase("Shards")){
            legendaryInfo[0] = "Shadowmourne";
        } else if (legendaryInfo[0].equalsIgnoreCase("Fragments")) {
            legendaryInfo[0] = "Valanyr";
        } else if (legendaryInfo[0].equalsIgnoreCase("Motes")) {
            legendaryInfo[0] = "Dragonwrath";
        }
    }

    private static void fillResources(Map<String, Integer> resources, String[] legendaryInfo, String material, int quantity) {
        if (resources.containsKey(material)){
            quantity += resources.get(material);
        }
        isLegendaryGained(legendaryInfo, material, quantity);
        resources.put(material, quantity);
    }

    private static void isLegendaryGained(String[] legendaryInfo, String material, int quantity) {
        if (quantity >= 250){
            if (material.equalsIgnoreCase("Shards") || material.equalsIgnoreCase("Fragments") || material.equalsIgnoreCase("Motes")) {
                legendaryInfo[0] = material;
            }
        }
    }

}
