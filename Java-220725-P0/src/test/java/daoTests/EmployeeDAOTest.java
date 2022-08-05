package daoTests;

import dao.employeeDaos.EmployeeDAO;
import dao.employeeDaos.EmployeeDaoPostgres;
import entities.employees.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmployeeDAOTest {

        static EmployeeDAO employeeDAO = new EmployeeDaoPostgres();

        //CREATE

    @Test
    void create_employee_test(){
        Employee employee = new Employee(0,"sarah", "Farrens");
        Employee savedEmployee = employeeDAO.createEmployee(employee);

        Assertions.assertNotEquals(0, savedEmployee.getEmployeeID());

    }

    @Test
    void create_employee_invalid_id_test(){
        Employee employee = new Employee('x', "Sarah" ,"Farrens");
        Employee savedEmployee = employeeDAO.createEmployee(employee);

        Assertions.assertEquals(1, savedEmployee.getEmployeeID());
    }

        //GET ALL

//    @Test
//    void get_all_employees_test(){
//        //create test map
//        Map<Integer, Employee> tempTable = new HashMap();
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE, "Sarah" ,"Farrens");
//        employee = employeeDAO.createEmployee(employee);
//        tempTable.put(employee.getEmployeeID(),employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employee1 = employeeDAO.createEmployee(employee1);
//        tempTable.put(employee1.getEmployeeID(),employee1);
//
//        //create output map using employeeDAO
//        Map<Integer,Employee> output = new HashMap<>(employeeDAO.getAllEmployees());
//
//        //set boolean and compare employee records
//        boolean compTest = false;
//        if (tempTable.get(2).equals(output.get(2))) {
//            System.out.println("in");
//            compTest = true;
//        }
//        Assertions.assertTrue(compTest);
//    }
//
//    //GET BY ID
//
//    @Test
//    void get_employee_by_id_2_test() {
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        //get Employee record from employeeDAO.getEmployeeByID
//        //if not assigned separately, breaks
//        Employee employeeTest = new Employee();
//        employeeTest = employeeDAO.getEmployeeByID(2);
//
//        Assertions.assertEquals(2, employeeTest.getEmployeeID());
//    }
//
//    @Test
//    void get_employee_by_id_0_test() {
//       //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        //get Employee record from employeeDAO.getEmployeeByID
//        //if not assigned separately, breaks
//        Employee employeeTest = new Employee();
//        employeeTest = employeeDAO.getEmployeeByID(0);
//
//        Assertions.assertEquals(0, employeeTest.getEmployeeID());
//
//    }
//
//    @Test
//    void get_employee_by_id_too_high_test() {
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        //get Employee record from employeeDAO.getEmployeeByID
//        //if not assigned separately, breaks
//        Employee employeeTest = new Employee();
//        employeeTest = employeeDAO.getEmployeeByID(5);
//
//        Assertions.assertEquals(0, employeeTest.getEmployeeID());
//    }
//
//    @Test
//    void get_employee_by_id_other_char_test() {
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        //get Employee record from employeeDAO.getEmployeeByID
//        //if not assigned separately, breaks
//        Employee employeeTest = new Employee();
//        employeeTest = employeeDAO.getEmployeeByID('x');
//
//        Assertions.assertEquals(0, employeeTest.getEmployeeID());
//    }
//
//    //UPDATE
//
//    @Test
//    void update_employee_1_test () {
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        //set update employee
//        Employee testEmployee = new Employee(1, EmployeeType.ASSOCIATE, "Jack", "Frost");
//
//        //update via employeeDao
//        employee = employeeDAO.updateEmployee(testEmployee);
//
//        Assertions.assertEquals("Jack",employee.getEmployeeFirstName());
//    }
//
//    @Test
//    void update_employee_0_test () {
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE, "Sarah", "Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        //set update employee
//        Employee testEmployee = new Employee(0, EmployeeType.ASSOCIATE, "Jack", "Frost");
//
//        //update via employeeDao
//        employee = employeeDAO.updateEmployee(testEmployee);
//
//        Assertions.assertEquals("none", employee.getEmployeeFirstName());
//    }
//
//    @Test
//    void update_employee_too_high_test () {
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE, "Sarah", "Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        //set update employee
//        Employee testEmployee = new Employee(5, EmployeeType.ASSOCIATE, "Jack", "Frost");
//
//        //update via employeeDao
//        employee = employeeDAO.updateEmployee(testEmployee);
//
//        Assertions.assertEquals("none", employee.getEmployeeFirstName());
//    }
//
//    @Test
//    void update_employee_other_char_test () {
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE, "Sarah", "Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        //set update employee
//        Employee testEmployee = new Employee('x', EmployeeType.ASSOCIATE, "Jack", "Frost");
//
//        //update via employeeDao
//        employee = employeeDAO.updateEmployee(testEmployee);
//
//        Assertions.assertEquals("none", employee.getEmployeeFirstName());
//    }
//
//    //DELETE
//
//    @Test
//    void delete_employee_1_test (){
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        Assertions.assertEquals(1, employeeDAO.deleteEmployee(1));
//    }
//
//    @Test
//    void delete_employee_0_test (){
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        Assertions.assertEquals(0,employeeDAO.deleteEmployee(0));
//    }
//
//    @Test
//    void delete_employee_too_high_test (){
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        Assertions.assertEquals(0,employeeDAO.deleteEmployee(5));
//
//    }
//
//    @Test
//    void delete_employee_other_char_test (){
//
//        //add employees
//        Employee employee = new Employee(0, EmployeeType.ASSOCIATE,"Sarah" ,"Farrens");
//        employeeDAO.createEmployee(employee);
//
//        Employee employee1 = new Employee(0, EmployeeType.ASSOCIATE, "James", "Beitz");
//        employeeDAO.createEmployee(employee1);
//
//        Assertions.assertEquals(0,employeeDAO.deleteEmployee('*'));
//
//    }
//
//
}
