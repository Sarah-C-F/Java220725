package handlers.expenseHandlers;

import app.App;
import com.google.gson.Gson;
import entities.expenses.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteExpenseHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("expenseId"));
        int updated = App.expenseService.deleteExpense(id);

        if (updated == 0) {
            ctx.status(404);
            ctx.result("No expense record found");
        } else if (updated == 2) {
            ctx.status(200);
            ctx.result("Expense Removed!");
        } else {
            ctx.status(403);
            ctx.result("Record cannot be altered");
        }
    }
}
