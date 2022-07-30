package handlers.empHandlers;

import app.App;
import entities.Employee;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetSpecificEmployeeHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("empID"));

        for (Employee e: App.employees) {
            if (e.getEmpID() == id) {
                Employee employee = e;
                Gson gson =new Gson();
                String json =gson.toJson(employee);
                ctx.result(json);
                return;
            }
        }

        ctx.status(404);
        ctx.result("employee not found");
    }
}
