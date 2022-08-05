package dao.employeeDaos;

import entities.employees.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoLocal implements EmployeeDAO{

    private Map<Integer, Employee> employeeTable = new HashMap();
    private int idMaker = 1;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setEmployeeID(idMaker);
        idMaker++;
        employeeTable.put(employee.getEmployeeID(),employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;

    }

    @Override
    public Employee getEmployeeByID(int id){
        Employee employee = new Employee(0, "none", "none");
        for (int i = 0; i < employeeTable.size(); i++){
            if (employeeTable.containsKey(id)) {
                employee = employeeTable.get(id);
            }
        }
        return employee;
    }

    @Override
    public String updateEmployee (Employee employee) {
        Employee employee1 = new Employee(0, "none", "none");
        for (int i = 0; i < employeeTable.size(); i++){
            if (employeeTable.containsKey(employee.getEmployeeID())) {
                employeeTable.put(employee.getEmployeeID(),employee);
                employee1 = employee;
            }
        }
        return "success";
    }

    @Override
    public int deleteEmployee (int id){
        int result = 0;
        if (employeeTable.containsKey(id)) {
            result = id;
            employeeTable.remove(id);
        }


        return result;
    }
}
