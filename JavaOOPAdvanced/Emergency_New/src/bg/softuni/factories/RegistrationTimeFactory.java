package bg.softuni.factories;

import bg.softuni.contracts.RegistrationTime;
import bg.softuni.utils.RegistrationTimeImpl;

public final class RegistrationTimeFactory {

    public static RegistrationTime create(String time){
        return new RegistrationTimeImpl(time);
    }

}
