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
            Thread.sleep(1L);
        } catch (InterruptedException e) { }
        return train;
    }
}
