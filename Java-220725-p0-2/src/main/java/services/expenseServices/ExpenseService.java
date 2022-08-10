package services.expenseServices;

import entities.expenses.Expense;

import java.util.List;

public interface ExpenseService {

    int createExpense(Expense expense);

    List<Expense> getAllExpenses();

    Expense getExpenseByID(int id);

    int updateExpense(Expense expense);

    int deleteExpense(int id);

    List<Expense> getExpensesByEmployee(int id);
}
