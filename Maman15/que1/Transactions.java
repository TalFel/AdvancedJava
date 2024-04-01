import java.util.ArrayList;
//a class which contains a list of transactions with a sync getter.
public class Transactions{
    private ArrayList<Transaction> transactions;
    public Transactions(ArrayList<Transaction> t){
        transactions = new ArrayList<>(t);
    }
    public synchronized Transaction getFirstTransaction(){
        if(transactions.isEmpty()) return null;
        Transaction t = transactions.get(0);
        transactions.remove(0);
        return t;
    }
}
