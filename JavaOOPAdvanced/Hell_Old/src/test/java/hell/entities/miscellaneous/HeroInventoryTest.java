package hell.entities.miscellaneous;


import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroInventoryTest {


    private static final String COMMON_ITEM_MOCK_NAME = "MockItem%d";
    private static final int COMMON_ITEM_MOCK__VALUE = 1000000000;
    private static final String REQUIRED_ITEM_1 = "Knife";

    private Inventory inventory;

    @Before
    public void initHero(){
        this.inventory = new HeroInventory();
    }

    @Test
    public void testGetTotalStrengthBonusToReturnLong() throws Exception {
        //Arrange
        int mockObjctQuantity = 3;
        this.addItemsToCommonItems(mockObjctQuantity);
        long expected = ((long) COMMON_ITEM_MOCK__VALUE) * mockObjctQuantity;
        //Act

        //Assert
        Assert.assertEquals("getTotalStrengthBonus, do not return correct type", expected, this.inventory.getTotalStrengthBonus());

    }

    @Test
    public void testGetTotalAgilityBonusToReturnLong() throws Exception {
        //Arrange
        int mockObjctQuantity = 3;
        this.addItemsToCommonItems(mockObjctQuantity);
        long expected = ((long) COMMON_ITEM_MOCK__VALUE) * mockObjctQuantity;
        //Act

        //Assert
        Assert.assertEquals("getTotalAgilityBonus, do not return correct type", expected, this.inventory.getTotalAgilityBonus());

    }

    @Test
    public void testGetTotalIntelligenceBonusToReturnLong() throws Exception {
        //Arrange
        int mockObjctQuantity = 3;
        this.addItemsToCommonItems(mockObjctQuantity);
        long expected = ((long) COMMON_ITEM_MOCK__VALUE) * mockObjctQuantity;;
        //Act

        //Assert
        Assert.assertEquals("getTotalIntelligenceBonus, do not return correct type", expected, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonus() throws Exception {
        //Arrange
        int mockObjctQuantity = 3;
        this.addItemsToCommonItems(mockObjctQuantity);
        long expected = ((long) COMMON_ITEM_MOCK__VALUE) * mockObjctQuantity;;
        //Act

        //Assert
        Assert.assertEquals("getTotalHitPointsBonus, do not return correct type", expected, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void testGetTotalDamageBonustoReturnTest() throws Exception {
        //Arrange
        int mockObjctQuantity = 3;
        this.addItemsToCommonItems(mockObjctQuantity);
        long expected = ((long) COMMON_ITEM_MOCK__VALUE) * mockObjctQuantity;;
        //Act

        //Assert
        Assert.assertEquals("getTotalDamageBonus, do not return correct type", expected, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void testAddCommonItemToIncreaseCommonItemMapSize() throws Exception {
        //Arrange
        int mockObjctQuantity = 3;
        this.addItemsToCommonItems(mockObjctQuantity);
        Item commonItemMock4 = this.createMockCommonItem("Mock4", COMMON_ITEM_MOCK__VALUE);
        int expected =this.getCommonItem().size() + 1;
        //Act
        this.inventory.addCommonItem(commonItemMock4);
        //Assert
        Assert.assertEquals("AddCommonItem do not add Item properly", expected, this.getCommonItem().size());

    }

    @Test
    public void testAddCommonItemToCombineCommonItemsToRecipe() throws Exception {
        //Arrange
        int mockObjctQuantity = 3;
        int recipeMockObjectQuantity = 1;

        this.addItemsToCommonItems(mockObjctQuantity);

        List<String> requiredItems = new ArrayList<>();
        for (int i = 2; i <=mockObjctQuantity+1 ; i++) {
            requiredItems.add(String.format(COMMON_ITEM_MOCK_NAME, i));
        }
        addItemsToRecipeItems(recipeMockObjectQuantity, requiredItems);

        Item commonItemMock4 = this.createMockCommonItem(String.format(COMMON_ITEM_MOCK_NAME, mockObjctQuantity+1), COMMON_ITEM_MOCK__VALUE);

        int expected =this.getCommonItem().size() + 1 - mockObjctQuantity + recipeMockObjectQuantity;
        //Act
        this.inventory.addCommonItem(commonItemMock4);
        //Assert
        Assert.assertEquals("AddCommonItem do not combine commontItems into Recipe properly", expected, this.getCommonItem().size());

    }


    @Test
    public void testAddRecipeItemToIncreaseRecipeItemsMapSize() throws Exception {

        //Arrange
        List<String> requiredItems = new ArrayList<>();
        requiredItems.add(REQUIRED_ITEM_1);
        Recipe recipeItemMock1 = this.createMockRecipeItem("Mock4", COMMON_ITEM_MOCK__VALUE, requiredItems);
        int expected = this.getRecipeItem().size() + 1;
        //Act
        this.inventory.addRecipeItem(recipeItemMock1);
        //Assert
        Assert.assertEquals("addRecipeItem do not add recipie correctly", expected, this.getRecipeItem().size());

    }

//    @Test
//    public void testAddRecipeItemMustCombineCommonItemsToRecipe() throws Exception {
//
//        //Arrange
//        int mockObjctQuantity = 3;
//        this.addItemsToCommonItems(mockObjctQuantity);
//        List<String> requiredItems = new ArrayList<>();
//        for (int i = 1; i <=mockObjctQuantity ; i++) {
//            requiredItems.add(String.format(COMMON_ITEM_MOCK_NAME, i));
//        }
//
//        Recipe recipeItemMock1 = this.createMockRecipeItem("Mock4", COMMON_ITEM_MOCK__VALUE, requiredItems);
//        int expected = this.getCommonItem().size() - mockObjctQuantity + 1;
//        //Act
//        this.inventory.addRecipeItem(recipeItemMock1);
//        //Assert
//        Assert.assertEquals("addRecipeItem do not combine recipe correctly", expected, this.getCommonItem().size());
//
//    }



    private Field getCommonItemField() throws NoSuchFieldException {
        Field commonItemField = this.inventory.getClass().getDeclaredField("commonItems");
        commonItemField.setAccessible(true);
        return commonItemField;
    }

    private Field getRecipeItemField() throws NoSuchFieldException {
        Field recipeItemField = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItemField.setAccessible(true);
        return recipeItemField;
    }

    private Map<String, Item> getCommonItem() throws NoSuchFieldException, IllegalAccessException {
        Field commonItemField = this.getCommonItemField();
        Map<String, Item> commonItems = (Map<String, Item>) commonItemField.get(this.inventory);
        return commonItems;
    }

    private Map<String, Recipe> getRecipeItem() throws NoSuchFieldException, IllegalAccessException {
        Field recipeItemsField = this.getRecipeItemField();
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) recipeItemsField.get(this.inventory);
        return recipeItems;
    }


    private void addItemsToCommonItems(int mockObjectQuantity) throws NoSuchFieldException, IllegalAccessException {
        List<Item> mockedItems = new ArrayList<>();
        for (int i = 1; i <= mockObjectQuantity ; i++) {
            Item commonItemMock =  this.createMockCommonItem(String.format(COMMON_ITEM_MOCK_NAME,i),COMMON_ITEM_MOCK__VALUE);
            mockedItems.add(commonItemMock);
        }

        Map<String, Item> commonItems = this.getCommonItem();

        for (int i = 0; i < mockObjectQuantity ; i++) {
            commonItems.put(mockedItems.get(i).getName(), mockedItems.get(i));
        }

        this.getCommonItemField().set(this.inventory, commonItems);
    }


    private void addItemsToRecipeItems(int mockObjectQuantity, List<String> requiredItems) throws NoSuchFieldException, IllegalAccessException {
        List<Recipe> mockedItems = new ArrayList<>();
        for (int i = 1; i <= mockObjectQuantity ; i++) {
            Recipe recipeItemMock =  this.createMockRecipeItem("Mock4", COMMON_ITEM_MOCK__VALUE, requiredItems);
            mockedItems.add(recipeItemMock);
        }

        Map<String, Recipe> recipeItems = this.getRecipeItem();

        for (int i = 0; i < mockObjectQuantity ; i++) {
            recipeItems.put(mockedItems.get(i).getName(), mockedItems.get(i));
        }

        this.getRecipeItemField().set(this.inventory, recipeItems);
    }

    private Item createMockCommonItem(String name, int value) {
        Item commonItemMock1 = mock(Item.class);
        when(commonItemMock1.getName()).thenReturn(name);
        when(commonItemMock1.getStrengthBonus()).thenReturn(value);
        when(commonItemMock1.getAgilityBonus()).thenReturn(value);
        when(commonItemMock1.getIntelligenceBonus()).thenReturn(value);
        when(commonItemMock1.getHitPointsBonus()).thenReturn(value);
        when(commonItemMock1.getDamageBonus()).thenReturn(value);
        return commonItemMock1;
    }

    private Recipe createMockRecipeItem(String name, int value, List<String> requiredItems) {
        Recipe recipeItemMock1 = mock(Recipe.class);
        when(recipeItemMock1.getName()).thenReturn(name);
        when(recipeItemMock1.getStrengthBonus()).thenReturn(value);
        when(recipeItemMock1.getAgilityBonus()).thenReturn(value);
        when(recipeItemMock1.getIntelligenceBonus()).thenReturn(value);
        when(recipeItemMock1.getHitPointsBonus()).thenReturn(value);
        when(recipeItemMock1.getDamageBonus()).thenReturn(value);
        when(recipeItemMock1.getRequiredItems()).thenReturn(requiredItems);
        return recipeItemMock1;
    }

}