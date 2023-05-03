package Company;

import Company.Departments.Department;
import Company.Departments.Employees.Manager;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private final List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
    }


    public Manager getManagerByDepartmentName(String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department.getManager();
            }
        }
        return null;
    }

    public int getVacationDaysByDepartmentName(String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department.getDepartmentVacationDays();
            }
        }
        return 0;
    }

    public double getTaxesByDepartmentName(String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department.getDepartmentTaxes();
            }
        }
        return 0;
    }

    public double getCompanyTaxes() {
        double taxes = 0;
        for (Department department : departments) {
            taxes += department.getDepartmentTaxes();
        }
        return taxes;
    }




}
