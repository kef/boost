package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Pebble;

final class BigLebowski implements Movie, Pebble {
    private final TheDude theDude;

    public BigLebowski(TheDude theDude) {
        this.theDude = theDude;
    }

    public TheDude getTheDude() {
        return theDude;
    }
}
