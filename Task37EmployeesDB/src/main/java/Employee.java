public class Employee {
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String department;
    private double salary;

    public Employee(int id, String firstName, String lastName, String birthDate, String department, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.department = department;
        this.salary = salary;
    }

    private final int id;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
