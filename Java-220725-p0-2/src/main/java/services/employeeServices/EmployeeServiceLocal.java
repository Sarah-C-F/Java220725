package services.employeeServices;

import dao.employeeDaos.EmployeeDAO;
import entities.employees.Employee;

import java.util.List;

public class EmployeeServiceLocal implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceLocal(){}

    public EmployeeServiceLocal(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override

    public Employee createEmployee(Employee employee) {
        Employee savedEmployee = this.employeeDAO.createEmployee(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAllEmployee() {

        return this.employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return this.employeeDAO.getEmployeeByID(id);
    }

    ;

    @Override
    public String updateEmployee(Employee employee) {
        return this.employeeDAO.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return this.employeeDAO.deleteEmployee(id);
    }
}
