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
        System.out.println("here");
        String  employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON,Employee.class);
        employee.setEmployeeID(id);
        System.out.println(employee.getEmployeeID());
        String updated = App.employeeService.updateEmployee(employee);
        System.out.println(updated);
        if (updated.equals("Employee updated!")) {
            System.out.println("ifHandle");
            ctx.status(200);
            ctx.result(updated);
        } else {
            System.out.println("elseHandle");
            ctx.status(404);
            ctx.result("Employee Record Not Found");
        }
    }
}
