package employeeTests;

import dao.employeeDaos.EmployeeDAO;
import dao.employeeDaos.EmployeeDaoPostgres;
import entities.employees.Employee;
import org.junit.jupiter.api.*;
import utils.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTests {

    static EmployeeDAO employeeDao = new EmployeeDaoPostgres();

    @BeforeAll
    static void connect() {
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "delete from expenses; delete from \"employees\";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    @Order(1)
    void create_employee_test_standard() {

            Employee testEmployee = new Employee(131, "john", "Doe");
            Employee resultEmployee = employeeDao.createEmployee(testEmployee);

            Assertions.assertEquals(testEmployee, resultEmployee);
    }

    @Test
    @Order(2)
    void create_employee_test_id_0 () {
        Employee testEmployee = new Employee(0, "jack", "Doe");
        Employee resultEmployee = employeeDao.createEmployee(testEmployee);

        Assertions.assertEquals(132, resultEmployee.getEmployeeID());
    }

    @Test
    @Order(3)
    void create_employee_test_id_10000 () {
        Employee testEmployee = new Employee(10000, "jill", "Doe");
        Employee resultEmployee = employeeDao.createEmployee(testEmployee);

        Assertions.assertEquals(133, resultEmployee.getEmployeeID());
    }

    @Test
    @Order(4)
    void create_employee_test_id_decimal () {
        Employee testEmployee = new Employee((int)50.26, "jill", "Doe");
        Employee resultEmployee = employeeDao.createEmployee(testEmployee);

        Assertions.assertEquals(134, resultEmployee.getEmployeeID());
    }

    @Test
    @Order(5)
    void get_all_employees_test () {
        List<Employee> testList;
        testList = employeeDao.getAllEmployees();

        Assertions.assertEquals(4,testList.size());

    }

    @Test
    @Order(6)
    void get_employee_by_id_test_standard () {
        Employee resultEmployee = new Employee(132, "jack", "doe");
        Employee testEmployee = employeeDao.getEmployeeByID(132);

        Assertions.assertEquals(resultEmployee.getEmployeeFirstName(), testEmployee.getEmployeeFirstName());
    }

    @Test
    @Order(7)
    void get_employee_by_id_no_record () {
        Employee testEmployee = employeeDao.getEmployeeByID(10000);

        Assertions.assertEquals(0, testEmployee.getEmployeeID());
    }

    @Test
    @Order(8)
    void update_employee_test_last_name() {
        Employee testEmployee = new Employee(131, "jack", "face");
        String result = employeeDao.updateEmployee(testEmployee);

        Assertions.assertEquals("Employee updated!", result);
    }

    @Test
    @Order(9)
    void update_employee_test_first_name () {
        Employee testEmployee = new Employee(131, "Jim", "doe");
        String result = employeeDao.updateEmployee(testEmployee);

        Assertions.assertEquals("Employee updated!", result);
    }

    @Test
    @Order(10)
    void update_employee_test_no_record () {
        Employee testEmployee = new Employee(10000, "jack", "face");
        String result = employeeDao.updateEmployee(testEmployee);

        Assertions.assertEquals("No record found", result);
    }

    @Test
    @Order(11)
    void delete_employee_test_standard () {
        Employee testEmployee = new Employee(131, "jack", "doe");
        int result = employeeDao.deleteEmployee(testEmployee.getEmployeeID());

        Assertions.assertEquals(testEmployee.getEmployeeID(),result);
    }

    @Test
    @Order(12)
    void delete_employee_test_no_record () {
        Employee testEmployee = new Employee(10000, "george", "face");
        int result = employeeDao.deleteEmployee(testEmployee.getEmployeeID());

        Assertions.assertEquals(0,result);
    }
}