import Core.CommandHandler;
import Core.Engine;
import contracts.IBoatSimulatorController;
import controllers.BoatSimulatorController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IBoatSimulatorController ctrl = new BoatSimulatorController();
        CommandHandler commandHandler = new CommandHandler(ctrl);
        Engine engine = new Engine(commandHandler);
        engine.Run();
    }
}
