package handlers.empHandlers;

import app.App;
import entities.Employee;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateEmployeesHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String body = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(body, Employee.class);

        App.employees.add(employee);
        ctx.status(201);
        ctx.result("Added a new Employee");

        System.out.println(App.employees);
    }
}
