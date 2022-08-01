package services;

import entities.Employee;

import java.util.Map;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Map<Integer, Employee> getAllEmployee();

    Employee getEmployeeByID(int id);

   int deleteEmployee(int id);

   Employee updateEmployee(Employee employee);

}
