package mood_3.engine;

import mood_3.entities.BaseGameObject;
import mood_3.entities.GameObjects;
import mood_3.factories.GameObjectFactory;
import mood_3.io.ConsoleInputReader;
import mood_3.io.ConsoleOutputWriter;
import mood_3.utilities.InputParser;

import java.util.List;

public class Engine {

    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;

    public Engine() {
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
    }

    public void run(){

            List<String> command = this.inputParser.parseBySpace(inputReader.readLine());

            GameObjects gameObjects = this.dispatcher(command);

        this.outputWriter.writeLine(gameObjects.toString());
    }

    private GameObjects dispatcher(List<String> command){
        GameObjects gameObjects = null;
        switch(command.get(1)){
            case "Demon":
                gameObjects = GameObjectFactory.createDemon(command.get(0), Integer.parseInt(command.get(3)), Double.parseDouble(command.get(2)));
                break;
            case "Archangel":
                gameObjects = GameObjectFactory.createArchangel(command.get(0), Integer.parseInt(command.get(3)), Integer.parseInt(command.get(2)));
                break;

        }
        return gameObjects;
    }

}
