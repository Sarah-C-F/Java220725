package dao;

import entities.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDaoLocal implements EmployeeDAO{

    private Map<Integer, Employee> employeeTable = new HashMap();
    private int idMaker = 1;

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setEmpID(idMaker);
        idMaker++;
        employeeTable.put(employee.getEmpID(),employee);
        return employee;
    }

    @Override
    public Map<Integer, Employee> getAllEmployees() {
        return (Map<Integer, Employee>) this.employeeTable;

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
    public Employee updateEmployee (Employee employee) {
        Employee employee1 = new Employee(0, "none", "none");
        for (int i = 0; i < employeeTable.size(); i++){
            if (employeeTable.containsKey(employee.getEmpID())) {
                employeeTable.put(employee.getEmpID(),employee);
                employee1 = employee;
            }
        }
        return employee1;
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
