package Company.Departments.Employees;

public class FullTimeEmployee extends Employee {

    private static final int VACATION_DAYS = 30;
    private static final double TAX_RATE = 0.2;

    public FullTimeEmployee(String name, String email, double salary) {
        super(name, email, VACATION_DAYS, salary);
    }

    public double getTaxes() {
        return getSalary() * TAX_RATE;
    }
}
