package dao;

import handlers.empHandlers.CreateEmployeesHandler;
import handlers.empHandlers.GetAllEmployeesHandler;
import handlers.empHandlers.GetSpecificEmployeeHandler;

public interface EmployeeDAO {

    //create
    CreateEmployeesHandler createEmployeesHandler = new CreateEmployeesHandler();

    //Read
    GetAllEmployeesHandler getAllEmployeesHandler = new GetAllEmployeesHandler();
    GetSpecificEmployeeHandler getSpecificEmployeeHandler = new GetSpecificEmployeeHandler();

    //Update
    //UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();

    //Delete
    //DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();

}
