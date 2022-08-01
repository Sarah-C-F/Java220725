package entities;

public class Expense {
    private int expID;

    private int empID;
    private double expAmount;
    private String expStatus = "pending";


    public Expense() {
    }

    public Expense(int expID,int empID, double expAmount) {
        this.expID = expID;
        this.empID = empID;
        this.expAmount = expAmount;
    }

    public int getExpID() {
        return expID;
    }

    public void setExpID(int expID) {
        this.expID = expID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public double getExpAmount() {
        return expAmount;
    }

    public void setExpAmount(double expAmount) {
        this.expAmount = expAmount;
    }

    public String getExpStatus() {
        return expStatus;
    }

    public void setExpStatus(String expStatus) {
        this.expStatus = expStatus;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expID=" + expID +
                ", empID=" + empID +
                ", expAmount=" + expAmount +
                ", expStatus='" + expStatus + '\'' +
                '}';
    }
}




