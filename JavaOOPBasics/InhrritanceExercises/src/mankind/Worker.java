package mankind;

public class Worker extends Human {

    private double salary;
    private double workHoursPerDay;


    public Worker(String firstName, String lastName, double salary, double workHoursPerDay) {
        super(firstName, lastName);
        setLastName(lastName);
        setSalary(salary);
        setWorkHoursPerDay(workHoursPerDay);
    }

    private double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        if (salary<10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.salary = salary;
    }

    private double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 && workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length()<4){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("Week Salary: ")
                .append(String.format("%.2f", getSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ")
                .append(String.format("%.2f", getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append("Salary per hour: ")
                .append(String.format("%.2f",getSalary() / (getWorkHoursPerDay()*7.0)));
        return sb.toString();
    }
}
