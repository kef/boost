package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Pebble;

final class Cinema implements Pebble {
    // FIX 1779 Make this final to remove ambiguity?
    private Movie movie;

    public Cinema(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
