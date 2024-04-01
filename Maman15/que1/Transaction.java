//a class that represents a transaction.
public class Transaction {
    private double amount; //amount of the transaction
    private String accountID; //the account id of the transaction.
    public Transaction(double amount, String accountID){
        this.amount = amount;
        this.accountID = accountID;
    }

    public double getAmount() {
        return amount;
    }
    public String getAccount(){
        return accountID;
    }
}
