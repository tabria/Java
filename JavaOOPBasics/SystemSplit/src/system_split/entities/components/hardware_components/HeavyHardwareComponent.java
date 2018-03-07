package system_split.entities.components.hardware_components;

import system_split.utilities.Constants;

public class HeavyHardwareComponent extends HardwareComponent {


    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, Constants.HEAVY_HARDWARE_TYPE, capacity, memory);
        this.modify(capacity, memory);
    }

    @Override
    protected void modify(int capacity, int memory){
        this.setCapacity(capacity + capacity);
        this.setMemory(memory - (memory * Constants.DECREASE_MAXIMUM_MEMORY) / Constants.MAXIMUM_PERCENTAGE);
    }
}
