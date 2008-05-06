package au.net.netstorm.boost.demo.spider.resolve;

public class DefaultTrain implements Train {
    public DefaultTrain() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) { }
    }
}
