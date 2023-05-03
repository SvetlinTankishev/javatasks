package Company.Departments.Employees;

public class FullTimeEmployee extends Employee {
    protected static final int VACATION_DAYS = 30;
    protected static final double TAX_RATE = 0.2;

    public FullTimeEmployee(String name, String email, double salary) {
        super(name, email, VACATION_DAYS, salary);
    }

    @Override
    public double getEmployeeTaxes() {
        return getEmployeeSalary() * TAX_RATE;
    }
}
