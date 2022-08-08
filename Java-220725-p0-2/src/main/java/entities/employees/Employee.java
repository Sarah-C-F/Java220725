package entities.employees;

public class Employee {

    private int employeeID; //primary key
    private String employeeFirstName;
    private String employeeLastName;


    public Employee() {}

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee(int employeeID, String employeeFirstName, String employeeLastName) {
        this.employeeID = employeeID;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }



    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;


    }

}
