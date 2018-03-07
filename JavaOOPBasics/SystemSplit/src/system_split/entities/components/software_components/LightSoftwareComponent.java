package system_split.entities.components.software_components;

import system_split.utilities.Constants;

public class LightSoftwareComponent extends SoftwareComponent {

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, Constants.LIGHT_SOFTWARE_TYPE, capacity, memory);
        this.modify(capacity, memory);
    }

    @Override
    protected void modify(int capacity, int memory) {
        this.setCapacity(capacity + (capacity * Constants.INCREASE_CAPACITY_CONSUMPTION) / Constants.MAXIMUM_PERCENTAGE);
        this.setMemory(memory - (memory * Constants.DECREASE_MEMORY_CONSUMPTION) / Constants.MAXIMUM_PERCENTAGE);
    }
}
