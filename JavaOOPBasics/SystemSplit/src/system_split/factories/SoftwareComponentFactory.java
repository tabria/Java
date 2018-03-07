package system_split.factories;

import system_split.entities.components.software_components.ExpressSoftwareComponent;
import system_split.entities.components.software_components.LightSoftwareComponent;

public final class SoftwareComponentFactory {


    public static LightSoftwareComponent createLightSoftwareComponent(String name, int capacity, int memory){
        return new LightSoftwareComponent(name, capacity, memory);
    }

    public static ExpressSoftwareComponent createExpressSoftwareComponent(String name, int capacity, int memory){
        return new ExpressSoftwareComponent(name, capacity, memory);
    }
}
