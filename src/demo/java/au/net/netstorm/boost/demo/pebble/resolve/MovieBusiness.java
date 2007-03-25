package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Pebble;

public final class MovieBusiness implements Pebble, Business {
    private Actor actor;
    private Celebrity celebrity;

    public Actor getActor() {
        return actor;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }
}
