package system_split.entities.components.hardware_components;

import system_split.utilities.Constants;

public class PowerHardwareComponent extends HardwareComponent {


    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, Constants.POWER_HARDWARE_TYPE, capacity, memory);
        this.modify(capacity, memory);
    }

    @Override
    protected void modify(int capacity, int memory) {
        this.setCapacity(capacity - (capacity * Constants.DECREASE_MAXIMUM_CAPACITY) / Constants.MAXIMUM_PERCENTAGE );
        this.setMemory(memory + (memory * Constants.INCREASE_MAXIMUM_MEMORY) / Constants.MAXIMUM_PERCENTAGE);
    }


}
