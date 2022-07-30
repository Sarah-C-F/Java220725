package entities;

public class Expense {
    private static int expID;
    private static double expAmount;
    private static String expStatus = "pending";


    public Expense() {
    }

    public Expense(int expID, double expAmount) {
        this.expID = expID;
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

    @Override
    public String toString() {
        return "Expense{" +
                "expID=" + expID +
                ", expAmount=" + expAmount +
                ", expStatus='" + expStatus + '\'' +
                '}';
    }
}




