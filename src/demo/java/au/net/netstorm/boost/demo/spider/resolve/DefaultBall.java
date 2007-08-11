package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.primordial.Primordial;

final class DefaultBall extends Primordial implements Ball {
    Runner runner;

    public Runner getRunner() {
        return runner;
    }

    public int getSize() {
        return 4;
    }
}
