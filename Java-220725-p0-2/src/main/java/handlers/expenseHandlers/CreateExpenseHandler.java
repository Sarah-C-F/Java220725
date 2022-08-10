package handlers.expenseHandlers;

import app.App;
import com.google.gson.Gson;
import entities.expenses.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) {
        String json = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(json, Expense.class);
        System.out.println(expense.toString());
        int r = App.expenseService.createExpense(expense);
        System.out.println(r);

        if (r == 0) {
            ctx.status(406);
            ctx.result("negative numbers are not accepted.");
        } else if (r == 1) {
            ctx.status(201);
            ctx.result("Added a new Expense ");
        }else {
            ctx.status(406);
            ctx.result("Please check your entry and try again");
        }

    }
}
