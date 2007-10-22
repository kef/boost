package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.test.parallel.Parallel;

public final class SimpleParallelDemoTest extends ParallelTest implements Parallel {
    private Spider resolver = getSpider();
    Integer threads = 5;

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
