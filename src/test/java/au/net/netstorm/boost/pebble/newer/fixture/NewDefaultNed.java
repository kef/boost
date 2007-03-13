package au.net.netstorm.boost.pebble.newer.fixture;

import au.net.netstorm.boost.pebble.newer.core.Newer;

public interface NewDefaultNed extends Newer {
    Class IMPLEMENTATION = DefaultNed.class;

    Ned create();
}
