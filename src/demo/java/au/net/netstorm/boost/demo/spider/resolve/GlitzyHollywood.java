package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class GlitzyHollywood implements GoodCitizen, Hollywood {
    private Celebrity celebrity;
    private Actor actor;
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public Actor getActor() {
        return actor;
    }
}
