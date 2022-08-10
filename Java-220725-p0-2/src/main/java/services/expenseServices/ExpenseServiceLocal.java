package services.expenseServices;

import dao.employeeDaos.EmployeeDAO;
import dao.expenseDaos.ExpenseDAO;
import entities.employees.Employee;
import entities.expenses.Expense;
import entities.expenses.Status;
import services.employeeServices.EmployeeService;

import java.util.List;

public class ExpenseServiceLocal implements ExpenseService{

    private ExpenseDAO expenseDAO;
    private EmployeeService employeeService;
    private EmployeeDAO employeeDAO;

    public ExpenseServiceLocal (ExpenseDAO expenseDAO, EmployeeService employeeService) {
        this.expenseDAO = expenseDAO;
        this.employeeService = employeeService;
    }
    //public EmployeeServiceLocal (EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO}


    @Override
    public int createExpense (Expense expense) {
        if (expense.getExpenseAmount() < 0) {
            return 0;
        }
        return expenseDAO.createExpense(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return this.expenseDAO.getAllExpenses();
    }

    @Override
    public Expense getExpenseByID(int id) {
        return this.expenseDAO.getExpenseById(id);
    }

    @Override
    public int updateExpense(Expense expense) {
        int output = 0;
        Expense confirm = this.expenseDAO.getExpenseById(expense.getExpenseID());
        if (confirm.getExpenseID() != 0) {
            output = 1;
            if (confirm.getExpenseStatus() == Status.PENDING) {
                output = this.expenseDAO.updateExpense(expense);
            }
        }
        return output;
    }

    @Override
    public int deleteExpense(int id) {
        int output = 0;
        Expense confirm = this.expenseDAO.getExpenseById(id);
        if (confirm.getExpenseID() != 0) {
            output = 1;
            if (confirm.getExpenseStatus() == Status.PENDING) {
                output = this.expenseDAO.deleteExpense(id);
            }
        }
        return output;
    }

    @Override
    public List<Expense> getExpensesByEmployee(int id) {
        Employee confirm = this.employeeService.getEmployeeByID(id);
        if (confirm.getEmployeeID() != 0) {
            return this.expenseDAO.getExpensesByEmployee(id);
        }
        return null;
    }

}
