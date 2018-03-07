package system_split.engine;

import system_split.io.ConsoleInputReader;
import system_split.utilities.Constants;

public class Engine {


    private TheSystem theSystem;
    private ConsoleInputReader inputReader;

    public Engine() {
        this.theSystem = new TheSystem();
        this.inputReader = new ConsoleInputReader();
    }

    public void run(){

        while(true){
            String input = this.inputReader.readLine();
            if (Constants.TERMINATE_COMMAND.equals(input)){
                break;
            }

            String[] command = input.split("\\(|, |\\)");


            this.dispatcher(command);
        }
        System.out.print(this.theSystem.split());
    }

    private void dispatcher(String[] command) {

        switch (command[0]){
            case "RegisterPowerHardware":
                this.theSystem.registerPowerHardware(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                break;
            case "RegisterHeavyHardware":
                this.theSystem.registerHeavyHardware(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
                break;
            case "RegisterExpressSoftware":
                this.theSystem.registerExpressSoftware(command[1], command[2], Integer.parseInt(command[3]), Integer.parseInt(command[4]));
                break;
            case "RegisterLightSoftware":
                this.theSystem.registerLightSoftware(command[1], command[2], Integer.parseInt(command[3]), Integer.parseInt(command[4]));
                break;
            case "ReleaseSoftwareComponent":
                this.theSystem.releaseSoftwareComponent(command[1], command[2]);
                break;
            case "Analyze":
                    System.out.print(this.theSystem.analyze());
                break;
        }
    }

}
