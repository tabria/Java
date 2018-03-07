package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ModuleContainerTest {

    private static final int MODULE_CAPACITY_DEFAULT = 3;
    private static final int MODULE_QUANTITY = 1;

    private static final String MODULE_BY_INPUT_NAME = "modulesByInput";
    private static final String ENERGY_MODULE_NAME ="energyModules";
    private static final String ABSORBING_MODULE_NAME = "absorbingModules";

    private static final int ID_DEFAULT = 0;
    private static final int LONG_OUTPUT = 1000000000;


    private Container moduleContainer;
    private EnergyModule energyModuleMock;
    private AbsorbingModule absorbingModuleMock;
    private int id;

    @Before
    public void init() throws NoSuchFieldException {
        this.moduleContainer = new ModuleContainer(MODULE_CAPACITY_DEFAULT);
        this.energyModuleMock = mock(EnergyModule.class);
        this.absorbingModuleMock = mock(AbsorbingModule.class);
        this.id = ID_DEFAULT;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEnergyModuleWithNullEnergyModule() throws Exception {
        //Arrange
        this.energyModuleMock = null;

        //Action
        this.moduleContainer.addEnergyModule(this.energyModuleMock);
        //Assert
    }

//    @Test
//    public void testAddEnergyModuleWithMoreThanMaxCapacity() throws Exception {
//        //Arrange
//        addEnergyMocksToContainer(MODULE_CAPACITY_DEFAULT);
//        int expectedValue = 3;
//
//        //Action
//        this.moduleContainer.addEnergyModule(this.energyModuleMock);
//        int actual = getModuleByInputSize();
//
//        //Assert
//        Assert.assertEquals("AddEnergyModule do not delete item correctly", expectedValue, actual);
//    }

//    @Test
//    public void testAddEnergyModuleWithLessThanMaxCapacity() throws Exception {
//        //Arrange
//        addEnergyMocksToContainer(MODULE_QUANTITY);
//        int expectedValue = 2;
//
//        //Action
//        this.moduleContainer.addEnergyModule(this.energyModuleMock);
//        int actual = getModuleByInputSize();
//
//        //Assert
//        Assert.assertEquals("AddEnergyModule do not add item correctly", expectedValue, actual);
//    }

    @Test
    public void testAddEnergyModuleMoreThanMaxCapacityAddModuleInEnergyModuleMap() throws Exception {
        //Arrange
        addEnergyMocksToContainer(MODULE_CAPACITY_DEFAULT);
        int expectedValue = 3;

        //Action
        this.moduleContainer.addEnergyModule(this.energyModuleMock);
        int actual = getModuleModuleSize(ENERGY_MODULE_NAME);

        //Assert
        Assert.assertEquals("AddEnergyModule do not remove item in energyModule Map correctly", expectedValue, actual);
    }

//    @Test
//    public void testAddEnergyModuleLessThanMaxCapacityAddModuleInEnergyModuleMap() throws Exception {
//        //Arrange
//        addEnergyMocksToContainer(MODULE_QUANTITY);
//        int expectedValue = 2;
//
//        //Action
//        this.moduleContainer.addEnergyModule(this.energyModuleMock);
//        int actual = getModuleModuleSize(ENERGY_MODULE_NAME);
//
//        //Assert
//        Assert.assertEquals("AddEnergyModule do not add item in energyModule Map correctly", expectedValue, actual);
//    }



    //TEST ADD ABSORBING

    @Test(expected = IllegalArgumentException.class)
    public void testAddAbsorbingModuleWithNullAbsorbingModule() throws Exception {
        //Arrange
        this.absorbingModuleMock = null;
        //Act
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMock);
        //Assert
    }

    @Test
    public void testAddAbsorbingModuleWithMoreThanMaxCapacity() throws Exception {

        //Arrange
        addAbsorbingMocksToContainer(MODULE_CAPACITY_DEFAULT);
        int expectedValue = 3;

        //Action
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMock);
        int actual = getModuleByInputSize();

        //Assert
        Assert.assertEquals("AddAbsorbingModule do not delete item correctly", expectedValue, actual);
    }

//    @Test
//    public void testAddAbsorbingModuleWithLessThanMaxCapacity() throws Exception {
//
//        //Arrange
//        addAbsorbingMocksToContainer(MODULE_QUANTITY);
//        int expectedValue = 2;
//
//        //Action
//        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMock);
//        int actual = getModuleByInputSize();
//
//        //Assert
//        Assert.assertEquals("AddAbsorbingModule do not add item correctly", expectedValue, actual);
//    }

//    @Test
//    public void testAddAbsorbingModuleMoreThanMaxCapacityAddModuleInEnergyModuleMap() throws Exception {
//        //Arrange
//        addAbsorbingMocksToContainer(MODULE_CAPACITY_DEFAULT);
//        int expectedValue = 3;
//
//        //Action
//        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMock);
//        int actual = getModuleModuleSize(ABSORBING_MODULE_NAME);
//
//        //Assert
//        Assert.assertEquals("AddAbsorbingModule do not remove item in absorbingModule Map correctly", expectedValue, actual);
//    }

    @Test
    public void testAddAbsorbingModuleLessThanMaxCapacityAddModuleInAbsorbingModuleMap() throws Exception {
        //Arrange
        addAbsorbingMocksToContainer(MODULE_QUANTITY);
        int expectedValue = 2;

        //Action
        this.moduleContainer.addAbsorbingModule(this.absorbingModuleMock);
        int actual = getModuleModuleSize(ABSORBING_MODULE_NAME);

        //Assert
        Assert.assertEquals("AddAbsorbingModule do not add item in absorbingModule Map correctly", expectedValue, actual);
    }


    //TEST GET TOTAL ENERGY

    @Test
    public void testGetTotalEnergyOutputToReturnLong() throws Exception {
        //Arrange
        addEnergyMocksToContainer(MODULE_CAPACITY_DEFAULT);
        long expected = ((long) LONG_OUTPUT) * MODULE_CAPACITY_DEFAULT;
        //Act

        //Assert
        Assert.assertEquals("Total energy output is not long", expected, this.moduleContainer.getTotalEnergyOutput() );

    }

