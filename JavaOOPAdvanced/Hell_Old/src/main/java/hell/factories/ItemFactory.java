package hell.factories;

import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

public final class ItemFactory {

    public static Item createCommonItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus){
        return new CommonItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }

    public static Recipe createRecipe(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String... params){
        return new RecipeItem(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus, params);
    }



}
