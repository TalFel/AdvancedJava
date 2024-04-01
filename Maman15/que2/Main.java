public class Main {
    final static int NO_OF_THREADS = 4;
    public static void main(String[] args) {
        System.out.println("----------1-------------");
        Data1 d1 = new Data1(0, 0);
        Thread1 ta1 = new Thread1(d1, false);
        Thread2 ta2 = new Thread2(d1, false);
        ta1.start();
        ta2.start();
        try{
            ta1.join();
            ta2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------2-------------");
        Data2 d2 = new Data2(0, 0);
        Thread1 tb1 = new Thread1(d2, false);
        Thread2 tb2 = new Thread2(d2, false);
        tb1.start();
        tb2.start();
        try{
            tb1.join();
            tb2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------3-------------");
        Data3 d3 = new Data3(0, 0);
        Thread1[] tc1 = new Thread1[NO_OF_THREADS];
        for(int i = 0; i < NO_OF_THREADS; i++) {
            tc1[i] = new Thread1(d3, true);
        }
        Thread2[] tc2 = new Thread2[NO_OF_THREADS];
        for(int i = 0; i < NO_OF_THREADS; i++) {
            tc2[i] = new Thread2(d3, true);
        }
        for(int i = 0; i <NO_OF_THREADS; i++){
            tc1[i].start();
            tc2[i].start();
        }
        try{
            tc1[0].join();
            tc1[1].join();
            tc1[2].join();
            tc1[3].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}