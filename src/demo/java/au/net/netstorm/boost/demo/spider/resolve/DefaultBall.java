package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class DefaultBall implements Ball, GoodCitizen {
    Runner runner;

    public Runner getRunner() {
        return runner;
    }

    public int getSize() {
        return 4;
    }
}
