package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.spider.core.GoodCitizen;

final class BigLebowski implements Movie, GoodCitizen {
    private final TheDude theDude;

    public BigLebowski(TheDude theDude) {
        this.theDude = theDude;
    }

    public TheDude getTheDude() {
        return theDude;
    }
}
