package system_split.entities.components.software_components;

import system_split.utilities.Constants;

public class ExpressSoftwareComponent extends SoftwareComponent {


    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, Constants.EXPRESS_SOFTWARE_TYPE, capacity, memory);
        this.modify(capacity, memory);
    }

    @Override
    protected void modify(int capacity, int memory) {
        this.setMemory  (memory + memory);
    }
}
