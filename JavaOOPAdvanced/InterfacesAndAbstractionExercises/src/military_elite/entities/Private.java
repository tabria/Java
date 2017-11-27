package military_elite.entities;

public class Private extends Soldier implements IPrivate {

    private double salary;

    public Private(String id, String name, String lastName, double salary) {
        super(id, name, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%sSalary: %.2f%n",super.toString(),this.getSalary());
    }
}
