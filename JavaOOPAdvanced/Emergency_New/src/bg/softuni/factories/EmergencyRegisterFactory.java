package bg.softuni.factories;

import bg.softuni.collection.EmergencyRegister;
import bg.softuni.contracts.Register;

public final class EmergencyRegisterFactory {

    public static <T> Register create(){
        return  new EmergencyRegister<>();
    }

}
