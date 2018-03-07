package system_split.entities.components.software_components;

import system_split.entities.components.Component;
import system_split.utilities.Constants;

public abstract class SoftwareComponent extends Component {

    private int capacity;
    private int memory;

    protected SoftwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.capacity = capacity;
        this.memory = memory;
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

}
