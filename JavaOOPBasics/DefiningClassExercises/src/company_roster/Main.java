package company_roster;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Department> departmentList = new ArrayList<>();

        int cycles = Integer.valueOf(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            String[] worker = reader.readLine().split("\\s+");
            addWorkerToDepartment(departmentList, worker);
        }
        departmentList.stream()
                .sorted((x, y) -> Double.compare(y.calculateAverageSalary(), x.calculateAverageSalary()))
                .limit(1).forEach(entry -> {
            System.out.println("Highest Average Salary: " + entry.getDepartmentName());
            entry.getDepartmentEmployees().stream()
                    .sorted((k, j) -> Double.compare(j.getSalary(), k.getSalary())).forEach(em-> {
                System.out.printf("%s %.2f %s %d%n",em.getName(), em.getSalary(), em.getEmail(), em.getAge());
            });
        });
    }

    private static void addWorkerToDepartment(List<Department> departmentList, String[] worker) {
        String employeeDepartment = worker[3];
        boolean isWorkerAdded = false;
        for (Department currDep : departmentList) {
            if (currDep.getDepartmentName().equals(employeeDepartment)){
                Employee newWorker = createEmployee(worker, employeeDepartment);
                currDep.setDepartmentEmployees(newWorker);
                isWorkerAdded = true;
                break;
            }
        }
        if (!isWorkerAdded){
            Department newDepartment = new Department(employeeDepartment);
            Employee newWorker = createEmployee(worker, employeeDepartment);
            newDepartment.setDepartmentEmployees(newWorker);
            departmentList.add(newDepartment);
        }
    }

    private static void addDepartment(List<Department> departmentList, String[] worker, String employeeDepartment) {
        Department newDepartment = new Department(employeeDepartment);
        Employee newWorker = createEmployee(worker, employeeDepartment);
        newDepartment.setDepartmentEmployees(newWorker);
    }

    private static Employee createEmployee(String[] worker, String employeeDepartment) {
        String employeeName = worker[0];
        Double employeeSalary = Double.valueOf(worker[1]);
        String employeePosition = worker[2];
        String email ="";
        int age = 0;
        boolean isAge = false;
        boolean isEmail = false;
        try {
            age = Integer.valueOf(worker[worker.length-1]);
            isAge = true;
        } catch (Exception e) {}
        try {
            email = worker[4];
            isEmail = true;
        } catch (Exception e) {}
        try {
            int checkMailDigit = Integer.parseInt(email);
            isEmail = false;
        } catch (Exception e) {};

        if (isAge && !isEmail){
           return new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment, age);
        } else if(isAge && isEmail){
            return new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment, email, age);
        } else if (!isAge && isEmail){
            return new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment, email);
        } else {
            return new Employee(employeeName, employeeSalary, employeePosition, employeeDepartment);
        }
    }
}
