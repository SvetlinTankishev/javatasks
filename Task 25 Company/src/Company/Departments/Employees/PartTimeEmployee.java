package Company.Departments.Employees;

public class PartTimeEmployee extends Employee {
    private static final int VACATION_DAYS = 20;
    private static final double TAX_RATE = 0.1;

    public PartTimeEmployee(String name, String email, double salary) {
        super(name, email, VACATION_DAYS, salary);
    }

    public double getTaxes() {
        return getSalary() * TAX_RATE;
    }
}
