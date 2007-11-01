package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.test.core.Timed;

public final class ResolveParallelDemoTest extends ParallelTest implements Timed {
    Integer threads = 5;

    public void testResolveWithMultipleThreads() {
        Train train = getTrain();
        checkTrain(train);
    }

    public void testIsMultiThreaded() {
        int count = DefaultRailwayTrack.trainCount;
        assertEquals(threads, count);
    }

    private Train getTrain() {
        RailwayTrack track = (RailwayTrack) resolver.resolve(RailwayTrack.class);
        return track.getTrain();
    }

    private void checkTrain(Train train) {
        boolean empty = isEmpty(train);
        assertEquals(false, empty);
    }

    private boolean isEmpty(Train train) {
        return train == null;
    }
}