package food_shortage;

public abstract class Human implements Buyer {

    private String name;
    private int age;
    private int food;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.food = Human.FOOD;
    }

    public int getFood() {
        return this.food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public String getName() {
        return this.name;
    }
}
