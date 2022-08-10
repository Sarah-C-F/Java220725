package entities.expenses;

import entities.employees.Employee;

public class Expense {


    private int expenseID; //serial Primary Key
    private ExpenseType expenseType;
    private int employeeID; //Foreign Key, not null
    private double expenseAmount;//check > 0
    private Status expenseStatus;


    public Expense() {
    }


    public Expense(int expenseID, String expenseType, int employeeID, double expenseAmount, String status) {
        this.expenseID = expenseID;
        this.expenseType = ExpenseType.valueOf(expenseType);
        this.employeeID = employeeID;
        this.expenseAmount = expenseAmount;
        this.expenseStatus = Status.valueOf(status);
    }

    public Expense(int expenseID, String expenseType, int employeeID, double expenseAmount) {

        this.expenseID = expenseID;
        this.expenseType = ExpenseType.valueOf(expenseType);
        this.employeeID = employeeID;
        this.expenseAmount = expenseAmount;
        this.expenseStatus = Status.PENDING;
    }




    public int getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        expenseType.toUpperCase();
        this.expenseType = ExpenseType.valueOf(expenseType);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Status getExpenseStatus() {
        return expenseStatus;
    }

    public void setExpenseStatus(String expenseStatus) {
        expenseStatus.toUpperCase();
        this.expenseStatus = Status.valueOf(expenseStatus);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseID=" + expenseID +
                ", expenseType=" + expenseType +
                ", employeeID=" + employeeID +
                ", expenseAmount=" + expenseAmount +
                ", expenseStatus=" + expenseStatus +
                '}';
    }
}




