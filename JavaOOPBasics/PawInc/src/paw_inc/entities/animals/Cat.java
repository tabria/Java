package paw_inc.entities.animals;

public class Cat extends Animal {

    private int intelligenceCoefficient;

    public Cat(String name, int age, int intelligenceCoefficient) {
        super(name, age);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }

    public int getIntelligenceCoefficient() {
        return this.intelligenceCoefficient;
    }

    private void setIntelligenceCoefficient(int intelligenceCoefficient) {
        this.intelligenceCoefficient = intelligenceCoefficient;
    }
}
