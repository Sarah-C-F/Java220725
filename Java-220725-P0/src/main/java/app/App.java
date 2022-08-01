package app;

import dao.EmployeeDaoLocal;
import entities.Employee;
import entities.Expense;
import handlers.empHandlers.*;
import io.javalin.Javalin;
import services.EmployeeService;
import services.EmployeeServiceLocal;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceLocal(new EmployeeDaoLocal());


    public static void main(String[] args) {
        //add Javalin
        Javalin app = Javalin.create();

        //Employee Handlers
        CreateEmployeesHandler createEmployeesHandler = new CreateEmployeesHandler();
        DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();
        GetAllEmployeesHandler getAllEmployeesHandler = new GetAllEmployeesHandler();
        GetEmployeeByIDHandler getEmployeeByIDHandler = new GetEmployeeByIDHandler();
        UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();

        //create Expense Handlers
        /*CreateExpenseHandler createExpenseHandler = new CreateExpenseHandler();
        DeleteExpenseHandler deleteExpenseHandler = new DeleteExpenseHandler();
        GetAllExpensesHandler getAllExpensesHandler = new GetAllExpensesHandler();
        GetSpecificExpenseHandler getSpecificExpenseHandler = new GetSpecificExpenseHandler();
        UpdateExpenseHandler updateExpenseHandler = new UpdateExpenseHandler();*/

        //call Employee Handlers

        app.get("/employees", getAllEmployeesHandler);
        app.get("/employees/{empID}", getEmployeeByIDHandler);
        app.post("/employees", createEmployeesHandler);
        app.put("/employees/{empID}", updateEmployeeHandler);
        app.delete("/employees/{empID}", deleteEmployeeHandler);


        app.start();

    }



}
