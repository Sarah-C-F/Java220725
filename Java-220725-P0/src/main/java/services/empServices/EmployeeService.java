package services.empServices;

import entities.employees.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeByID(int id);

   int deleteEmployee(int id);

   String updateEmployee(Employee employee);

}
