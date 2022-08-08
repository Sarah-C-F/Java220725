package handlers.employeeHandlers;

import app.App;
import entities.employees.Employee;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("empID"));
        String  employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON,Employee.class);
        employee.setEmployeeID(id);
        String updated = App.employeeService.updateEmployee(employee);
        if (updated.equals("Employee updated!")) {
            ctx.status(200);
            ctx.result(updated);
        } else {
            ctx.status(404);
            ctx.result("Employee Record Not Found");
        }
    }
}
