package dao;

import handlers.empHandlers.CreateEmployeesHandler;
import handlers.empHandlers.GetAllEmployeesHandler;
import handlers.empHandlers.GetSpecificEmployeeHandler;

public interface EmployeeDAO {

    //create Employee Handlers
    CreateEmployeesHandler createEmployeesHandler = new CreateEmployeesHandler();
    //DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();
    GetAllEmployeesHandler getAllEmployeesHandler = new GetAllEmployeesHandler();
    GetSpecificEmployeeHandler getSpecificEmployeeHandler = new GetSpecificEmployeeHandler();
    //UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();
}
