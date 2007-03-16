package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.core.Pebble;

final class Rob implements Pebble {
    private NewDefaultBob newDefaultBob;

    public Bob getBob() {
        return newDefaultBob.nu("I am your friend.");
    }
}