/*import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SalaryUpdater {
    private static EmployeeDaoImplementation employeeDao;

    public SalaryUpdater(EmployeeDaoImplementation employeeDao) {
        SalaryUpdater.employeeDao = employeeDao;
    }
    public static void updateSalariesForDepartment(String department, double raiseAmount) {
        String url = employeeDao.getURL();
        String username = employeeDao.getUSERNAME();
        String password = employeeDao.getPASSWORD();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             CallableStatement callableStatement = connection.prepareCall("{call UpdateSalariesForDepartment(?, ?, ?, ?)}")) {

            // Set the input parameters
            callableStatement.setString(1, department);
            callableStatement.setDouble(2, raiseAmount);

            // Register the output parameters
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);

            // Execute the stored procedure
            callableStatement.execute();

            // Get the output parameters
            int updatedCount = callableStatement.getInt(3);
            String message = callableStatement.getString(4);

            System.out.println("Updated employees count: " + updatedCount);
            System.out.println("Message: " + message);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}*/
