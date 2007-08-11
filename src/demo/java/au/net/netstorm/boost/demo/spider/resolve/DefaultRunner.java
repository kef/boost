package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.primordial.Primordial;

final class DefaultRunner extends Primordial implements Runner {
    Ball ball;

    public Ball getBall() {
        return ball;
    }

    public int getAge() {
        return 25;
    }
}
