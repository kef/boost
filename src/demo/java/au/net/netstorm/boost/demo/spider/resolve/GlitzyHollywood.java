package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.primordial.Primordial;

final class GlitzyHollywood extends Primordial implements Hollywood {
    Celebrity celebrity;
    Actor actor;
    Movie movie;

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
