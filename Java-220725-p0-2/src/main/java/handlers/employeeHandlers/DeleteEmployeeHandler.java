package handlers.employeeHandlers;

import app.App;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteEmployeeHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx){
        int id = Integer.parseInt(ctx.pathParam("empID"));
        int output = App.employeeService.deleteEmployee(id);

        if(output == id) {
            ctx.status(200);
            ctx.result("Employee record deleted");
        } else if (output == 0){
            ctx.status(404);
            ctx.result("Employee record not found");
        }else {
            ctx.status(400);
            ctx.result("Cannot delete employee record");
        }
    }
}
