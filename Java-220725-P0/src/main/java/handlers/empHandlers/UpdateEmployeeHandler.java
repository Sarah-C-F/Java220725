package handlers.empHandlers;

import app.App;
import entities.Employee;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        System.out.println("here");
        String  employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON,Employee.class);
        System.out.println(employee);
        Employee updatedEmployee = App.employeeService.updateEmployee(employee);
        System.out.println(updatedEmployee);
        if (updatedEmployee.getEmpID() != 0) {
            System.out.println("ifHandle");
            String json = gson.toJson(updatedEmployee);
            ctx.result(json);
        } else {
            System.out.println("elseHandle");
            ctx.status(404);
            ctx.result("Employee Record Not Found");
        }
    }
}