//    @Test
//    public void testGetTotalEnergyOutputToReturnCorrectResult() throws Exception {
//        //Arrange
//        addEnergyMocksToContainer(MODULE_QUANTITY);
//        long expected = ((long) LONG_OUTPUT) * MODULE_QUANTITY;
//        //Act
//
//        //Assert
//        Assert.assertEquals("Total energy output not returning correct result", expected, this.moduleContainer.getTotalEnergyOutput() );
//
//    }

    @Test
    public void testGetTotalHeatAbsorptionToReturnLong() throws Exception {
        //Arrange
        addAbsorbingMocksToContainer(MODULE_CAPACITY_DEFAULT);
        long expected = ((long) LONG_OUTPUT) * MODULE_CAPACITY_DEFAULT;
        //Act

        //Assert
        Assert.assertEquals("Total heat absorption is not long", expected, this.moduleContainer.getTotalHeatAbsorbing() );

    }

//    @Test
//    public void testGetTotalHeatAbsorptionToReturnCorrectResult() throws Exception {
//        //Arrange
//        addAbsorbingMocksToContainer(MODULE_QUANTITY);
//        long expected = ((long) LONG_OUTPUT) * MODULE_QUANTITY;
//        //Act
//
//        //Assert
//        Assert.assertEquals("Total heat absorption is not long", expected, this.moduleContainer.getTotalHeatAbsorbing() );
//
//    }


    //Helper methods

    private int getModuleByInputSize() throws NoSuchFieldException, IllegalAccessException {
        Field modulesByInputFieldActual = this.moduleContainer.getClass().getDeclaredField(MODULE_BY_INPUT_NAME);
        modulesByInputFieldActual.setAccessible(true);
        List<Module> modulesByInputActual = (List<Module>) modulesByInputFieldActual.get(this.moduleContainer);
        return modulesByInputActual.size();
    }

    private void addEnergyMocksToContainer(int mockObjectQuantity) throws NoSuchFieldException, IllegalAccessException {
        Field modulesByInputField = this.moduleContainer.getClass().getDeclaredField(MODULE_BY_INPUT_NAME);
        Field energyMapModuleField = this.moduleContainer.getClass().getDeclaredField(ENERGY_MODULE_NAME);
        energyMapModuleField.setAccessible(true);
        modulesByInputField.setAccessible(true);


        List<Module> modulesByInput = (List<Module>) modulesByInputField.get(this.moduleContainer);
        Map<Integer, EnergyModule> energyModuleMap = (Map<Integer, EnergyModule>) energyMapModuleField.get(this.moduleContainer);


        for (int i = 0; i < mockObjectQuantity ; i++) {
            EnergyModule moduleMock1 = mock(EnergyModule.class);
            when(moduleMock1.getId()).thenReturn(this.generateId());
            when(moduleMock1.getEnergyOutput()).thenReturn(LONG_OUTPUT);
            modulesByInput.add(moduleMock1);
            energyModuleMap.put(moduleMock1.getId(), moduleMock1);
        }
    }

    private void addAbsorbingMocksToContainer(int mockObjectQuantity) throws NoSuchFieldException, IllegalAccessException {
        Field modulesByInputField = this.moduleContainer.getClass().getDeclaredField(MODULE_BY_INPUT_NAME);
        Field absorbingModuleField = this.moduleContainer.getClass().getDeclaredField(ABSORBING_MODULE_NAME);
        absorbingModuleField.setAccessible(true);
        modulesByInputField.setAccessible(true);


        List<Module> modulesByInput = (List<Module>) modulesByInputField.get(this.moduleContainer);
        Map<Integer, AbsorbingModule> absorbingModuleMap = (Map<Integer, AbsorbingModule>) absorbingModuleField.get(this.moduleContainer);

        for (int i = 0; i < mockObjectQuantity ; i++) {
            AbsorbingModule moduleMock1 = mock(AbsorbingModule.class);
            when(moduleMock1.getId()).thenReturn(this.generateId());
            when(moduleMock1.getHeatAbsorbing()).thenReturn(LONG_OUTPUT);
            modulesByInput.add(moduleMock1);
            absorbingModuleMap.put(moduleMock1.getId(), moduleMock1);
        }
    }

    private int getModuleModuleSize(String mapModuleName) throws NoSuchFieldException, IllegalAccessException {
        Field moduleMapField = this.moduleContainer.getClass().getDeclaredField(mapModuleName);
        moduleMapField.setAccessible(true);
        Map<Integer, Module> moduleMap = (Map<Integer, Module>) moduleMapField.get(this.moduleContainer);
        return moduleMap.size();
    }

    private int generateId(){
        return ++this.id;
    }
}