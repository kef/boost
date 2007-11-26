package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.demo.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.test.core.BoooostCase;

class TrainResolver implements Runnable {
    Spider spider;

    public TrainResolver() {
        createSpider();
    }

    public void run() {
        Train train = getTrain();
        BoooostCase.assertEquals(true, train != null);
    }

    private void createSpider() {
        BoostSpiderBuilder builder = new DefaultBoostSpiderBuilder();
        spider = builder.build();
    }

    private Train getTrain() {
        Railyard track = (Railyard) spider.resolve(Railyard.class);
        return track.getTrain();
    }
}
