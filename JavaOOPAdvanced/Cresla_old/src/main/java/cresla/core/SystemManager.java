package cresla.core;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemManager implements Manager {

    private static final String REACTOR_PATH =  "cresla.entities.reactors.";
    private static final String MODULE_PATH = "cresla.entities.modules.";

    private static final String REACTOR_SUFFIX = "Reactor";
    private static final String MODULE_SUFFIX = "Module";

    private static final String MODULE_ENERGY_TYPE = "CryogenRod";

    private static final String REACTOR_CREATION = "Created %s Reactor - %d";
    private static final String MODUL_CREATION = "Added %s - %d to Reactor - %d";
    private static final String CRYO = "Cryo";
    private static final String HEAT = "Heat";

    private Map<Integer, Reactor> createdReactors;
    private Map<Integer, Module> createdModules;
    private Identifiable id;

    public SystemManager(Identifiable id) {
        this.createdReactors = new HashMap<>();
        this.createdModules = new HashMap<>();
        this.id = id;
    }

    @Override
    public String reactorCommand(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String reactorType = arguments.get(1);
        int currentId = this.id.getId();
        int moduleCapacity = Integer.parseInt(arguments.get(3));
        int reactorExtraProperty = Integer.parseInt(arguments.get(2));
        Class<Reactor> reactor = (Class<Reactor>) Class.forName(REACTOR_PATH + reactorType + REACTOR_SUFFIX);
        Constructor<Reactor> reactorConstructor = reactor.getDeclaredConstructor(int.class, Container.class, int.class);
        Reactor newReactor = reactorConstructor.newInstance(currentId, new ModuleContainer(moduleCapacity), reactorExtraProperty);
        this.createdReactors.put(currentId, newReactor);

        return String.format(REACTOR_CREATION, reactorType, currentId);
    }

    @Override
    public String moduleCommand(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        int reactorId = Integer.parseInt(arguments.get(1));
        String moduleType = arguments.get(2);
        int currentId = this.id.getId();
        int moduleExtraProperty = Integer.parseInt(arguments.get(3));

        if (moduleType.equals(MODULE_ENERGY_TYPE)){
            Class<EnergyModule> module = (Class<EnergyModule>) Class.forName(MODULE_PATH + moduleType + MODULE_SUFFIX);
            Constructor<EnergyModule> moduleConstructor = module.getDeclaredConstructor(int.class, int.class);
            EnergyModule newModule = moduleConstructor.newInstance(currentId, moduleExtraProperty);
            this.createdReactors.get(reactorId).addEnergyModule(newModule);
            this.createdModules.put(currentId, newModule);
        } else {
            Class<AbsorbingModule> module = (Class<AbsorbingModule>) Class.forName(MODULE_PATH + moduleType + MODULE_SUFFIX);
            Constructor<AbsorbingModule> moduleConstructor = module.getDeclaredConstructor(int.class, int.class);
            AbsorbingModule newModule = moduleConstructor.newInstance(currentId, moduleExtraProperty);
            this.createdReactors.get(reactorId).addAbsorbingModule(newModule);
            this.createdModules.put(currentId, newModule);
        }

        return String.format(MODUL_CREATION,moduleType, currentId, reactorId);
    }

    @Override
    public String reportCommand(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        int id = Integer.parseInt(arguments.get(1));
        if(this.createdReactors.containsKey(id)){
            sb.append(this.createdReactors.get(id).toString());
        } else if (this.createdModules.containsKey(id)){
            sb.append(this.createdModules.get(id).toString());
        }

        return sb.toString() ;
    }

    @Override
    public String exitCommand(List<String> arguments) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        long cryoReactorsCount = this.createdReactors.entrySet().stream().filter(e-> e.getValue().getClass().getSimpleName().contains(CRYO)).count();
        long heatReactorsCount = this.createdReactors.entrySet().stream().filter(e-> e.getValue().getClass().getSimpleName().contains(HEAT)).count();
        long energyModulesCount = this.createdModules.entrySet().stream().filter(e-> e.getValue().getClass().getSimpleName().contains(MODULE_ENERGY_TYPE)).count();
        long absorbingModulesCount = this.createdModules.entrySet().stream().filter(e-> !e.getValue().getClass().getSimpleName().contains(MODULE_ENERGY_TYPE)).count();
        long totalEnergyOutput =0L;
        long totalHeatAbsorption = 0L;
        for (Map.Entry<Integer, Reactor> currentEntry:this.createdReactors.entrySet()) {
            long currentAbsorption = currentEntry.getValue().getTotalHeatAbsorbing();
            long currentEnergyOutput = currentEntry.getValue().getTotalEnergyOutput();
            int countModules = currentEntry.getValue().getModuleCount();
            if (currentEnergyOutput <= currentAbsorption && countModules != 0){
                totalEnergyOutput += currentEnergyOutput;
            }
            totalHeatAbsorption += currentAbsorption;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cryo Reactors: %d\r\n", cryoReactorsCount))
                .append(String.format("Heat Reactors: %d\r\n", heatReactorsCount))
                .append(String.format("Energy Modules: %d\r\n", energyModulesCount))
                .append(String.format("Absorbing Modules: %d\r\n", absorbingModulesCount))
                .append(String.format("Total Energy Output: %d\r\n", totalEnergyOutput))
                .append(String.format("Total Heat Absorbing: %d", totalHeatAbsorption));

        return sb.toString();
    }
}
