package services;

import dao.EmployeeDAO;
import entities.Employee;

import java.util.Map;

public class EmployeeServiceLocal implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceLocal(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee saveEmployee = this.employeeDAO.createEmployee(employee);
        return saveEmployee;
    }

    @Override
    public Map<Integer, Employee> getAllEmployee() {

        return this.employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return this.employeeDAO.getEmployeeByID(id);
    }

    ;

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeDAO.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(int id) {
        return this.employeeDAO.deleteEmployee(id);
    }
}
