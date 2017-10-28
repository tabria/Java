package animal_farm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    private void setName(String name) {
        if (name.length()<1 || name.isEmpty() || name == null || name.matches("\\s+")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age > 15 || age < 0){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay(){
        int age = getAge();
        if (age <6 ){
            return 2;
        } else if( age >= 6 && age < 12){
            return 1;
        } else {
            return 0.75;
        }
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }
}
