
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    static private AtomicInteger count = new AtomicInteger();

    static public int value(){
        return count.intValue();
    }

    public static int increment() {
        return count.incrementAndGet();
    }

    public static int decrement(){
        return count.decrementAndGet();
    }

    public static void reset(){
        count.set(0);
    }


    public static void decreaseValue(int value){
        count.set(count.get() - value);
    }
}
