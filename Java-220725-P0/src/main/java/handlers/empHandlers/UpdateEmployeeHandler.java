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
        int empIndex = 0;
        String body = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(body, Employee.class);

        for (Employee e: App.employees) {
            if (e.getEmpID() == employee.getEmpID()) {
                empIndex =(employee.getEmpID() - 1);


                App.employees.set((empIndex), employee);
                ctx.status(201);
                ctx.result("updated Employee");

                System.out.println(App.employees);
            } else {
                ctx.status(404);
                ctx.result("employee record not found");
            }
        }

    }
}
