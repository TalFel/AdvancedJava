public class Thread2 extends Thread {
    private final int NO_OF_UPDATES = 10; //no of updates and getdiff calls.
    private final int SLEEP_TIME = 200; //time to sleep between 2 calls.
    private Data data; //the data object.
    boolean isSaiifC; // a bool that represents if we are in the third part. if we are, we need to print a little different.
    public Thread2(Data data, boolean isSaiifC){
        this.data = data;
        this.isSaiifC = isSaiifC;
        if(!isSaiifC){
            System.out.println("Actual updates: ");
        }
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < NO_OF_UPDATES; i++){
            if(!isSaiifC){
                System.out.print(data.getDiff() + " ");
            }
            else{
                int a = data.getDiff();
            }
            try{
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!isSaiifC) {
            System.out.println("");
        }
    }
}
