package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.Citizen;

final class RegalCinema implements Cinema, Citizen {
    private Movie movie;

    public RegalCinema() {
    }

    public Movie getMovie() {
        return movie;
    }
}
