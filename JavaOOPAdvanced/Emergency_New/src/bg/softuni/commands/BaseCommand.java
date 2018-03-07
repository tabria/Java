package bg.softuni.commands;

import bg.softuni.contracts.Executable;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.factories.ManagementSystemFactory;

public abstract class BaseCommand implements Executable {

    private ManagementSystem managementSystem;

    protected BaseCommand(ManagementSystem managementSystem) {
        this.managementSystem = managementSystem;
    }

    protected ManagementSystem getManagementSystem() {
        return this.managementSystem;
    }
}
