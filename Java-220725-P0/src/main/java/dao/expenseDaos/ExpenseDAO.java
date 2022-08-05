package dao.expenseDaos;

import entities.expenses.Expense;

public interface ExpenseDAO {

    //Create
   int createExpense(Expense expense);
}
