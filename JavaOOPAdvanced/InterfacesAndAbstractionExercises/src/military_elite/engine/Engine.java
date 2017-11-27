package military_elite.engine;

import military_elite.entities.Soldier;
import military_elite.io.ConsoleInputReader;
import military_elite.io.ConsoleOutputWriter;
import military_elite.utilities.InputParser;

import java.util.List;
import java.util.Map;

public class Engine {

    private SoldierManager soldierManager;
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;

    public Engine() {
        this.soldierManager = new SoldierManager();
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
    }

    public void run(){



        while(true){
            String input = inputReader.readLine();
            if (input.equals("End")){
                break;
            }

            List<String> command = this.inputParser.parseBySpace(input);
            //command.subList()

            this.dispatcher(command);
        }


        this.printResult();

    }

    private void dispatcher(List<String> command){
        switch(command.get(0)){
            case "Private":
                this.soldierManager.addPrivate(command.get(1), command.get(2), command.get(3), Double.parseDouble(command.get(4)));
                break;
            case "LeutenantGeneral":
                this.soldierManager.addLeutenantGeneral(command);
                break;
            case"Engineer":
                this.soldierManager.addEngineer(command);
                break;
            case"Commando":
                this.soldierManager.addCommando(command);
                break;
            case "Spy":
                this.soldierManager.addSpy(command.get(1), command.get(2), command.get(3), command.get(4));
                break;
        }
    }

    private void printResult() {
        for (Map.Entry<String, Soldier> soldier:soldierManager.getSoldiers().entrySet()) {
            this.outputWriter.writeLine(soldier.getValue().toString());
        }
    }

}
