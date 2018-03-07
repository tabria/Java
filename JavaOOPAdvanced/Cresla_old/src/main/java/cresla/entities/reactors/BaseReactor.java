package cresla.entities.reactors;

import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseReactor implements Reactor {

    private Container moduleContainer;
    private int id;

    protected BaseReactor(int id, Container moduleContainer) {
        this.id = id;
        this.moduleContainer = moduleContainer;
    }


    public int getId() {
        return this.id;
    }

    public long getTotalEnergyOutput() {
        return this.moduleContainer.getTotalEnergyOutput();
    }

    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing();
    }

    public int getModuleCount() throws NoSuchFieldException, IllegalAccessException {
        Field totalModules = this.moduleContainer.getClass().getDeclaredField("modulesByInput");
        totalModules.setAccessible(true);
        List<Module> listModules = (List<Module>) totalModules.get(this.moduleContainer);
        return listModules.size();
    }

    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public String toString() {
        int moduleCounts = 0;
        try {
            moduleCounts = getModuleCount();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        long heatAbsorption = getTotalHeatAbsorbing();
        long energyOutput = getTotalEnergyOutput();

        if (moduleCounts == 0 || energyOutput > heatAbsorption){
            energyOutput = 0L;
        }

        StringBuilder reactorSb = new StringBuilder();
        reactorSb.append(String.format("%s - %d\r\n",this.getClass().getSimpleName(), this.getId()))
                .append(String.format("Energy Output: %d\r\n", energyOutput))
                .append(String.format("Heat Absorbing: %d\r\n", heatAbsorption))
                .append(String.format("Modules: %d", moduleCounts));

        return reactorSb.toString();
    }
}
