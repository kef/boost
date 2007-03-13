package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.newer.core.Newer;

interface NewDefaultBob extends Newer {
    Class IMPLEMENTATION = DefaultBob.class;

    // FIX 1715 Ensure the "newify" method name is named "nu".
    Bob nu(String comment);
}
