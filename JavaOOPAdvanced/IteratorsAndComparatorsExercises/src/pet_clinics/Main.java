package pet_clinics;

import pet_clinics.interfaces.Engine;
import pet_clinics.engine.EngineImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Engine engine = new EngineImpl();
        engine.run();

    }

}
