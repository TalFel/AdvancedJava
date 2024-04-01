import java.util.ArrayList;
import java.util.Random;
//a class that represents a bank.
public class Bank {
    private final int NO_OF_ACCOUNTS = 5;
    private final int MAX_AMOUNT = 1000; //max transactions amount.
    private final int NO_OF_TRANSACTIONS = 50;
    private final int NO_OF_TELLERS = 10;
    private Account[] accounts;
    private Transactions transactions;
    private Teller[] tellers;
    private double[] finalSums; //an array that contains the final expected sums for each account.
    //constructor for Bank object
    public Bank(){
        accounts = new Account[NO_OF_ACCOUNTS];
        for(int i = 0; i < NO_OF_ACCOUNTS; i++){
            accounts[i] = new Account(0, i+"");
        }
        Random rnd = new Random();
        ArrayList<Transaction> tr = new ArrayList<Transaction>();
        finalSums = new double[NO_OF_ACCOUNTS];
        //restarts the sums
        for(int i = 0; i < NO_OF_ACCOUNTS; i++){
            finalSums[i] = 0.0;
        }
        //creates the transactions that the teller will do
        for(int i = 0; i < NO_OF_TRANSACTIONS; i++){
            double num = (double)rnd.nextInt(-MAX_AMOUNT, MAX_AMOUNT);
            int accID = rnd.nextInt(NO_OF_ACCOUNTS);
	    //takes care that the final sum will be positive so the program wont get stuck.
            while(finalSums[accID]+num < 0){
                num = (double)rnd.nextInt(-MAX_AMOUNT, MAX_AMOUNT);
            }
            tr.add(new Transaction(num, accID + ""));
            finalSums[accID]+=tr.get(i).getAmount();
        }
        transactions = new Transactions(tr);
        //creates the tellers.
        tellers = new Teller[NO_OF_TELLERS];
        for(int i = 0; i < NO_OF_TELLERS; i++) {
            tellers[i] = new Teller(transactions, accounts);
        }
    }
    //starts the tellers.
    public void work(){
        for(int i = 0; i < NO_OF_TELLERS; i++){
            tellers[i].start();
        }
        try{
            for(int i = 0; i < NO_OF_TELLERS; i++){
                tellers[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Account[] getAccounts(){
        return accounts;
    }
    public double[] getFinalSums(){
        return finalSums;
    }
    public int getNO_OF_ACCOUNTS() {
        return NO_OF_ACCOUNTS;
    }
}
