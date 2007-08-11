package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.primordial.Primordial;

final class MovieBusiness extends Primordial implements Business {
    Actor actor;
    Celebrity celebrity;

    public Actor getActor() {
        return actor;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }
}
