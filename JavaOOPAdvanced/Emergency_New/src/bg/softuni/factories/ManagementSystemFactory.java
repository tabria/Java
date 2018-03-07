package bg.softuni.factories;

import bg.softuni.contracts.ManagementSystem;
import bg.softuni.core.EmergencyManagementSystem;

public final class ManagementSystemFactory {

    public static ManagementSystem create(){
        return new EmergencyManagementSystem();
    }

}
