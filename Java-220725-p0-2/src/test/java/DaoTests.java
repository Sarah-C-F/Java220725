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
public class DaoTests {

    static EmployeeDAO employeeDao = new EmployeeDaoPostgres();

    @BeforeAll
    static void connect() {
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "drop table \"employees\";\n" +
                    "\n" +
                    "CREATE TABLE \"employees\"\n" +
                    "(\n" +
                    "    \"employee_id\" INT NOT null primary key,    \n" +
                    "    \"firstname\" VARCHAR(20) NOT null,\n" +
                    "  \t\"lastname\" VARCHAR(20) NOT NULL\n" +
                    ");";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    @Order(1)
    void create_employee_test_standard() {

            Employee testEmployee = new Employee(168, "john", "Doe");
            Employee resultEmployee = employeeDao.createEmployee(testEmployee);

            Assertions.assertEquals(testEmployee, resultEmployee);
    }

    @Test
    @Order(2)
    void create_employee_test_id_0 () {
        Employee testEmployee = new Employee(0, "jack", "Doe");
        Employee resultEmployee = employeeDao.createEmployee(testEmployee);

        Assertions.assertEquals(169, resultEmployee.getEmployeeID());
    }

    @Test
    @Order(3)
    void create_employee_test_id_10000 () {
        Employee testEmployee = new Employee(10000, "jill", "Doe");
        Employee resultEmployee = employeeDao.createEmployee(testEmployee);

        Assertions.assertEquals(170, resultEmployee.getEmployeeID());
    }

    @Test
    @Order(4)
    void get_all_employees_test () {
        List<Employee> testList = new ArrayList<Employee>();
        testList = employeeDao.getAllEmployees();
        Employee resultEmployee = new Employee(170, "jill", "Doe");
        Employee testEmployee = testList.get(2);
        Assertions.assertEquals(resultEmployee.getEmployeeFirstName(),testEmployee.getEmployeeFirstName());

    }

    @Test
    @Order(5)
    void get_employee_by_id_test_standard () {
        Employee resultEmployee = new Employee(169, "jack", "doe");
        Employee testEmployee = employeeDao.getEmployeeByID(169);

        Assertions.assertEquals(resultEmployee.getEmployeeFirstName(), testEmployee.getEmployeeFirstName());
    }

    @Test
    @Order(6)
    void get_employee_by_id_no_record () {
        Employee testEmployee = employeeDao.getEmployeeByID(10000);

        Assertions.assertEquals(0, testEmployee.getEmployeeID());
    }

    @Test
    @Order(7)
    void update_employee_test_last_name() {
        Employee testEmployee = new Employee(169, "jack", "face");
        String result = employeeDao.updateEmployee(testEmployee);

        Assertions.assertEquals("Employee updated!", result);
    }

    @Test
    @Order(8)
    void update_employee_test_first_name () {
        Employee testEmployee = new Employee(169, "Jim", "doe");
        String result = employeeDao.updateEmployee(testEmployee);

        Assertions.assertEquals("Employee updated!", result);
    }

    @Test
    @Order(9)
    void update_employee_test_no_record () {
        Employee testEmployee = new Employee(10000, "jack", "face");
        String result = employeeDao.updateEmployee(testEmployee);

        Assertions.assertEquals("No record found", result);
    }

    @Test
    @Order(10)
    void delete_employee_test_standard () {
        Employee testEmployee = new Employee(169, "jack", "doe");
        int result = employeeDao.deleteEmployee(testEmployee.getEmployeeID());

        Assertions.assertEquals(testEmployee.getEmployeeID(),result);
    }

    @Test
    @Order(11)
    void delete_employee_test_no_record () {
        Employee testEmployee = new Employee(10000, "george", "face");
        int result = employeeDao.deleteEmployee(testEmployee.getEmployeeID());

        Assertions.assertEquals(0,result);
    }
}