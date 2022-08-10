package handlers.expenseHandlers;

import app.App;
import com.google.gson.Gson;
import entities.expenses.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetExpenseByIDHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("expenseId"));
        System.out.println(id);

        Expense expense = App.expenseService.getExpenseByID(id);
        if (expense.getExpenseID() != 0) {
            Gson gson = new Gson();
            String json = gson.toJson(expense);
            ctx.result(json);
        } else {
            ctx.status(404);
            ctx.result("No Expense Record Found");
        }

    }
}
