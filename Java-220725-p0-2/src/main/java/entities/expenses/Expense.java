package entities.expenses;

import entities.employees.Employee;

public class Expense {


    private int expenseID; //serial Primary Key
    private ExpenseType expenseType;
    private int employeeID; //Foreign Key, not null
    private double expenseAmount;//check > 0
    private Status expenseStatus = Status.PENDING; //defaults pending


    public Expense() {
    }

    public Expense(int expenseID, ExpenseType expenseType, int employeeID, double expenseAmount) {
        this.expenseID = expenseID;
        this.expenseType = expenseType;
        this.employeeID = employeeID;
        this.expenseAmount = expenseAmount;
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

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
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

    public void setExpenseStatus(Status expenseStatus) {
        this.expenseStatus = expenseStatus;
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




