package au.net.netstorm.boost.demo.pebble.resolve;

import au.net.netstorm.boost.pebble.core.Pebble;

final class BigLebowski implements Movie, Pebble {
    // FIX 1757 Reinstate this as a gaijin.
    //    Set set;
    private TheDude theDude;

    public TheDude getTheDude() {
        return theDude;
    }
}
