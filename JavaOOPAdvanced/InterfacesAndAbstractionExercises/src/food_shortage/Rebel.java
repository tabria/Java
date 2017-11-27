package food_shortage;

public class Rebel extends Human {

    String group;

    public Rebel(String name, int age, String group) {
        super(name, age);
        this.group = group;
    }

    @Override
    public void buyFood() {
        super.setFood(super.getFood() + 5);
    }

}
