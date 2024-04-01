import java.util.Random;

public class Thread1 extends Thread {
    private final int NO_OF_UPDATES = 10; //no of updates and getdiff calls.
    private final int PAIR = 2;
    private final int MAX_UPDATE = 50; //max no to update
    private final int SLEEP_TIME = 200; //time to sleep between 2 calls.
    private Data data; //the data object.
    int[][] updates; //array of updates to x & y.
    boolean isSaiifC; // a bool that represents if we are in the third part. if we are, we need to print a little different.
    public Thread1(Data data, boolean isSaiifC){
        this.isSaiifC = isSaiifC;
        this.data = data;
        updates = new int[NO_OF_UPDATES][PAIR];
        Random rnd = new Random();
        for(int i = 0; i < NO_OF_UPDATES; i++){
            for(int j = 0; j < PAIR; j++) {
                updates[i][j] = rnd.nextInt(MAX_UPDATE);
            }
        }
        if(!isSaiifC){
            int x = 0;
            int y = 0;
            System.out.println("Expected updates:");
            for(int i = 0; i < NO_OF_UPDATES; i++){
                x+=updates[i][0];
                y+=updates[i][1];
                System.out.print(Math.abs(x-y) + " ");
            }
            System.out.println("");
        }
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < NO_OF_UPDATES; i++){
            data.update(updates[i][0], updates[i][1]);
            try{
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
