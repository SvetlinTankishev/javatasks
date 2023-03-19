package Company.Departments;

import Company.Departments.Employees.Employee;
import Company.Departments.Employees.FullTimeEmployee;
import Company.Departments.Employees.Manager;
import Company.Departments.Employees.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Manager manager;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public int getVacationDays() {
        int vacationDays = 0;
        for (Employee employee : employees) {
            vacationDays += employee.getVacationDays();
        }
        return vacationDays;
    }

    public double getTaxes() {
        double taxes = 0;
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                taxes += employee.getTaxes();
            } else if (employee instanceof PartTimeEmployee) {
                taxes += employee.getTaxes();
            }
        }
        return taxes;
    }
}
