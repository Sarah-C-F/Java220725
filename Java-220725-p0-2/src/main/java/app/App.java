package app;

import dao.employeeDaos.EmployeeDaoPostgres;
import dao.expenseDaos.ExpenseDaoPostgres;
import handlers.employeeHandlers.*;
import handlers.expenseHandlers.*;
import io.javalin.Javalin;
import services.employeeServices.EmployeeService;
import services.employeeServices.EmployeeServiceLocal;
import services.expenseServices.ExpenseService;
import services.expenseServices.ExpenseServiceLocal;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceLocal(new EmployeeDaoPostgres());
    public static ExpenseService expenseService = new ExpenseServiceLocal(new ExpenseDaoPostgres(), employeeService);


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
        DeleteExpenseHandler deleteExpenseHandler = new DeleteExpenseHandler();
        GetAllExpensesHandler getAllExpensesHandler = new GetAllExpensesHandler();
        GetExpenseByIDHandler getExpenseByIDHandler = new GetExpenseByIDHandler();
        UpdateExpenseHandler updateExpenseHandler = new UpdateExpenseHandler();
        GetExpensesByEmployeeHandler getExpensesByEmployeeHandler = new GetExpensesByEmployeeHandler();

        //call Employee Handlers

        app.get("/employees", getAllEmployeesHandler);
        app.get("/employees/{empID}", getEmployeeByIDHandler);
        app.post("/employees", createEmployeesHandler);
        app.put("/employees/{empID}", updateEmployeeHandler);
        app.delete("/employees/{empID}", deleteEmployeeHandler);

        //call Expense Handlers
        app.post("/expenses", createExpenseHandler);
        app.get("/expenses", getAllExpensesHandler);
        app.get("/expenses/{expenseId}", getExpenseByIDHandler);
        app.put("expenses/{expenseId}", updateExpenseHandler);
        app.patch("expenses/{expenseId}/{expenseStatus}", updateExpenseHandler);
        app.delete("expenses/{expenseId}", deleteExpenseHandler);
        app.get("employees/{empID}/expenses", getExpensesByEmployeeHandler);

        app.start();

    }



}
