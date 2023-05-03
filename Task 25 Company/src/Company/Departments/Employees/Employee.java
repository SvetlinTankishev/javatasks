package Company.Departments.Employees;

public class Employee {
    private final String name;
    private final String email;
    private final int vacationDays;
    private final double salary;

    public Employee(String name, String email, int vacationDays, double salary) {
        this.name = name;
        this.email = email;
        this.vacationDays = vacationDays;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getEmployeeVacationDays() {
        return vacationDays;
    }

    public double getEmployeeSalary() {
        return salary;
    }

    public double getEmployeeTaxes() {
        return 0.0;
    }
}
