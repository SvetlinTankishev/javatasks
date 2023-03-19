import Company.Company;
import Company.Departments.Department;
import Company.Departments.Employees.FullTimeEmployee;
import Company.Departments.Employees.Manager;
import Company.Departments.Employees.PartTimeEmployee;


public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        Manager financeManager = new Manager("Jolly Kane", "jolly.kane@sap.com", 130000);
        Manager engineeringManager = new Manager("James Loe", "j.loe@sap.com", 155000);

        FullTimeEmployee employee1 = new FullTimeEmployee("John Doe", "john.doe@sap.com", 70000.0);
        PartTimeEmployee employee2 = new PartTimeEmployee("Jane Smith", "jane.smith@sap.com", 55000.0);
        PartTimeEmployee employee3 = new PartTimeEmployee("Bob Johnson", "bob.johnson@sap.com", 50000.0);
        FullTimeEmployee employee4 = new FullTimeEmployee("Tom Lee", "tom.lee@sap.com", 135000.0);
        PartTimeEmployee employee5 = new PartTimeEmployee("Sarah Kim", "sarah.kim@sap.com", 75000.0);

        Department financeDepartment = new Department("Finance Department", financeManager);
        financeDepartment.addEmployee(employee1);
        financeDepartment.addEmployee(employee2);
        financeDepartment.addEmployee(employee3);

        Department engineeringDepartment = new Department("Engineering Department", engineeringManager);
        engineeringDepartment.addEmployee(employee4);
        engineeringDepartment.addEmployee(employee5);

        company.addDepartment(financeDepartment);
        company.addDepartment(engineeringDepartment);

        System.out.println("Manager of Finance Department: " + company.getManagerByDepartmentName("Finance Department").getName());
        System.out.println("Vacation days of Finance Department: " + company.getVacationDaysByDepartmentName("Finance Department"));
        System.out.println("Taxes of Finance Department: " + company.getTaxesByDepartmentName("Finance Department"));
        System.out.println();

        System.out.println("Manager of Engineering Department: " + company.getManagerByDepartmentName("Engineering Department").getName());
        System.out.println("Vacation days of Engineering Department: " + company.getVacationDaysByDepartmentName("Engineering Department"));
        System.out.println("Taxes of Engineering Department: " + company.getTaxesByDepartmentName("Engineering Department"));
        System.out.println();

        System.out.println("Taxes of the company: " + company.getTaxes());

    }
}