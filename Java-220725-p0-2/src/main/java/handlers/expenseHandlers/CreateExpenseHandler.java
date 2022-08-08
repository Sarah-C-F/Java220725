//package handlers.expenseHandlers;
//
//import app.App;
//import com.google.gson.Gson;
//import entities.expenses.Expense;
//import io.javalin.http.Context;
//import io.javalin.http.Handler;
//import org.jetbrains.annotations.NotNull;
//
//public class CreateExpenseHandler implements Handler {
//
//    @Override
//    public void handle(@NotNull Context ctx) {
//        String json = ctx.body();
//        Gson gson = new Gson();
//        Expense expense = gson.fromJson(json, Expense.class);
//        int r = App.expenseService.createExpense(expense);
//
//        ctx.status(201);
//        ctx.result("Added a new Expense ");
//
//    }
//}
