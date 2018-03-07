package commands;

public abstract class BaseCommand implements Executable {

    private ManagementSystem managementSystem;

    protected BaseCommand(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }
}
