package entities;

public class Expense {
    private static int expID;

    private static int empID;
    private static double expAmount;
    private static String expStatus = "pending";


    public Expense() {
    }

    public Expense(int expID,int empID, double expAmount) {
        this.expID = expID;
        this.empID = empID;
        this.expAmount = expAmount;
    }

    public static int getExpID() {
        return expID;
    }

    public void setExpID(int expID) {
        this.expID = expID;
    }

    public static double getExpAmount() {
        return expAmount;
    }

    public void setExpAmount(double expAmount) {
        this.expAmount = expAmount;
    }

    public static String getExpStatus() {
        return expStatus;
    }

    public void setExpStatus(String expStatus) {
        this.expStatus = expStatus;
    }

    public static int getEmpID() {
        return empID;
    }

    public static void setEmpID(int empID) {
        Expense.empID = empID;
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




