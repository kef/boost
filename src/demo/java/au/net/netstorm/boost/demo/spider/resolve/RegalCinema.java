package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

final class RegalCinema implements Cinema, GoodCitizen {
    private Movie movie;

    public RegalCinema() {
    }

    public Movie getMovie() {
        return movie;
    }
}
