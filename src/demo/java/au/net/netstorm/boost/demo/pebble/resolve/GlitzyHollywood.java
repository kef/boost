package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Pebble;

public final class GlitzyHollywood implements Pebble, Hollywood {
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
