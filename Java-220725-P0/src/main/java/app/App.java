package app;

import dao.employeeDaos.EmployeeDaoPostgres;
import dao.expenseDaos.ExpenseDaoLocal;
import handlers.employeeHandlers.*;
import handlers.expenseHandlers.CreateExpenseHandler;
import io.javalin.Javalin;
import services.empServices.EmployeeService;
import services.empServices.EmployeeServiceLocal;
import services.expServices.ExpenseService;
import services.expServices.ExpenseServiceLocal;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceLocal(new EmployeeDaoPostgres());
    public static ExpenseService expenseService = new ExpenseServiceLocal(new ExpenseDaoLocal());


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
        CreateExpenseHandler createExpenseHandler = new CreateExpenseHandler();
//        DeleteExpenseHandler deleteExpenseHandler = new DeleteExpenseHandler();
//        GetAllExpensesHandler getAllExpensesHandler = new GetAllExpensesHandler();
//        GetSpecificExpenseHandler getSpecificExpenseHandler = new GetSpecificExpenseHandler();
//        UpdateExpenseHandler updateExpenseHandler = new UpdateExpenseHandler();

        //call Employee Handlers

        app.get("/employees", getAllEmployeesHandler);
        app.get("/employees/{empID}", getEmployeeByIDHandler);
        app.post("/employees", createEmployeesHandler);
        app.put("/employees/{empID}", updateEmployeeHandler);
        app.delete("/employees/{empID}", deleteEmployeeHandler);

        //call Expense Handlers
        app.get("/expenses", createExpenseHandler);


        app.start();

    }



}
