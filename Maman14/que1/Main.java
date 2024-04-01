import java.awt.datatransfer.ClipboardOwner;
import java.util.Iterator;
import java.util.Random;
//checks the PrefQuque class
public class Main {
    final static int NO_OF_ELEMENTS = 10; // No of elements in an array.
    final static int NO_TO_DELETE = 3; // No of elements to delete.
    final static int NO_TO_CHECK_CONTAINS = 5; // No of elements to check if the que contains.
    final static int NO_TO_POLL = 5; // No of elements to poll from the queue.
    final static int ID_MAX = 1000000000; // Max number of an id.
    static Random rnd = new Random();
    static String[] strs = new String[NO_OF_ELEMENTS]; // The strings to insert to the queue.
    static ClientAppeal[] clApps = new ClientAppeal[NO_OF_ELEMENTS]; // Client appeals
    final static int NO_OF_PREF = 10; // No of perforations for each element.
    // Calls all the test functions.
    public static void main(String[] args) {
        checkStrings();
        System.out.println(" ");
        checkClientAppeals();
    }
    // Checks PrefQueue with the ClientAppeal class.
    public static void checkClientAppeals(){
        PrefQueue<ClientAppeal> pq = new PrefQueue<ClientAppeal>(NO_OF_PREF);

        fillPrefQueClientAppeals(pq);

        Iterator<ClientAppeal> it1 = pq.iterator();
        System.out.println("current queue:");
        while(it1.hasNext()){
            System.out.println(it1.next().toString());
        }

        containsCheck(pq);
        removeClientAppeals(pq);
        pollClientAppealCheck(pq);
    }
    // Checks polling ClientAppeals from the PrefQueue.
    public static void pollClientAppealCheck(PrefQueue<ClientAppeal> pq){
        Iterator<ClientAppeal> it1 = pq.iterator();
        System.out.println("current queue:");
        while(it1.hasNext()){
            System.out.println(it1.next().toString());
        }

        for(int i = 0; i < NO_TO_POLL; i++){
            System.out.println("deleted: " + pq.poll().toString());
        }
        it1 = pq.iterator();
        System.out.println("current queue:");
        while(it1.hasNext()){
            System.out.println(it1.next().toString());
        }
    }
    // Checks contain function in PrefQueue for ClientAppeals.
    public static void containsCheck(PrefQueue<ClientAppeal> pq){
        for(int i = 0; i < NO_TO_CHECK_CONTAINS; i++){
            int ind = rnd.nextInt(pq.size()-1);
            System.out.print("contains check " + i + ": " + " appeal to check: " + clApps[ind] + ". succeeded: ");
            System.out.println(pq.contains(clApps[ind]));
            ClientAppeal ca1 = new ClientAppeal(clApps[ind].getName(), clApps[ind].getID(), clApps[ind].getAppeal() + "1");
            System.out.println("check it doesn't contain different object. succeeded: " + !pq.contains(ca1));
        }
    }
    // Adds random ClientAppeals to the PrefQueue.
    public static void fillPrefQueClientAppeals(PrefQueue<ClientAppeal> pq){
        for(int i = 0; i < NO_OF_ELEMENTS; i++){
            ClientAppeal ca = new ClientAppeal("" + i, "" + rnd.nextInt(ID_MAX), "" + rnd.nextInt(Integer.MAX_VALUE));
            clApps[i] = ca;
            pq.add(ca, Integer.parseInt(ca.getID())%10 + 1);
        }
    }
    // Checks removing ClientAppeals from the PrefQueue.
    public static void removeClientAppeals(PrefQueue<ClientAppeal> pq){
        for(int i = 0; i < NO_TO_DELETE; i++){
            ClientAppeal obj = clApps[pq.size()-1];
            System.out.print("the string we are deleting: " + obj);
            pq.remove(obj);
            Iterator<ClientAppeal> it2 = pq.iterator();
            System.out.println(" succeeded: " + !pq.contains(obj));
        }
    }
    // Checks PrefQueue with strings.
    public static void checkStrings(){
        PrefQueue<String> pq = new PrefQueue<String>(NO_OF_PREF);
        fillPrefQueStrings(pq);

        Iterator<String> it1 = pq.iterator();
        System.out.println("current queue:");
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        removeStrings(pq);
    }
    // Checks removing strings from the PrefQueue.
    public static void removeStrings(PrefQueue<String> pq){
        for(int i = 0; i < NO_TO_DELETE; i++){
            String obj = strs[pq.size()-1];
            System.out.print("the string we are deleting: " + obj);
            pq.remove(obj);
            System.out.println(" succeeded: " + !pq.contains(obj));
        }
    }
    // Adds random strings to the PrefQueue.
    public static void fillPrefQueStrings(PrefQueue<String> pq){
        for(int i = 0; i < NO_OF_ELEMENTS; i++){
            int pref = rnd.nextInt(1, NO_OF_PREF + 1);
            String str = "pref= " + pref + " rnd: " + rnd.nextInt(Integer.MAX_VALUE);
            strs[i] = str;
            pq.add(str, pref);
        }
    }
}