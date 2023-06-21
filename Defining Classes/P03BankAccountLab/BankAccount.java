package P03BankAccountLab;

public class BankAccount {

private static double interestRate = 0.2;
private static  int accountCount = 0;

    private int id;
    private double balance;

    public BankAccount() {
        BankAccount.accountCount++;
      this.id = accountCount;
      this.balance = 0.0;

    }
    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public Integer getId() {
        return  this.id;
    }

    public double getProfitAfterYears(int  numberOfYears) {
        return this.balance * BankAccount.interestRate * numberOfYears;
    }
}
