package au.net.netstorm.boost.demo.spider.resolve;

public class DefaultRailyard implements Railyard {
    public static final Object LOCK = new Object();
    public static int trainCount = 0;
    Train train;

    public Train getTrain() {
        synchronized (LOCK) {
            trainCount++;
        }
        try {
            // FIX 2318 Scary little trollop.  Who let you out ugly?
            // FIX 2318 trainCount is misspelled in this case.
            Thread.sleep(1L);
        } catch (InterruptedException e) { }
        return train;
    }
}
