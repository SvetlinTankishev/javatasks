import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoImplementation employeeDao = new EmployeeDaoImplementation();
        SalaryUpdater salaryUpdater = new SalaryUpdater(employeeDao);
        int maxId = employeeDao.getMaxEmployeeId();
        int nextId = maxId + 1;

        // Test insert
        Employee newEmployee = new Employee(nextId++, "John", "Doe", "05.12.1964", "HR", 5000.0);
        Employee newEmployee1 = new Employee(nextId++, "Johnny", "Depp", "05.05.1964", "Peon", 6000.0);
        Employee newEmployee2 = new Employee(nextId++, "Johntra", "Volta", "05.06.1954", "HR", 7000.0);
        Employee newEmployee3 = new Employee(nextId++, "Johnsey", "Thedoe", "05.07.1984", "OpaGolen", 3000.0);
        Employee newEmployee4 = new Employee(nextId++, "John", "Doe", "05.06.1967", "WorkWork", 10000.0);
        employeeDao.insertEmployee(newEmployee);
        employeeDao.insertEmployee(newEmployee1);
        employeeDao.insertEmployee(newEmployee2);
        employeeDao.insertEmployee(newEmployee3);
        employeeDao.insertEmployee(newEmployee4);

        // Test update
        Employee employeeToUpdate = employeeDao.getEmployeeById(2);
        if (employeeToUpdate != null) {
            employeeToUpdate.setSalary(55000.0);
            employeeDao.updateEmployee(employeeToUpdate);
        }

        // Test get all employees
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName());
        }

        // Test delete
        int employeeIdToDelete = 1;
        employeeDao.deleteEmployee(employeeIdToDelete);

        salaryUpdater.updateSalariesForDepartment("HR", 1000.0);
        salaryUpdater.increaseSalariesWithInflation(2.9);
    }
}