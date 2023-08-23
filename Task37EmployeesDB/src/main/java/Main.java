import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        employeeDao = new EmployeeDaoImplementation();
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

        updateSalariesForDepartment("HR", 1000.0);
    }

    private static EmployeeDaoImplementation employeeDao;
    public static void updateSalariesForDepartment(String department, double raiseAmount) {
        String url = employeeDao.getURL();
        String username = employeeDao.getUSERNAME();
        String password = employeeDao.getPASSWORD();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             CallableStatement callableStatement = connection.prepareCall("{call IncreaseSalariesForDepartment(?, ?, ?, ?)}")) {

            // Set the input parameters
            callableStatement.setString(1, department);
            callableStatement.setDouble(2, raiseAmount);

            // Set output parameters
            callableStatement.registerOutParameter(3, Types.INTEGER);  // updatedCount
            callableStatement.registerOutParameter(4, Types.VARCHAR);  // message

            // Execute the stored procedure
            callableStatement.execute();

            // Get the output parameters
            int updatedCount = callableStatement.getInt(3);
            String message = callableStatement.getString(4);

            System.out.println("Salary update successful. " + updatedCount + " employees updated. Message: " + message);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}