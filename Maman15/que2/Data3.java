import java.util.concurrent.locks.*;
//saiif 3
/*
Only one thread can write, while the x&y values are updating no diff calculation will be made.
this class also allows multiple threads reading at the same time.
*/
public class Data3 extends Data {
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private int gettersInProcess;
    /*
    If a getter has passed the lock this value will increase by 1. When it has passed the getdiff this value will decrease by 1.
    This disables the update func until all the getter threads are locked out.
    */
    boolean func; //func=true enables the getters and disables the setter, func=false disables the getters and enables the setter.
    public Data3 (int x, int y){
        super(x, y);
        gettersInProcess = 0;
        func = false;
    }
    //adds a getter in progress.
    public void AddGetter(){
        lock.lock();
        try{
            gettersInProcess++;
        } finally{
            lock.unlock();
        }

    }
    //"removes" the getter and signals all the locked threads.
    public void RemoveGetter(){
        lock.lock();
        try{
            gettersInProcess--;
            cond.signalAll();
        } finally{
            lock.unlock();
        }
    }
    @Override
    public int getDiff(){
        lock.lock();
        try {
            while(!func){
                cond.signalAll();
                cond.await();
            }
            AddGetter();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
        int diff = super.getDiff();
        System.out.println("diff is: " + diff);
        RemoveGetter();
        return diff;
    }
    @Override
    public synchronized void update(int dx, int dy){
        lock.lock();
        try {
            func = false;
            while(gettersInProcess > 0){
                cond.await();
            }

            super.update(dx, dy);
            System.out.println("updated to: " + super.getDiff());
            func = true;
            cond.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            lock.unlock();
        }

    }
}
