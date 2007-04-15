package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.spider.core.Citizen;

public final class MovieBusiness implements Citizen, Business {
    private Actor actor;
    private Celebrity celebrity;

    public Actor getActor() {
        return actor;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }
}
