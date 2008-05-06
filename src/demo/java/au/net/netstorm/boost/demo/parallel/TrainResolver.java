package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.nursery.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.sniper.core.BoooostCase;
import au.net.netstorm.boost.spider.builder.Spider;

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
        Railyard track = spider.resolve(Railyard.class);
        return track.getTrain();
    }
}
