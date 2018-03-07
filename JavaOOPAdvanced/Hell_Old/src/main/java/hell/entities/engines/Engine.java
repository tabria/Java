package hell.entities.engines;

import hell.factories.ItemFactory;
import hell.factories.HeroFactory;
import hell.interfaces.Hero;
import hell.interfaces.InputReader;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private static final String TERMINATING_COMMAND = "Quit";
    private static final int HERO_STAT_QUANTITY = 5;

    private InputReader reader;
    private OutputWriter writer;
    private Map<String, Hero> createdHeroes;

    public Engine(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.createdHeroes = new LinkedHashMap<>();
    }

    @Override
    public void run() {

        try {
            while(true){

                String[] inputCommand = this.reader.readLine().split("\\s+");
                this.dispatcher(inputCommand);

                if(TERMINATING_COMMAND.equals(inputCommand[0])){
                    break;
                }
            }
        } catch (IOException | InstantiationException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

    private void dispatcher(String[] inputCommand) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String command = inputCommand[0];
        switch(command){
            case "Hero":
                this.writer.writeLine(this.heroCommand(inputCommand));
                break;
            case "Item":
                this.writer.writeLine(this.itemCommand(inputCommand));
                break;
            case "Recipe":
                this.writer.writeLine(this.recipeCommand(inputCommand));
                break;
            case "Inspect":
                this.writer.writeLine(this.inspectHero(inputCommand[1]));
                break;
            case "Quit":
                this.writer.writeLine(this.quitCommand());
                break;
        }

    }

    private String heroCommand(String[] input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String heroName = input[1];
        String heroType = input[2];
        this.createdHeroes.put(heroName, HeroFactory.createHero(heroName, heroType));
        return String.format("Created %s - %s", heroType, heroName);
    }

    private String itemCommand(String[] input){
        String heroName = input[2];
        if (this.createdHeroes.containsKey(heroName)){
            String itemName = input[1];
            int strengthBonus = Integer.parseInt(input[3]);
            int agilityBonus = Integer.parseInt(input[4]);
            int intelligenceBonus = Integer.parseInt(input[5]);
            int hitPointsBonus = Integer.parseInt(input[6]);
            int damageBonus = Integer.parseInt(input[7]);
            this.createdHeroes.get(heroName).addItem(ItemFactory.createCommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus));
            return String.format("Added item - %s to Hero - %s", itemName, heroName);
        }
        return "";
    }

    private String recipeCommand(String[] input){
        String[] requiredItems = Arrays.copyOfRange(input, 8, input.length);
        String heroName = input[2];
        if (this.createdHeroes.containsKey(heroName)){
            String itemName = input[1];
            int strengthBonus = Integer.parseInt(input[3]);
            int agilityBonus = Integer.parseInt(input[4]);
            int intelligenceBonus = Integer.parseInt(input[5]);
            int hitPointsBonus = Integer.parseInt(input[6]);
            int damageBonus = Integer.parseInt(input[7]);
            this.createdHeroes.get(heroName).addRecipe(ItemFactory.createRecipe(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, requiredItems));
            return String.format("Added recipe - %s to Hero - %s", itemName, heroName);
        }
        return "";
    }

    private String inspectHero(String heroName){
        if (!this.createdHeroes.containsKey(heroName)){
            return "";
        }

        Hero currentHero = this.createdHeroes.get(heroName);

        StringBuilder itemBuilder = new StringBuilder();
        itemBuilder.append(String.format("Items:"));
        try {
            List<Item> heroItems = (List<Item>) currentHero.getItems();
            if (heroItems.size() == 0){
                itemBuilder.append(" None");
            } else {
                itemBuilder.append(System.lineSeparator());
                for (Item item:heroItems) {
                    itemBuilder.append(item);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Class: %s\r\n", currentHero.getName(), currentHero.getClass().getSimpleName()))
                .append(String.format("HitPoints: %d, Damage: %s\r\n", currentHero.getHitPoints(), currentHero.getDamage()))
                .append(String.format("Strength: %d\r\n", currentHero.getStrength()))
                .append(String.format("Agility: %d\r\n", currentHero.getAgility()))
                .append(String.format("Intelligence: %d\r\n", currentHero.getIntelligence()))
                .append(itemBuilder.toString().trim());

        return sb.toString();
    }

    private String quitCommand(){
        Map<String, Hero> sortedHeroes =  this.createdHeroes.entrySet().stream()
                .sorted((kv1, kv2) -> orderValues(kv1.getValue(), kv2.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (Map.Entry<String, Hero> heroSet:sortedHeroes.entrySet()) {
            Hero currentHero = heroSet.getValue();
            String heroType = currentHero.getClass().getSimpleName();
            String heroName = currentHero.getName();

            StringBuilder itemBuilder = new StringBuilder();
            String separator ="";
            try {
                List<Item> heroItems = (List<Item>) currentHero.getItems();
                if (heroItems.size() == 0){
                    itemBuilder.append("None");
                } else {
                    for (Item item:heroItems) {
                        itemBuilder.append(separator).append(item.getName());
                        separator = ", ";
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            sb.append(String.format("%d. %s: %s\r\n", counter, heroType,heroName))
                    .append(String.format("###HitPoints: %d\r\n", currentHero.getHitPoints()))
                    .append(String.format("###Damage: %d\r\n", currentHero.getDamage()))
                    .append(String.format("###Strength: %d\r\n", currentHero.getStrength()))
                    .append(String.format("###Agility: %d\r\n", currentHero.getAgility()))
                    .append(String.format("###Intelligence: %d\r\n", currentHero.getIntelligence()))
                    .append(String.format("###Items: %s\r\n", itemBuilder));
            counter++;
        }

        return sb.toString().trim();
    }

    private int orderValues(Hero hero1, Hero hero2) {
        long hero1SumPoints = hero1.getStrength() + hero1.getAgility() + hero1.getIntelligence();
        long hero2SumPoints = hero2.getStrength() + hero2.getAgility() + hero2.getIntelligence();
        if (hero1SumPoints == hero2SumPoints){
            long hero1SumPoints2 = hero1.getHitPoints() + hero1.getDamage();
            long hero2SumPoints2 = hero2.getHitPoints() + hero2.getDamage();
            if (hero1SumPoints2 == hero2SumPoints2){
                return 0;
            } else if (hero1SumPoints2 > hero2SumPoints2){
                return -1;
            } else {
                return 1;
            }

        } else if (hero1SumPoints > hero2SumPoints) {
            return -1;
        } else {
            return 1;
        }
    }
}
