package handlers.employeeHandlers;

import app.App;
import entities.employees.Employee;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateEmployeesHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) {
        String json = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(json, Employee.class);
        System.out.println(employee);
        Employee saveEmployee = App.employeeService.createEmployee(employee);
        String employeeJson = gson.toJson(saveEmployee);


        ctx.status(201);
        ctx.result("Added a new Employee " + employeeJson );

    }
}
