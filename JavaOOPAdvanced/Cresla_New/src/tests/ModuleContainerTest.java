package tests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ModuleContainerTest {

    private static final int DEFAULT_ENERGY_OUTPUT = 1000000000;
    private static final int DEFAULT_MODULE_CONTAINER_CAPACITY = 3;
    private static final int ZERO_CAPACITY = 0;

    private Container moduleContainer;

    @Before
    public void initialize(){
        this.moduleContainer = new ModuleContainer(DEFAULT_MODULE_CONTAINER_CAPACITY);
    }

    @Test
    public void addCorrectEnergyModuleWithFreeCapacity(){

        EnergyModule energyModuleMock1 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock1.getEnergyOutput()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(energyModuleMock1.getId()).thenReturn(1);
        this.moduleContainer.addEnergyModule(energyModuleMock1);

        Assert.assertEquals("Not adding correct module", DEFAULT_ENERGY_OUTPUT, this.moduleContainer.getTotalEnergyOutput());

    }

    @Test(expected = NoSuchElementException.class)
    public void throwErrorWhenAddingEnergyModuleAndCapacityIsFull(){

        Container moduleContainerZeroCapacity = new ModuleContainer(ZERO_CAPACITY);
        EnergyModule energyModuleMock1 = Mockito.mock(EnergyModule.class);
        moduleContainerZeroCapacity.addEnergyModule(energyModuleMock1);

    }

    @Test
    public void addCorrectEnergyModuleWhenCapacityIsFull() throws NoSuchFieldException, IllegalAccessException {

        EnergyModule energyModuleMock1 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock1.getEnergyOutput()).thenReturn(1);
        Mockito.when(energyModuleMock1.getId()).thenReturn(1);
        this.moduleContainer.addEnergyModule(energyModuleMock1);

        EnergyModule energyModuleMock2 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock2.getEnergyOutput()).thenReturn(2);
        Mockito.when(energyModuleMock2.getId()).thenReturn(2);
        this.moduleContainer.addEnergyModule(energyModuleMock2);

        EnergyModule energyModuleMock3 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock3.getEnergyOutput()).thenReturn(3);
        Mockito.when(energyModuleMock3.getId()).thenReturn(3);
        this.moduleContainer.addEnergyModule(energyModuleMock3);

        EnergyModule energyModuleMock4 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock4.getEnergyOutput()).thenReturn(4);
        Mockito.when(energyModuleMock4.getId()).thenReturn(1);
        this.moduleContainer.addEnergyModule(energyModuleMock4);

        long expected = 9;

        Field energyModuleField = this.moduleContainer.getClass().getDeclaredField("energyModules");
        energyModuleField.setAccessible(true);
        Map<Integer, EnergyModule> result = (Map<Integer, EnergyModule>) energyModuleField.get(this.moduleContainer);

       // Assert.assertEquals("Not adding correct module when no free capacity", expected, this.moduleContainer.getTotalEnergyOutput());

        Assert.assertEquals("Not adding correct module when no free capacity", DEFAULT_MODULE_CONTAINER_CAPACITY, result.size());

    }

    @Test
    public void totalEnergyOutputShouldReturnLong() {

        EnergyModule energyModuleMock1 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock1.getEnergyOutput()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(energyModuleMock1.getId()).thenReturn(1);

        EnergyModule energyModuleMock2 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock2.getEnergyOutput()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(energyModuleMock2.getId()).thenReturn(2);

        EnergyModule energyModuleMock3 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModuleMock3.getEnergyOutput()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(energyModuleMock3.getId()).thenReturn(3);


        this.moduleContainer.addEnergyModule(energyModuleMock1);
        this.moduleContainer.addEnergyModule(energyModuleMock2);
        this.moduleContainer.addEnergyModule(energyModuleMock3);

        long expected = 3L*DEFAULT_ENERGY_OUTPUT;

        Assert.assertEquals("getTotalEnergyOutput do not return long", expected, this.moduleContainer.getTotalEnergyOutput());

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenAddingNullEnergyModule(){
        this.moduleContainer.addEnergyModule(null);
    }


    @Test(expected = NoSuchElementException.class)
    public void throwErrorWhenAddingHeatAbsorbingModuleAndCapacityIsFull(){

        Container moduleContainerZeroCapacity = new ModuleContainer(ZERO_CAPACITY);
        AbsorbingModule absorbingModuleMock1 = Mockito.mock(AbsorbingModule.class);
        moduleContainerZeroCapacity.addAbsorbingModule(absorbingModuleMock1);

    }

    @Test
    public void addCorrectHeatAbsorbingModuleWhenCapacityIsFull() throws NoSuchFieldException, IllegalAccessException {

        AbsorbingModule absorbingModuleMock1 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock1.getHeatAbsorbing()).thenReturn(1);
        Mockito.when(absorbingModuleMock1.getId()).thenReturn(1);

        AbsorbingModule absorbingModuleMock2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock2.getHeatAbsorbing()).thenReturn(2);
        Mockito.when(absorbingModuleMock2.getId()).thenReturn(2);

        AbsorbingModule absorbingModuleMock3 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock3.getHeatAbsorbing()).thenReturn(3);
        Mockito.when(absorbingModuleMock3.getId()).thenReturn(3);

        AbsorbingModule absorbingModuleMock4 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock4.getHeatAbsorbing()).thenReturn(4);
        Mockito.when(absorbingModuleMock4.getId()).thenReturn(4);

        this.moduleContainer.addAbsorbingModule(absorbingModuleMock1);
        this.moduleContainer.addAbsorbingModule(absorbingModuleMock2);
        this.moduleContainer.addAbsorbingModule(absorbingModuleMock3);
        this.moduleContainer.addAbsorbingModule(absorbingModuleMock4);

        long expected = 9;

        Field absorbingModuleField = this.moduleContainer.getClass().getDeclaredField("absorbingModules");
        absorbingModuleField.setAccessible(true);
        Map<Integer, AbsorbingModule> result = (Map<Integer, AbsorbingModule>) absorbingModuleField.get(this.moduleContainer);

        //Assert.assertEquals("Not adding module correctly when capacity is full", expected, this.moduleContainer.getTotalHeatAbsorbing());

        Assert.assertEquals("Not adding module correctly when capacity is full", DEFAULT_MODULE_CONTAINER_CAPACITY, result.size());

    }

    @Test
    public void addCorrectHeatAbsorbingModuleWithFreeCapacity(){

        AbsorbingModule absorbingModuleMock1 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock1.getHeatAbsorbing()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(absorbingModuleMock1.getId()).thenReturn(1);

        this.moduleContainer.addAbsorbingModule(absorbingModuleMock1);

        Assert.assertEquals("Not adding correct module", DEFAULT_ENERGY_OUTPUT, this.moduleContainer.getTotalHeatAbsorbing());

    }

    @Test
    public void totalHeatAbsorbingOutputShouldReturnLong() {

        AbsorbingModule absorbingModuleMock1 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock1.getHeatAbsorbing()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(absorbingModuleMock1.getId()).thenReturn(1);

        AbsorbingModule absorbingModuleMock2 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock2.getHeatAbsorbing()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(absorbingModuleMock2.getId()).thenReturn(2);

        AbsorbingModule absorbingModuleMock3 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModuleMock3.getHeatAbsorbing()).thenReturn(DEFAULT_ENERGY_OUTPUT);
        Mockito.when(absorbingModuleMock3.getId()).thenReturn(3);


        this.moduleContainer.addAbsorbingModule(absorbingModuleMock1);
        this.moduleContainer.addAbsorbingModule(absorbingModuleMock2);
        this.moduleContainer.addAbsorbingModule(absorbingModuleMock3);

        long expected = 3L*DEFAULT_ENERGY_OUTPUT;

        Assert.assertEquals("getTotalHeatAbsorbing do not return long", expected, this.moduleContainer.getTotalHeatAbsorbing());

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenAddingNullAbsorbingModule(){
        this.moduleContainer.addAbsorbingModule(null);
    }
}