package dao.expenseDaos;

import entities.expenses.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseDaoLocal implements ExpenseDAO{

    private Map<Integer, Expense> expenseTable = new HashMap();
    private int idMaker = 1;

    @Override
    public int createExpense(Expense expense) {
        expense.setExpenseID(idMaker);
        idMaker++;
        System.out.println(expense);
        expenseTable.put(expense.getExpenseID(),expense);
        return 1;
    }
}
