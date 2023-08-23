import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.mockito.Mockito.*;

public class SalaryUpdaterTest {

    private EmployeeDaoImplementation mockEmployeeDao;
    private SalaryUpdater salaryUpdater;

    @BeforeEach
    public void setup() {

        mockEmployeeDao = spy(new EmployeeDaoImplementation());

        String url = "jdbc:mysql://localhost:3306/employeesdb_test";
        String username = "root";
        String password = "databasepassword";
        mockEmployeeDao.setDatabaseConnection(url, username, password);

        salaryUpdater = new SalaryUpdater(mockEmployeeDao);
    }

    @Test
    public void testUpdateSalariesForDepartment() throws SQLException {
        // Mocked connection and statement
        Connection mockConnection = mock(Connection.class);
        CallableStatement mockCallableStatement = mock(CallableStatement.class);

        // Mocked input values
        String department = "HR";
        double raiseAmount = 1000.0;

        // Set up expectations
        when(mockEmployeeDao.getURL()).thenReturn("jdbc:mysql://localhost:3306/employeesdb_test");
        when(mockEmployeeDao.getUSERNAME()).thenReturn("root");
        when(mockEmployeeDao.getPASSWORD()).thenReturn("databasepassword");
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        when(mockCallableStatement.execute()).thenReturn(true);

        // Call the method to be tested
        salaryUpdater.updateSalariesForDepartment(department, raiseAmount);

        // Verify that the appropriate methods were called
        verify(mockCallableStatement).setString(1, department);
        verify(mockCallableStatement).setDouble(2, raiseAmount);
        verify(mockCallableStatement).registerOutParameter(3, java.sql.Types.INTEGER);
        verify(mockCallableStatement).registerOutParameter(4, java.sql.Types.VARCHAR);
        verify(mockCallableStatement).execute();

        // Additional assertions or verifications if needed
    }

    @Test
    public void testIncreaseSalariesWithInflation() throws SQLException {
        // Mocked connection and statement
        Connection mockConnection = mock(Connection.class);
        CallableStatement mockCallableStatement = mock(CallableStatement.class);

        // Mocked input value
        double inflationRate = 2.9;

        // Set up expectations
        when(mockEmployeeDao.getURL()).thenReturn("jdbc:mysql://localhost:3306/employeesdb_test"); // Mock the behavior here
        when(mockEmployeeDao.getUSERNAME()).thenReturn("root");
        when(mockEmployeeDao.getPASSWORD()).thenReturn("databasepassword");
        when(mockConnection.prepareCall(anyString())).thenReturn(mockCallableStatement);
        when(mockCallableStatement.execute()).thenReturn(true);

        // Call the method to be tested
        salaryUpdater.increaseSalariesWithInflation(inflationRate);

        // Verify that the appropriate methods were called
        verify(mockCallableStatement).setDouble(1, inflationRate);
        verify(mockCallableStatement).registerOutParameter(2, java.sql.Types.INTEGER);
        verify(mockCallableStatement).registerOutParameter(3, java.sql.Types.VARCHAR);


        verify(mockCallableStatement).execute();

        // Additional assertions or verifications if needed
    }
}
