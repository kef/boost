package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Citizen;

final class RegalCinema implements Cinema, Citizen {
    private Movie movie;

    public RegalCinema() {
    }

    public Movie getMovie() {
        return movie;
    }
}
