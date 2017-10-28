package first_reserve_team;

public class Person {

    private String firstName;
    private String secondName;
    private int age;
    private double salary;

    public Person(String firstName, String secondName, int age, double salary) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length()<3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.secondName = secondName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 1){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        if (salary < 460.0){
            throw   new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void addBonusToSalary(int bonus){
        if (this.age <= 30){
            this.salary += this.salary * bonus / 200;
        } else {
            this.salary += this.salary * bonus / 100;
        }
   }


    @Override
    public String toString() {
        return firstName + " " + secondName + " gets " + salary + " leva";
    }
}
