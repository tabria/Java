package test;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class HeroInventoryTest {

    private static final String RECIPE_ITEMS_NAME = "recipeItems";
    private static final int DEFAULT_BIG_VALUE = 1000000000;


    private Inventory inventory;
    private Item itemMock1;
    private Item itemMock2;
    private Item itemMock3;

    @Before
    public void initialize(){

        this.inventory = new HeroInventory();
        this.itemMock1 = Mockito.mock(Item.class);
        Mockito.when(this.itemMock1.getName()).thenReturn("Name1");
        this.itemMock2 = Mockito.mock(Item.class);
        Mockito.when(this.itemMock2.getName()).thenReturn("Name2");
        this.itemMock3 = Mockito.mock(Item.class);
        Mockito.when(this.itemMock3.getName()).thenReturn("Name3");


    }


    @Test
    public void mustAddCorrectCommonItem() {
        Mockito.when(this.itemMock1.getDamageBonus()).thenReturn(1);
        Mockito.when(this.itemMock2.getDamageBonus()).thenReturn(2);
        Mockito.when(this.itemMock3.getDamageBonus()).thenReturn(3);

        this.inventory.addCommonItem(this.itemMock1);
        this.inventory.addCommonItem(this.itemMock2);
        this.inventory.addCommonItem(this.itemMock3);

        int expected = 6;

        Assert.assertEquals("Do not add items correctly", expected, this.inventory.getTotalDamageBonus());

    }

    @Test
    public void addRecipeItem() throws NoSuchFieldException, IllegalAccessException {
        Recipe recipeItemMock1 = Mockito.mock(Recipe.class);
        Mockito.when(recipeItemMock1.getName()).thenReturn("Name1");

        Recipe recipeItemMock2 = Mockito.mock(Recipe.class);
        Mockito.when(recipeItemMock2.getName()).thenReturn("Name2");

        Recipe recipeItemMock3 = Mockito.mock(Recipe.class);
        Mockito.when(recipeItemMock3.getName()).thenReturn("Name3");

        this.inventory.addRecipeItem(recipeItemMock1);
        this.inventory.addRecipeItem(recipeItemMock2);
        this.inventory.addRecipeItem(recipeItemMock3);

        Field recipeItemField = this.inventory.getClass().getDeclaredField(RECIPE_ITEMS_NAME);
        recipeItemField.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemField.get(this.inventory);

        int expected = 3;

        Assert.assertEquals("Do not add recipe item correctly", expected, recipeItems.size());

    }

    @Test
    public void combineRecipeItemsIntoNewCommonItem() throws NoSuchFieldException, IllegalAccessException {

        List<String> requiredItemsMocks = new ArrayList<String>(){{
           add(itemMock1.getName());
           add(itemMock2.getName());
        }};


        this.inventory.addCommonItem(this.itemMock2);
        this.inventory.addCommonItem(this.itemMock3);

        Recipe recipeItemMock1 = Mockito.mock(Recipe.class);
        Mockito.when(recipeItemMock1.getName()).thenReturn("RecipeName1");
        Mockito.when(recipeItemMock1.getStrengthBonus()).thenReturn(1);
        Mockito.when(recipeItemMock1.getAgilityBonus()).thenReturn(2);
        Mockito.when(recipeItemMock1.getIntelligenceBonus()).thenReturn(3);
        Mockito.when(recipeItemMock1.getHitPointsBonus()).thenReturn(4);
        Mockito.when(recipeItemMock1.getDamageBonus()).thenReturn(5);

        Mockito.when(recipeItemMock1.getRequiredItems()).thenReturn(requiredItemsMocks);


        int expected = 2;

        this.inventory.addRecipeItem(recipeItemMock1);
        this.inventory.addCommonItem(this.itemMock1);
        Field commonItemsField = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemsField.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) commonItemsField.get(this.inventory);


        Assert.assertEquals("Do not add recipe item correctly", expected, commonItems.size());

    }


    @Test
    public void getTotalStrengthBonusToReturnLong() {
        Mockito.when(this.itemMock1.getStrengthBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock2.getStrengthBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock3.getStrengthBonus()).thenReturn(DEFAULT_BIG_VALUE);

        this.inventory.addCommonItem(this.itemMock1);
        this.inventory.addCommonItem(this.itemMock2);
        this.inventory.addCommonItem(this.itemMock3);

        long expected = 3L*DEFAULT_BIG_VALUE;

        Assert.assertEquals("The return value is not of type long", expected, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonusToReturnLong() {

        Mockito.when(this.itemMock1.getAgilityBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock2.getAgilityBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock3.getAgilityBonus()).thenReturn(DEFAULT_BIG_VALUE);

        this.inventory.addCommonItem(this.itemMock1);
        this.inventory.addCommonItem(this.itemMock2);
        this.inventory.addCommonItem(this.itemMock3);

        long expected = 3L*DEFAULT_BIG_VALUE;

        Assert.assertEquals("The return value is not of type long", expected, this.inventory.getTotalAgilityBonus());

    }

    @Test
    public void getTotalIntelligenceBonusToReturnLong() {
        Mockito.when(this.itemMock1.getIntelligenceBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock2.getIntelligenceBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock3.getIntelligenceBonus()).thenReturn(DEFAULT_BIG_VALUE);

        this.inventory.addCommonItem(this.itemMock1);
        this.inventory.addCommonItem(this.itemMock2);
        this.inventory.addCommonItem(this.itemMock3);

        long expected = 3L*DEFAULT_BIG_VALUE;

        Assert.assertEquals("The return value is not of type long", expected, this.inventory.getTotalIntelligenceBonus());

    }

    @Test
    public void getTotalHitPointsBonusToReturnLong() {
        Mockito.when(this.itemMock1.getHitPointsBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock2.getHitPointsBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock3.getHitPointsBonus()).thenReturn(DEFAULT_BIG_VALUE);

        this.inventory.addCommonItem(this.itemMock1);
        this.inventory.addCommonItem(this.itemMock2);
        this.inventory.addCommonItem(this.itemMock3);

        long expected = 3L*DEFAULT_BIG_VALUE;

        Assert.assertEquals("The return value is not of type long", expected, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonusToReturnLong() {
        Mockito.when(this.itemMock1.getDamageBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock2.getDamageBonus()).thenReturn(DEFAULT_BIG_VALUE);
        Mockito.when(this.itemMock3.getDamageBonus()).thenReturn(DEFAULT_BIG_VALUE);

        this.inventory.addCommonItem(this.itemMock1);
        this.inventory.addCommonItem(this.itemMock2);
        this.inventory.addCommonItem(this.itemMock3);

        long expected = 3L*DEFAULT_BIG_VALUE;

        Assert.assertEquals("The return value is not of type long", expected, this.inventory.getTotalDamageBonus());
    }



}