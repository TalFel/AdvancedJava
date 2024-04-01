public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Bank bank = new Bank();
        bank.work();
        Account[] accounts = bank.getAccounts();
        double[] finalSums = bank.getFinalSums();
        for(int i = 0; i < bank.getNO_OF_ACCOUNTS(); i++){
            if(accounts[i].getBalance()==finalSums[i]){
                System.out.println("Account no- " + i + ": succeeded");
            }
            else{
                System.out.println("Account no- " + i + ": failed");
            }
        }
    }
}