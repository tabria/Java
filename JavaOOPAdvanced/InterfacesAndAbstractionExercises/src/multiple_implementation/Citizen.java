package multiple_implementation;

public class Citizen implements Identifiable, Birthable {

    private String name;
    private int age;
    private String id;
    private String Birthdate;

    public Citizen(String name, int age, String id, String Birthdate) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthdate() {
        return this.Birthdate;
    }
}
