import java.util.concurrent.locks.*;
//saiif 2
public class Data2 extends Data{
    boolean func = false; //func=true enables the getters and disables the setter, func=false disables the getters and enables the setter.
    public Data2 (int x, int y){
        super(x, y);
    }
    @Override
    public synchronized int getDiff(){
        while(!func){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int diff = super.getDiff();
        func = false;
        notify();
        return diff;
    }
    @Override
    public synchronized void update(int dx, int dy)  {
        while(func){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.update(dx, dy);
        func = true;
        notify();
    }
}
