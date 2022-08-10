package dao.expenseDaos;

import entities.expenses.Expense;

import java.util.List;

public interface ExpenseDAO {

    //Create
   int createExpense(Expense expense);

    List<Expense> getAllExpenses();

    List<Expense> getExpensesByEmployee(int id);

    Expense getExpenseById(int id);

    int updateExpense(Expense expense);


    int deleteExpense(int id);
}
