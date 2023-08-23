import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class SalaryUpdater {

    private final EmployeeDaoImplementation employeeDao;

    public SalaryUpdater(EmployeeDaoImplementation employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void updateSalariesForDepartment(String department, double raiseAmount) {
        String url = employeeDao.getURL();
        String username = employeeDao.getUSERNAME();
        String password = employeeDao.getPASSWORD();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             CallableStatement callableStatement = connection.prepareCall("{call IncreaseSalariesForDepartment(?, ?, ?, ?)}")) {


            callableStatement.setString(1, department);
            callableStatement.setDouble(2, raiseAmount);


            callableStatement.registerOutParameter(3, Types.INTEGER);  // updatedCount
            callableStatement.registerOutParameter(4, Types.VARCHAR);  // message


            callableStatement.execute();


            int updatedCount = callableStatement.getInt(3);
            String message = callableStatement.getString(4);

            System.out.println("Salary update successful. " + updatedCount + " employees updated. Message: " + message);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void increaseSalariesWithInflation(double inflationRate) {
        String url = employeeDao.getURL();
        String username = employeeDao.getUSERNAME();
        String password = employeeDao.getPASSWORD();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             CallableStatement callableStatement = connection.prepareCall("{call IncreaseSalariesWithInflation(?, ?, ?)}")) {

            callableStatement.setDouble(1, inflationRate);

            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.registerOutParameter(3, Types.VARCHAR);

            callableStatement.execute();

            int updatedCount = callableStatement.getInt(2);
            String message = callableStatement.getString(3);

            System.out.println("Salary update successful. " + message);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
