package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Pebble;

final class RegalCinema implements Cinema, Pebble {
    private Movie movie;

    public RegalCinema() {
    }

    public Movie getMovie() {
        return movie;
    }
}
