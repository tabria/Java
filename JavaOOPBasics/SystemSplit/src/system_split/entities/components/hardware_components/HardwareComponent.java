package system_split.entities.components.hardware_components;

import system_split.entities.components.Component;
import system_split.entities.components.software_components.SoftwareComponent;
import system_split.utilities.Constants;

import java.util.*;
import java.util.stream.Collectors;

public abstract class HardwareComponent extends Component {

    private int capacity;
    private int memory;
    private Map<String, SoftwareComponent> softwareStorage;

    protected HardwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.softwareStorage = new LinkedHashMap<>();
        this.capacity = capacity;
        this.memory = memory;
    }

    public Map<String, SoftwareComponent> getSoftwareStorage() {
        return Collections.unmodifiableMap(this.softwareStorage);
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent){
    }

    public void registerSoftware(String name, SoftwareComponent softwareComponent) {
        this.softwareStorage.putIfAbsent(name, softwareComponent);
    }

    public void releaseSoftwareComponent(String softwareComponentName){
        if (this.softwareStorage.containsKey(softwareComponentName)){
            this.softwareStorage.remove(softwareComponentName);
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    protected abstract void modify(int capacity, int memory);

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    @Override
    public String toString() {
        StringBuilder sbHardwareComponent = new StringBuilder();

        int countExpressSoftwareComponents = 0;
        int countLightSoftwareComponents = 0;
        int totalMemoryInUse =0;
        int totalCapacityInUse = 0;

        for (Map.Entry<String, SoftwareComponent> softwareComponentEntrySet : this.getSoftwareStorage().entrySet()) {
            SoftwareComponent softwareComponent = softwareComponentEntrySet.getValue();
            countExpressSoftwareComponents += softwareComponent.getType().equals(Constants.EXPRESS_SOFTWARE_TYPE) ? 1 : 0;
            countLightSoftwareComponents += softwareComponent.getType().equals(Constants.LIGHT_SOFTWARE_TYPE) ? 1 : 0;

            totalMemoryInUse += softwareComponentEntrySet.getValue().getMemory();
            totalCapacityInUse += softwareComponentEntrySet.getValue().getCapacity();
        }

        sbHardwareComponent.append(String.format("Hardware Component - %s%n", this.getName()))
                .append(String.format("Express Software Components - %d%n", countExpressSoftwareComponents))
                .append(String.format("Light Software Components - %d%n", countLightSoftwareComponents))
                .append(String.format("Memory Usage: %d / %d%n",totalMemoryInUse, this.getMemory()))
                .append(String.format("Capacity Usage: %d / %d%n", totalCapacityInUse, this.getCapacity()))
                .append(String.format("Type: %s%n", this.getType()))
                .append(String.format("Software Components: %s%n", this.softwareStorage.size() < 1 ? "None" : this.softwareStorage.entrySet().stream().map((entry) -> entry.getKey()).collect(Collectors.joining(", "))));


        return sbHardwareComponent.toString() ;
    }
}
