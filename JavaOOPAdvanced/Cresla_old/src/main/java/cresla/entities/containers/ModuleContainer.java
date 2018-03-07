package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;

import java.util.*;

public class ModuleContainer implements Container {

    private int moduleCapacity;
    private LinkedList<Module> modulesByInput;
    private Map<Integer, EnergyModule> energyModules;
    private Map<Integer, AbsorbingModule> absorbingModules;

    public ModuleContainer(int moduleCapacity) {
        this.moduleCapacity = moduleCapacity;
        this.modulesByInput = new LinkedList<>();
        this.energyModules = new LinkedHashMap<>();
        this.absorbingModules = new LinkedHashMap<>();
    }

    //refactor from if (energyModule != null)
    public void addEnergyModule(EnergyModule energyModule) {
        if (energyModule == null) {
            throw new IllegalArgumentException();
        }

        if (this.modulesByInput.size() == this.moduleCapacity) {
            this.removeOldestEnergyModule();
        }

        this.energyModules.put(energyModule.getId(), energyModule);
        this.modulesByInput.addLast(energyModule);
    }

    //refactor from if (absorbingModule != null)
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        if (absorbingModule == null) {
            throw new IllegalArgumentException();
        }

        if (this.modulesByInput.size() == this.moduleCapacity) {
            this.removeOldestAbsorbingModule();
        }

        this.absorbingModules.put(absorbingModule.getId(), absorbingModule);
        this.modulesByInput.addLast(absorbingModule);
    }

    //refactor from .mapToInt
    @Override
    public long getTotalEnergyOutput() {
        return this.energyModules.values().stream()
                .mapToLong(EnergyModule::getEnergyOutput)
                .sum();
    }

    //refactor from .mapToInt
    @Override
    public long getTotalHeatAbsorbing() {
        return this.absorbingModules.values().stream()
                .mapToLong(AbsorbingModule::getHeatAbsorbing)
                .sum();
    }

    //refactor split removeOldestModule to removeOldestEnergyModule and removeOldestAbsorbingModule
    private void removeOldestEnergyModule() {
        int removeId = this.modulesByInput.removeFirst().getId();

        //refactor from if(!this.energyModules.containsKey(removeId))
        if(this.energyModules.containsKey(removeId)) {
            this.energyModules.remove(removeId);
        }
    }

    private void removeOldestAbsorbingModule() {
        int removeId = this.modulesByInput.removeFirst().getId();

        //refactor from if(!this.absorbingModules.containsKey(removeId))
        if(this.absorbingModules.containsKey(removeId)) {
            this.absorbingModules.remove(removeId);
        }
    }
}