package daoTests;

import dao.EmployeeDAO;
import dao.EmployeeDaoLocal;
import entities.Employee;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
//import org.junit.jupiter.api.TestMethodOrder;



//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class EmployeeDAOTest {

        static EmployeeDAO employeeDAO = new EmployeeDaoLocal();

        @Test
        //@Order(1)
        void create_employee_test(){
            Employee employee = new Employee(0,"Sarah" ,"Farrens");
            Employee savedEmployee = employeeDAO.createEmployee(employee);
            Assertions.assertNotEquals(0, savedEmployee.getEmpID());

        }

        @Test
        void get_all_employees_test(){
            //create test map
            Map<Integer, Employee> tempTable = new HashMap();

            //add employees
            Employee employee = new Employee(0,"Sarah" ,"Farrens");
            employee = employeeDAO.createEmployee(employee);
            tempTable.put(employee.getEmpID(),employee);

            Employee employee1 = new Employee(0, "James", "Beitz");
            employee1 = employeeDAO.createEmployee(employee1);
            tempTable.put(employee1.getEmpID(),employee1);

            //create output map using employeeDAO
            Map<Integer,Employee> output = new HashMap<>(employeeDAO.getAllEmployees());

            //set boolean and compare employee records
            boolean compTest = false;
            if (tempTable.get(2).equals(output.get(2))) {
                System.out.println("in");
                compTest = true;
            }

            Assertions.assertTrue(compTest);

        }

        @Test
        void get_employee_by_id_2_test() {
            //create test map
            Map<Integer, Employee> tempTable = new HashMap();

            //add employees
            Employee employee = new Employee(0,"Sarah" ,"Farrens");
            employee = employeeDAO.createEmployee(employee);
            tempTable.put(employee.getEmpID(),employee);

            Employee employee1 = new Employee(0, "James", "Beitz");
            employee1 = employeeDAO.createEmployee(employee1);
            tempTable.put(employee1.getEmpID(),employee1);

            //get Employee record from employeeDAO.getEmployeeByID
            Employee employeeTest = new Employee();
            employeeTest = employeeDAO.getEmployeeByID(2);

            Assertions.assertEquals(2, employeeTest.getEmpID());

        }

    @Test
    void get_employee_by_id_0_test() {
        //create test map
        Map<Integer, Employee> tempTable = new HashMap();

        //add employees
        Employee employee = new Employee(0,"Sarah" ,"Farrens");
        employee = employeeDAO.createEmployee(employee);
        tempTable.put(employee.getEmpID(),employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employee1 = employeeDAO.createEmployee(employee1);
        tempTable.put(employee1.getEmpID(),employee1);

        //get Employee record from employeeDAO.getEmployeeByID
        Employee employeeTest = new Employee();
        employeeTest = employeeDAO.getEmployeeByID(0);

        Assertions.assertEquals(0, employeeTest.getEmpID());

    }

    @Test
    void get_employee_by_id_too_high_test() {
        //create test map
        Map<Integer, Employee> tempTable = new HashMap();

        //add employees
        Employee employee = new Employee(0,"Sarah" ,"Farrens");
        employee = employeeDAO.createEmployee(employee);
        tempTable.put(employee.getEmpID(),employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employee1 = employeeDAO.createEmployee(employee1);
        tempTable.put(employee1.getEmpID(),employee1);

        //get Employee record from employeeDAO.getEmployeeByID
        Employee employeeTest = new Employee();
        employeeTest = employeeDAO.getEmployeeByID(5);

        Assertions.assertEquals(0, employeeTest.getEmpID());

    }

    @Test
    void update_employee_1_test () {

        //add employees
        Employee employee = new Employee(0,"Sarah" ,"Farrens");
        employeeDAO.createEmployee(employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employeeDAO.createEmployee(employee1);

        //set update employee
        Employee testEmployee = new Employee(1, "Jack", "Frost");

        //update via employeeDao
        employee = employeeDAO.updateEmployee(testEmployee);

        Assertions.assertEquals("Jack",employee.getEmpFirstName());

    }
    @Test
    void update_employee_0_test () {

        //add employees
        Employee employee = new Employee(0, "Sarah", "Farrens");
        employeeDAO.createEmployee(employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employeeDAO.createEmployee(employee1);

        //set update employee
        Employee testEmployee = new Employee(0, "Jack", "Frost");

        //update via employeeDao
        employee = employeeDAO.updateEmployee(testEmployee);

        Assertions.assertEquals("none", employee.getEmpFirstName());
    }

    @Test
    void update_employee_too_high_test () {

        //add employees
        Employee employee = new Employee(0, "Sarah", "Farrens");
        employeeDAO.createEmployee(employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employeeDAO.createEmployee(employee1);

        //set update employee
        Employee testEmployee = new Employee(5, "Jack", "Frost");

        //update via employeeDao
        employee = employeeDAO.updateEmployee(testEmployee);

        Assertions.assertEquals("none", employee.getEmpFirstName());
    }

    @Test
    void delete_employee_1_test (){

        //add employees
        Employee employee = new Employee(0,"Sarah" ,"Farrens");
        employeeDAO.createEmployee(employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employeeDAO.createEmployee(employee1);

//        employeeDAO.deleteEmployee(1);
//        employee = employeeDAO.getEmployeeByID(1);

        Assertions.assertEquals(1, employeeDAO.deleteEmployee(1));

    }

    @Test
    void delete_employee_0_test (){

        //add employees
        Employee employee = new Employee(0,"Sarah" ,"Farrens");
        employeeDAO.createEmployee(employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employeeDAO.createEmployee(employee1);


        Assertions.assertEquals(0,employeeDAO.deleteEmployee(0));

    }

    @Test
    void delete_employee_too_high_test (){

        //add employees
        Employee employee = new Employee(0,"Sarah" ,"Farrens");
        employeeDAO.createEmployee(employee);

        Employee employee1 = new Employee(0, "James", "Beitz");
        employeeDAO.createEmployee(employee1);


        Assertions.assertEquals(0,employeeDAO.deleteEmployee(5));

    }


}
