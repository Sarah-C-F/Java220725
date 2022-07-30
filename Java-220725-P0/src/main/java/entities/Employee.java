package entities;

public class Employee {
    private static int empID;
    private static String empFirstName;
    private static String empLastName;

    public Employee() {}

    public Employee(int empID, String empFirstName, String empLastName) {
        this.empID = empID;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
    }

    public static int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public static String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public static String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                '}';
    }


}
