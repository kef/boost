package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class DefaultRunner implements Runner, GoodCitizen {
    Ball ball;

    public Ball getBall() {
        return ball;
    }

    public int getAge() {
        return 25;
    }
}
