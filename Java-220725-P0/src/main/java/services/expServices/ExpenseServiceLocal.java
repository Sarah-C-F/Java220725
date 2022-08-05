package services.expServices;

import dao.employeeDaos.EmployeeDAO;
import dao.expenseDaos.ExpenseDAO;
import entities.employees.Employee;
import entities.expenses.Expense;

public class ExpenseServiceLocal implements ExpenseService{

    private ExpenseDAO expenseDAO;
    private EmployeeDAO employeeDAO;
    public ExpenseServiceLocal(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }
    public void EmployeeServiceLocal(EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO; }


    @Override
    public int createExpense (Expense expense) {

        //check empID exists and expAmount not negative
        int employeeKey = expense.getEmployeeID();
        Employee employee = employeeDAO.getEmployeeByID(employeeKey);
        if (employee.getEmployeeID() != 0) {
            if (expense.getExpenseAmount() >= 0) {
                return this.expenseDAO.createExpense(expense);
            }
        }
        return 0;

    }
}
