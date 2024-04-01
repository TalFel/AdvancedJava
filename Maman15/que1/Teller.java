import java.util.Random;
//a thread that represents a bank teller. he does a transaction, sleeps for 100ms and repeats.
public class Teller extends Thread {
    private final int TIME = 100;//sleep time
    private Transactions transactions;//the list of transactions
    private Account[] accounts;//the accounts ids
    public Teller(Transactions ta, Account[] acc){
        transactions = ta;
        accounts = acc;
    }
    @Override
    public void run(){
        super.run();
        //while there are more transactions, the teller will get it and do it.
        Transaction t = transactions.getFirstTransaction();
        while(t != null){
            Account account = null;
            for(int i = 0; i < accounts.length; i++){
                if(accounts[i].getAccountId().equals(t.getAccount())){
                    account = accounts[i];
                    break;
                }
            }
            if(account == null){
                System.out.println("wrong account ID: " + t.getAccount());
                System.exit(-1);
            }
            account.transaction(t.getAmount());
            Random rnd = new Random();
            try {
                sleep(rnd.nextInt(TIME));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            t = transactions.getFirstTransaction();
        }
    }
}
