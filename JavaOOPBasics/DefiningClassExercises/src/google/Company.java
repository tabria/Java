package google;

public class Company {

    private final static String DEFAULT_VALUE = "";

    private String companyName;
    private String department;
    private String salary;

    public Company() {
        this.companyName = DEFAULT_VALUE;
        this.department = DEFAULT_VALUE;
        this.salary = DEFAULT_VALUE;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = String.format("%.2f", salary);
    }

    @Override
    public String toString() {
        return  companyName + " " +department + " " + salary ;
    }
}



