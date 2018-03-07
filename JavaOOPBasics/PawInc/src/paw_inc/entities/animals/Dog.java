package paw_inc.entities.animals;

public class Dog extends Animal {

    private int amountOfCommands;

    public Dog(String name, int age, int amountOfCommands) {
        super(name, age);
        this.amountOfCommands = amountOfCommands;
    }

    public int getAmountOfCommands() {
        return this.amountOfCommands;
    }

    private void setAmountOfCommands(int amountOfCommands) {
        this.amountOfCommands = amountOfCommands;
    }
}
