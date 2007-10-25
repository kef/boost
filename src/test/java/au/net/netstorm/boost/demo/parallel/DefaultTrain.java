package au.net.netstorm.boost.demo.parallel;

public class DefaultTrain implements Train {
    public DefaultTrain() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) { }
    }
}
