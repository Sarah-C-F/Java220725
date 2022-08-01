package dao;

import entities.Employee;

import java.util.Map;

public interface EmployeeDAO {

    //create
    Employee createEmployee(Employee employee);

    //Read
    Map<Integer, Employee> getAllEmployees();
    Employee getEmployeeByID(int id);

    //Update
    Employee updateEmployee(Employee employee);

    //Delete
    int deleteEmployee(int id);

}
