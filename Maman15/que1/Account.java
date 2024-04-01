import java.util.Random;
import java.util.concurrent.locks.*;
//a class that represents a bank account.
public class Account{
    private String accountId;
    private double balance;
    public Account(double b, String accID){
        balance = b;
        accountId = accID;

    }
    public double getBalance(){
        return balance;
    }
    public String getAccountId(){
        return accountId;
    }
    public void updateBalance(double amount){
        balance= balance + amount;
    }

    synchronized public void transaction(double amount){
        String name = Thread.currentThread().getName();
        while(balance + amount < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        updateBalance(amount);
        if(balance<0){
            System.out.println("account " + accountId + " failed. balance is negative: " + balance);
            System.exit(-1);
        }
        System.out.println("Current thread: " + Thread.currentThread().getName() + " Current updated balance: " + balance);
        notifyAll();
    }
}
