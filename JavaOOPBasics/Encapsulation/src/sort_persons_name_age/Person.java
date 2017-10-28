package sort_persons_name_age;

public class Person {

    private String firstName;
    private String secondName;
    private int age;


    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " is " + age + " years old.";
    }
}
