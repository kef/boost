package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.demo.spider.resolve.ResolverDemooooTest;
import au.net.netstorm.boost.test.parallel.Parallel;

public final class SimpleParallelDemoTest extends ResolverDemooooTest implements Parallel {
    Integer threads = 5;

    {
        registry.single(RailwayTrack.class, DefaultRailwayTrack.class);
        registry.single(Train.class, ChooChooTrain.class);
    }

    public void testResolveWithMultipleThreads() {
        Train train = getTrain();
        checkTrain(train);
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
