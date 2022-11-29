package BankAccount_03;

public class BankAccount {
    private static int accountCount = 0;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount(){
        accountCount++;
        this.id = accountCount;
        this.balance = 0;
    }

    public static void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double money){
        this.balance += money;
    }

    public double getInterest(int years){
        return years * interestRate * this.balance;
    }

    public int getId () {
        return id;
    }

}
