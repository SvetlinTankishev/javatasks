package Company.Departments.Employees;

public class Employee {
    private String name;
    private String email;
    private int vacationDays;
    private double salary;

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

    public int getVacationDays() {
        return vacationDays;
    }

    public double getSalary() {
        return salary;
    }

    public double getTaxes() {
        return 0.0;
    }
}
