package dao.employeeDaos;

import app.App;
import entities.employees.Employee;
import utils.ConnectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoPostgres implements EmployeeDAO{

    private int idMaker = 131;


    @Override
    public Employee createEmployee(Employee employee) {

        employee.setEmployeeID(idMaker);
        idMaker++;

        try (Connection conn = ConnectUtil.getConnection()){
            String sql = "insert into employees values ( ?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employee.getEmployeeID());
            ps.setString(2, employee.getEmployeeFirstName());
            ps.setString(3, employee.getEmployeeLastName());


            ps.execute();

            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List getAllEmployees() {

        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "select * from employees";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Employee> employeesList = new ArrayList<Employee>();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt("employee_id"));
                employee.setEmployeeFirstName(rs.getString("firstname"));
                employee.setEmployeeLastName(rs.getString("lastname"));
                employeesList.add(employee);

            }
            return employeesList;
        } catch (SQLException e) {

        }

        return null;
    }

    @Override
    public Employee getEmployeeByID(int id) {
        Employee employee = new Employee();
        employee.setEmployeeID(0);
        employee.setEmployeeFirstName("none");
        employee.setEmployeeLastName("none");

        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "select * from employees where employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

           if( rs.next()) {
               employee.setEmployeeID(id);
               employee.setEmployeeFirstName(rs.getString("firstname"));
               employee.setEmployeeLastName(rs.getString("lastname"));
           }

        } catch (SQLException e) {

        }
        return employee;
    }

    @Override
    public String updateEmployee(Employee employee) {
        String output = new String();
        employee= getEmployeeByID(employee.getEmployeeID());
        if (employee.getEmployeeID() != 0) {

            try (Connection conn = ConnectUtil.getConnection()) {
                String sql = "update employees set firstname = ?, lastname = ? where employee_id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, employee.getEmployeeFirstName());
                ps.setString(2, employee.getEmployeeLastName());
                ps.setInt(3, employee.getEmployeeID());

                ps.execute();
                output = "Employee updated!";

            } catch (SQLException e) {

            }
        } else {
            output = "No record found";
        }

        return output;
    }

    @Override
    public int deleteEmployee(int id) {
        Employee getEmployee = getEmployeeByID(id);
        if ( getEmployee.getEmployeeID() == 0){
            return 0;
        }
        try (Connection conn = ConnectUtil.getConnection()) {
            String sql = "delete from employees where employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();

            return id;

        } catch(SQLException e) {

        }
        return 0;
    }
}
