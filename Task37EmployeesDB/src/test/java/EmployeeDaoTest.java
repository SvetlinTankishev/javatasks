import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoTest {

    private EmployeeDao employeeDao;

    @BeforeEach
    public void setup() {
        employeeDao = new EmployeeDaoImplementation();
    }



    @Test
    public void testInsertEmployee() {
        // Create a new Employee instance
        Employee newEmployee = new Employee(1, "John", "Doe", "05.12.1964", "HR", 5000.0);

        // Insert the employee
        employeeDao.insertEmployee(newEmployee);

        // Get the employee by ID and check if it matches the inserted data
        Employee retrievedEmployee = employeeDao.getEmployeeById(1);
        assertNotNull(retrievedEmployee);
        assertEquals("John", retrievedEmployee.getFirstName());
        assertEquals("Doe", retrievedEmployee.getLastName());
        // Add more assertions for other properties
    }

    @Test
    public void testUpdateEmployee() {
        // Assuming employee with ID 2 exists
        Employee employeeToUpdate = employeeDao.getEmployeeById(2);
        assertNotNull(employeeToUpdate);

        // Update employee's salary
        double newSalary = 60000.0;
        employeeToUpdate.setSalary(newSalary);
        employeeDao.updateEmployee(employeeToUpdate);

        // Get the updated employee and check if the salary is updated
        Employee updatedEmployee = employeeDao.getEmployeeById(2);
        assertNotNull(updatedEmployee);
        assertEquals(newSalary, updatedEmployee.getSalary(), 0.01); // Using delta for double comparison
    }


    @Test
    public void testGetAllEmployees() {
        // Insert test employees
        Employee newEmployee1 = new Employee(1, "John", "Doe", "05.12.1964", "HR", 5000.0);
        Employee newEmployee2 = new Employee(2, "Jane", "Smith", "08.15.1980", "IT", 6000.0);
        employeeDao.insertEmployee(newEmployee1);
        employeeDao.insertEmployee(newEmployee2);

        // Get all employees and check if they match the inserted data
        List<Employee> employees = employeeDao.getAllEmployees();
        assertNotNull(employees);
        assertEquals(2, employees.size());

        Employee retrievedEmployee1 = employees.get(0);
        assertEquals("John", retrievedEmployee1.getFirstName());
        assertEquals("Doe", retrievedEmployee1.getLastName());
        // Add more assertions for other properties

        Employee retrievedEmployee2 = employees.get(1);
        assertEquals("Jane", retrievedEmployee2.getFirstName());
        assertEquals("Smith", retrievedEmployee2.getLastName());
        // Add more assertions for other properties
    }

    @Test
    public void testGetEmployeeById() {
        // Insert a test employee
        Employee newEmployee = new Employee(1, "John", "Doe", "05.12.1964", "HR", 5000.0);
        employeeDao.insertEmployee(newEmployee);

        // Get the employee by ID and check if it matches the inserted data
        Employee retrievedEmployee = employeeDao.getEmployeeById(1);
        assertNotNull(retrievedEmployee);
        assertEquals("John", retrievedEmployee.getFirstName());
        assertEquals("Doe", retrievedEmployee.getLastName());
        // Add more assertions for other properties
    }

    @Test
    public void testDeleteEmployee() {
        // Insert a test employee
        Employee newEmployee = new Employee(1, "John", "Doe", "05.12.1964", "HR", 5000.0);
        employeeDao.insertEmployee(newEmployee);

        // Delete the employee and check if it's no longer in the database
        employeeDao.deleteEmployee(1);
        Employee deletedEmployee = employeeDao.getEmployeeById(1);
        assertNull(deletedEmployee);
    }

    @Test
    public void testDeleteNonExistentEmployee() {
        // Attempt to delete an employee that doesn't exist
        int nonExistentEmployeeId = 999;
        employeeDao.deleteEmployee(nonExistentEmployeeId);

        // Verify that the employee is still not in the database
        Employee nonExistentEmployee = employeeDao.getEmployeeById(nonExistentEmployeeId);
        assertNull(nonExistentEmployee);
    }

    @Test
    public void testUpdateNonExistentEmployee() {
        // Attempt to update an employee that doesn't exist
        Employee nonExistentEmployee = new Employee(999, "Non", "Existent", "01.01.1990", "Department", 5000.0);
        employeeDao.updateEmployee(nonExistentEmployee);

        // Verify that the employee is still not in the database
        Employee retrievedEmployee = employeeDao.getEmployeeById(999);
        assertNull(retrievedEmployee);
    }

    @Test
    public void testGetNonExistentEmployeeById() {
        // Attempt to retrieve an employee with an ID that doesn't exist
        Employee nonExistentEmployee = employeeDao.getEmployeeById(999);

        // Verify that the retrieved employee is null
        assertNull(nonExistentEmployee);
    }

    @Test
    public void testGetAllEmployeesEmptyDatabase() {
        // Delete all employees to simulate an empty database
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.deleteEmployee(employee.getId());
        }

        // Retrieve all employees and verify that the list is empty
        List<Employee> emptyEmployees = employeeDao.getAllEmployees();
        assertNotNull(emptyEmployees);
        assertEquals(0, emptyEmployees.size());
    }

    @Test
    public void testUpdateEmployeeWithInvalidSalary() {
        // Attempt to update an employee with negative salary
        Employee employeeToUpdate = employeeDao.getEmployeeById(2);
        assertNotNull(employeeToUpdate);

        // Update employee's salary with an invalid value
        double invalidSalary = -1000.0;
        employeeToUpdate.setSalary(invalidSalary);
        employeeDao.updateEmployee(employeeToUpdate);

        // Get the updated employee and verify that the salary is unchanged
        Employee updatedEmployee = employeeDao.getEmployeeById(2);
        assertNotNull(updatedEmployee);
        assertNotEquals(invalidSalary, updatedEmployee.getSalary(), 0.01); // Using delta for double comparison
    }

    @Test
    public void testInsertEmployeeWithSpecialCharactersInName() {
        // Attempt to insert an employee with special characters in their names
        Employee specialEmployee = new Employee(999, "Spécial", "Ch@racter$", "01.01.1990", "Department", 5000.0);
        employeeDao.insertEmployee(specialEmployee);

        // Get the inserted employee and verify that the names are stored correctly
        Employee insertedEmployee = employeeDao.getEmployeeById(999);
        assertNotNull(insertedEmployee);
        assertEquals("Spécial", insertedEmployee.getFirstName());
        assertEquals("Ch@racter$", insertedEmployee.getLastName());
    }
}
