package system_split.factories;

import system_split.entities.components.hardware_components.HeavyHardwareComponent;
import system_split.entities.components.hardware_components.PowerHardwareComponent;

public final class HardwareComponentsFactory {


    public static HeavyHardwareComponent createHeavyHardwareComponent(String name, int capacity, int memory){
        return new HeavyHardwareComponent(name, capacity, memory);
    }

    public static PowerHardwareComponent createPowerHardwareComponent(String name, int capacity, int memory){
        return new PowerHardwareComponent(name, capacity, memory);
    }

}
