package system_split.engine;

import system_split.entities.components.hardware_components.HardwareComponent;
import system_split.entities.components.software_components.SoftwareComponent;
import system_split.factories.HardwareComponentsFactory;
import system_split.factories.SoftwareComponentFactory;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TheSystem {

    private Map<String, HardwareComponent> hardwareComponent;


    public TheSystem() {
        this.hardwareComponent = new LinkedHashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory){
        if (!this.hardwareComponent.containsKey(name)){
            this.hardwareComponent.put(name, HardwareComponentsFactory.createPowerHardwareComponent(name, capacity, memory));
        }
    }

    public void registerHeavyHardware(String name, int capacity, int memory){
        if (!this.hardwareComponent.containsKey(name)){
            this.hardwareComponent.putIfAbsent(name, HardwareComponentsFactory.createHeavyHardwareComponent(name, capacity, memory));
        }
    }

    public void registerExpressSoftware(String hardwareComponentName, String softwareComponentName, int capacity, int memory) {
        if (this.hardwareComponent.containsKey(hardwareComponentName)){
            SoftwareComponent newSoftwareComponent = SoftwareComponentFactory.createExpressSoftwareComponent(softwareComponentName, capacity, memory);
            HardwareComponent currentHardwareComponent = this.hardwareComponent.get(hardwareComponentName);
            registerComponent(currentHardwareComponent, newSoftwareComponent);
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String softwareComponentName, int capacity, int memory) {
        if (this.hardwareComponent.containsKey(hardwareComponentName)){
            SoftwareComponent newSoftwareComponent = SoftwareComponentFactory.createLightSoftwareComponent(softwareComponentName, capacity, memory);
            HardwareComponent currentHardwareComponent = this.hardwareComponent.get(hardwareComponentName);
            registerComponent(currentHardwareComponent, newSoftwareComponent);
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName){
        if (this.hardwareComponent.containsKey(hardwareComponentName)){
            this.hardwareComponent.get(hardwareComponentName).releaseSoftwareComponent(softwareComponentName);
        }
    }

    public String analyze(){

        StringBuilder sb = new StringBuilder();

        int countHardwareComponents = this.hardwareComponent.size();
        int countSoftwareComponents = 0;
        int maximumMemory = 0;
        int maximumCapacity =0;
        int totalMemoryInUse =0;
        int totalCapacityInUse = 0;

        for (Map.Entry<String, HardwareComponent> hardwareComponentEntrySet:this.hardwareComponent.entrySet()) {
            HardwareComponent hardwareComponent = hardwareComponentEntrySet.getValue();
            maximumMemory += hardwareComponent.getMemory();
            maximumCapacity += hardwareComponent.getCapacity();
            countSoftwareComponents += hardwareComponent.getSoftwareStorage().size();

            for (Map.Entry<String, SoftwareComponent> softwareComponentEntrySet:hardwareComponent.getSoftwareStorage().entrySet()) {
                totalMemoryInUse += softwareComponentEntrySet.getValue().getMemory();
                totalCapacityInUse += softwareComponentEntrySet.getValue().getCapacity();
            }
        }
        sb.append("System Analysis\r\n")
                .append(String.format("Hardware Components: %d%n", countHardwareComponents))
                .append(String.format("Software Components: %d%n", countSoftwareComponents))
                .append(String.format("Total Operational Memory: %d / %d%n", totalMemoryInUse, maximumMemory))
                .append(String.format("Total Capacity Taken: %d / %d%n", totalCapacityInUse, maximumCapacity));

        return sb.toString();
    }

    public String split(){
        StringBuilder sb = new StringBuilder();

        Map<String, HardwareComponent> sortedMap = this.hardwareComponent.entrySet().stream().sorted((k1, k2) ->k2.getValue().getType().compareTo(k1.getValue().getType())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) ->e1, LinkedHashMap::new));
        for (Map.Entry<String, HardwareComponent> componentEntry: sortedMap.entrySet()) {
            sb.append(componentEntry.getValue().toString());
        }
        return sb.toString();
    }




    private void registerComponent(HardwareComponent currentHardwareComponent, SoftwareComponent newSoftwareComponent) {
        int totalMemoryInUse = 0;
        int totalCapacityInUse = 0;
        for (Map.Entry<String, SoftwareComponent> soft: this.hardwareComponent.get(currentHardwareComponent.getName()).getSoftwareStorage().entrySet()) {
            totalMemoryInUse += soft.getValue().getMemory();
            totalCapacityInUse += soft.getValue().getCapacity();
        }
        if (newSoftwareComponent.getCapacity() + totalCapacityInUse <= currentHardwareComponent.getCapacity() &&
                newSoftwareComponent.getMemory() + totalMemoryInUse <=  currentHardwareComponent.getMemory()) {
            currentHardwareComponent.registerSoftware(newSoftwareComponent.getName(), newSoftwareComponent);
        }
    }

}
