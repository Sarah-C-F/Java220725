package handlers.expenseHandlers;

import app.App;
import com.google.gson.Gson;
import entities.expenses.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) {
        String string;
        int id = Integer.parseInt(ctx.pathParam("expenseId"));
        String  expenseJSON = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(expenseJSON,Expense.class);
        System.out.println(expense.toString());
        expense.setExpenseID(id);
        if (ctx.pathParamMap().size() >= 2){
            string = ctx.pathParam("expenseStatus");
            expense.setExpenseStatus(string);
        }
        System.out.println(expense);
        int updated = App.expenseService.updateExpense(expense);

        if (updated == 0) {
            ctx.status(404);
            ctx.result("No expense record found");
        } else if (updated == 2) {
            ctx.status(200);
            ctx.result("Expense Updated!");
        } else {
            ctx.status(403);
            ctx.result("Record cannot be altered");
        }
    }
}
