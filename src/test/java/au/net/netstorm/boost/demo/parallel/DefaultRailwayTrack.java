package au.net.netstorm.boost.demo.parallel;

public class DefaultRailwayTrack implements RailwayTrack {
    public static int trainCount = 0;
    Train train;

    public Train getTrain() {
        trainCount++;
        return train;
    }
}
