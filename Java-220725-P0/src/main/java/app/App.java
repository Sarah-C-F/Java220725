package app;

import entities.Employee;
import entities.Expense;
import handlers.empHandlers.*;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class App {
    //create Employees list
    public static List<Employee> employees = new ArrayList<>();
    //create Expenses List
    public static List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        //add Javalin
        Javalin app = Javalin.create();

        //create Employee Handlers
        CreateEmployeesHandler createEmployeesHandler = new CreateEmployeesHandler();
        //DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();
        GetAllEmployeesHandler getAllEmployeesHandler = new GetAllEmployeesHandler();
        GetSpecificEmployeeHandler getSpecificEmployeeHandler = new GetSpecificEmployeeHandler();
        //UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();

        //create Expense Handlers
        /*CreateExpenseHandler createExpenseHandler = new CreateExpenseHandler();
        DeleteExpenseHandler deleteExpenseHandler = new DeleteExpenseHandler();
        GetAllExpensesHandler getAllExpensesHandler = new GetAllExpensesHandler();
        GetSpecificExpenseHandler getSpecificExpenseHandler = new GetSpecificExpenseHandler();
        UpdateExpenseHandler updateExpenseHandler = new UpdateExpenseHandler();*/

        //call Employee Handlers

        app.get("/employees", getAllEmployeesHandler);
        app.get("/employees/{empID}", getSpecificEmployeeHandler);
        app.post("/employees", createEmployeesHandler);
        //app.put("/employees", updateEmployeeHandler);
        //app.delete("/employees", DeleteEmployeeHandler);


        app.start();

    }



}
