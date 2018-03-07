package hell.entities.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.factories.InventoryFactory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    protected BaseHero(String name, long strength, long agility, long intelligence, long hitPoints, long damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = InventoryFactory.createInventory();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getStrength() {
        long heroStrength = this.strength;
        try {
            List<Item> heroItems = (List<Item>) this.getItems();
            if (heroItems.size() != 0){
                for (Item item:heroItems) {
                    heroStrength += item.getStrengthBonus();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return heroStrength;
    }

    @Override
    public long getAgility() {
        long heroAgility = this.agility;
        try {
            List<Item> heroItems = (List<Item>) this.getItems();
            if (heroItems.size() != 0){
                for (Item item:heroItems) {
                    heroAgility += item.getAgilityBonus();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return heroAgility;
    }

    @Override
    public long getIntelligence() {
        long heroIntelligence = this.intelligence;
        try {
            List<Item> heroItems = (List<Item>) this.getItems();
            if (heroItems.size() != 0){
                for (Item item:heroItems) {
                    heroIntelligence += item.getIntelligenceBonus();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return heroIntelligence;
    }

    @Override
    public long getHitPoints() {
        long heroHitPoints = this.hitPoints;
        try {
            List<Item> heroItems = (List<Item>) this.getItems();
            if (heroItems.size() != 0){
                for (Item item:heroItems) {
                    heroHitPoints += item.getHitPointsBonus();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return heroHitPoints;
    }

    @Override
    public long getDamage() {
        long heroDamage = this.damage;
        try {
            List<Item> heroItems = (List<Item>) this.getItems();
            if (heroItems.size() != 0){
                for (Item item:heroItems) {
                    heroDamage += item.getDamageBonus();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return heroDamage;
    }

    //reflection
    public Collection<Item> getItems() throws IllegalAccessException {
        List<Item> heroItems = new ArrayList<>();
        Field[] fields = this.inventory.getClass().getDeclaredFields();
        for (Field field:fields) {
            if (field.isAnnotationPresent(ItemCollection.class)){
                field.setAccessible(true);
                Map<String, Item> commonItemsMap = (Map<String, Item>) field.get(this.inventory);
                for (Map.Entry<String, Item> itemSet:commonItemsMap.entrySet()) {
                    heroItems.add(itemSet.getValue());
                }
                break;
            }
        }
        return heroItems;
    }

    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    public void addRecipe(Recipe recipe){
        this.inventory.addRecipeItem(recipe);

    }
}
