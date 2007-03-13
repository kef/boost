package au.net.netstorm.boost.pebble.create.fixture;

import au.net.netstorm.boost.pebble.create.core.Creator;

public interface NewDefaultNed extends Creator {
    Class IMPLEMENTATION = DefaultNed.class;

    Ned create();
}
