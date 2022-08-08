package dao.employeeDaos;

import entities.employees.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

    //create
    Employee createEmployee(Employee employee);

    //Read
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(int id);

    //Update
    String updateEmployee(Employee employee);

    //Delete
    int deleteEmployee(int id);

}
