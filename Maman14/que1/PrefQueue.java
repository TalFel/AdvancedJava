import java.util.ArrayList;
import java.util.Iterator;
//pref que class
public class PrefQueue<T>{
    private ArrayList<T>[] queue;
    // Constructs a new PrefQueue object with the given number of priority levels.
    // Each priority level is represented by an ArrayList that can store elements of type T.
    public PrefQueue(int noOfPref){
        queue = new ArrayList[noOfPref];
        for (int i = 0; i < noOfPref; i++) {
            queue[i] = new ArrayList<T>();
        }
    }
    // Adds the given object to the PrefQueue at the specified priority level.
    // If the specified priority level is greater than the number of priority levels in the queue or less than 1,
    // the object is added to the highest priority level.
    public void add(T obj, int pref){
        if(pref > queue.length || pref < 1) pref = queue.length;
        queue[pref - 1].add(obj);
    }
    // Retrieves and removes the next element from the PrefQueue, or returns null if the queue is empty.
    // Elements with higher priority levels are retrieved before elements with lower priority levels.
    public T poll(){
        int ind = -1;
        for(int i = 0; i < queue.length; i++){
            if(!queue[i].isEmpty()){
                ind = i;
                break;
            }
        }
        if(ind==-1) return null;
        return queue[ind].remove(0);
    }
    // Returns true if the PrefQueue contains the specified element, false otherwise.
    public boolean contains(T obj){
        for(int i = 0; i < queue.length; i++){
            if(queue[i].contains(obj)){
                return true;
            }
        }
        return false;
    }
    // Removes the first occurrence of the specified element from the PrefQueue, if it is present.
    // Returns true if the element was found and removed, false otherwise.
    public boolean remove(T obj){
        for(int i = 0; i < queue.length; i++){
            if(queue[i].contains(obj)){
                queue[i].remove(obj);
                return true;
            }
        }
        return false;
    }
    // Returns the total number of elements in the PrefQueue.
    public int size(){
        int size = 0;
        for(int i = 0; i < queue.length; i++){
            size+= queue[i].size();
        }
        return size;
    }
    // Returns an iterator that can be used to iterate over the elements in the PrefQueue.
    public Iterator<T> iterator(){
        ArrayList<T> fullList = new ArrayList<T>();
        for(int i = 0; i < queue.length; i++){
            Iterator<T> it = queue[i].iterator();
            while(it.hasNext()){
                fullList.add(it.next());
            }
        }
        return fullList.iterator();
    }
}
