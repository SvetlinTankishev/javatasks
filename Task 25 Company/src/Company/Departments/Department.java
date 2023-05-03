package Company.Departments;

import Company.Departments.Employees.Employee;
import Company.Departments.Employees.FullTimeEmployee;
import Company.Departments.Employees.Manager;
import Company.Departments.Employees.PartTimeEmployee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String name;
    private final Manager manager;
    private final List<Employee> employees = new ArrayList<>();

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

    public int getDepartmentVacationDays() {
        int vacationDays = 0;
        for (Employee employee : employees) {
            vacationDays += employee.getEmployeeVacationDays();
        }
        return vacationDays;
    }

    public double getDepartmentTaxes() {
        double taxes = 0;
        for (Employee employee : employees) {
            if (employee instanceof FullTimeEmployee) {
                taxes += employee.getEmployeeTaxes();
            } else if (employee instanceof PartTimeEmployee) {
                taxes += employee.getEmployeeTaxes();
            }
        }
        return taxes;
    }
}
