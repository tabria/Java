package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecipeItem extends BaseItem implements Recipe {

    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, String... params) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.setRequiredItems(params);
    }

    private void setRequiredItems(String... params){
        this.requiredItems = new ArrayList<>();
        this.requiredItems.addAll(Arrays.asList(params));
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.requiredItems);
    }
}
