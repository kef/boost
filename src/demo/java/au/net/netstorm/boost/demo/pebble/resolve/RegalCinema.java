package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Pebble;

final class RegalCinema implements Cinema, Pebble {
    // FIX 1779 Make this final to remove ambiguity?
    private Movie movie;

    public RegalCinema() {
    }

    public Movie getMovie() {
        return movie;
    }
}
