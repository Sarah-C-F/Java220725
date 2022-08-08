package handlers.employeeHandlers;

import app.App;
import entities.employees.Employee;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetEmployeeByIDHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("empID"));
        System.out.println(id);

        Employee employee = App.employeeService.getEmployeeByID(id);
        System.out.println(employee.getEmployeeID());
        if (employee.getEmployeeID() != 0) {
            System.out.println("if");
            Gson gson = new Gson();
            String json = gson.toJson(employee);
            ctx.result(json);
        } else {
            System.out.println("else");
            ctx.status(404);
            ctx.result("No Employee Record Found");
        }

    }

}
