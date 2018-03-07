package paw_inc.core;

import paw_inc.io.ConsoleInputReader;
import paw_inc.utilities.Constants;

public class Engine {

    private ConsoleInputReader inputReader;
    private AnimalCenterManager animalCenterManager;

    public Engine() {
        this.animalCenterManager = new AnimalCenterManager();
        this.inputReader = new ConsoleInputReader();
    }

    public void run() {

        while(true){
            String input = inputReader.readLine();
            if (Constants.TERMINATE_COMMAND.equals(input)){
                break;
            }
            String[] commands = input.split("\\s+\\|\\s+");

            this.dispatcher(commands);
        }
        this.animalCenterManager.printStatistics();
    }

    private void dispatcher(String[] commands){
        switch(commands[0]){
            case "RegisterCleansingCenter":
                String nameCleansingCenter = commands[1];

                this.animalCenterManager.registerCleansingCenter(nameCleansingCenter);
                break;
            case "RegisterAdoptionCenter":
                String nameAdoptionCenter = commands[1];

                this.animalCenterManager.registerAdoptionCenter(nameAdoptionCenter);
                break;
            case "RegisterCastrationCenter":
                String nameCastrationCenter = commands[1];

                this.animalCenterManager.registerCastrationCenter(nameCastrationCenter);
                break;
            case "RegisterDog":
                String dogName = commands[1];
                int dogAge = Integer.parseInt(commands[2]);
                int dogCommands = Integer.parseInt(commands[3]);
                String centerName = commands[4];

                this.animalCenterManager.registerDog(dogName, dogAge, dogCommands, centerName);
                break;
            case "RegisterCat":
                String catName = commands[1];
                int catAge = Integer.parseInt(commands[2]);
                int catIntelligence = Integer.parseInt(commands[3]);
                String registerCenterName = commands[4];

                this.animalCenterManager.registerCat(catName, catAge, catIntelligence, registerCenterName);
                break;
            case "SendForCleansing":
                String adoptionCenterName = commands[1];
                String cleansingCenterName = commands[2];

                this.animalCenterManager.sendForCleansing(adoptionCenterName, cleansingCenterName);
                break;
            case "SendForCastration":
                String adoption = commands[1];
                String castrationCenter = commands[2];

                this.animalCenterManager.SendForCastration(adoption, castrationCenter);
                break;
            case "Cleanse":
                String cleansingCenter = commands[1];

                this.animalCenterManager.cleanse(cleansingCenter);
                break;
            case "Castrate":
                String castrateCenterName = commands[1];

                this.animalCenterManager.castrate(castrateCenterName);
                break;
            case "Adopt":
                String adoptionCenter = commands[1];

                this.animalCenterManager.adopt(adoptionCenter);
                break;
            case "CastrationStatistics":

                this.animalCenterManager.castrationStatistics();
                break;
        }

    }

}
