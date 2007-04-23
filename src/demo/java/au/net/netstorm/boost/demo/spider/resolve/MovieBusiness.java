package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class MovieBusiness implements GoodCitizen, Business {
    private Actor actor;
    private Celebrity celebrity;

    public Actor getActor() {
        return actor;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }
}
