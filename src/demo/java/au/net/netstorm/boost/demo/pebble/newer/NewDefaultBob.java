package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.inject.newer.core.Newer;

interface NewDefaultBob extends Newer {
    Class IMPLEMENTATION = DefaultBob.class;

    Bob nu(String comment);
}
