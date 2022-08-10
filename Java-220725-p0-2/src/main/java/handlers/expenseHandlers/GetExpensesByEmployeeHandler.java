package handlers.expenseHandlers;

import app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GetExpensesByEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("empID"));
        Gson gson = new Gson();
        String json = gson.toJson(App.expenseService.getExpensesByEmployee(id));
        ctx.result(json);


    }







}
