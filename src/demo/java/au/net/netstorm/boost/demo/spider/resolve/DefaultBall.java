package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.bullet.primmm.Primordial;

final class DefaultBall extends Primordial implements Ball {
    Runner runner;

    public Runner getRunner() {
        return runner;
    }

    public int getSize() {
        return 4;
    }
}
