package company_roster;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentName;
    private List<Employee> departmentEmployees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.departmentEmployees = new ArrayList<>();
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public List<Employee> getDepartmentEmployees() {
        return new ArrayList<Employee>(this.departmentEmployees);
    }

    public void setDepartmentEmployees(Employee worker) {
        this.departmentEmployees.add(worker);
    }

    public double calculateAverageSalary(){
        double sum =0.0;
        for (Employee e: this.getDepartmentEmployees()) {
            sum += e.getSalary();
        }
        return sum/this.getDepartmentEmployees().size();
    }
}
