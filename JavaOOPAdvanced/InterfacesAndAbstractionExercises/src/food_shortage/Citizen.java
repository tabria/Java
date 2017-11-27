package food_shortage;


public class Citizen extends Human {

    private String birthday;
    private String id;

    public Citizen(String name, int age, String id, String birthday) {
        super(name, age);
        this.id = id;
        this.birthday = birthday;
    }


    @Override
    public void buyFood() {
        super.setFood(super.getFood() + 10);
    }
}
