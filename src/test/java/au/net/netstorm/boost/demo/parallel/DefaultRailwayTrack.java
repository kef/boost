package au.net.netstorm.boost.demo.parallel;

public class DefaultRailwayTrack implements RailwayTrack {
    public static final Object LOCK = new Object();
    public static int trainCount = 0;
    Train train;

    public Train getTrain() {
        synchronized (LOCK) {
            trainCount++;
        }
        return train;
    }
}
