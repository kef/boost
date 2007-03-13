package au.net.netstorm.boost.pebble.create.fixture;

import au.net.netstorm.boost.pebble.create.core.Newer;

public interface NewDefaultNed extends Newer {
    Class IMPLEMENTATION = DefaultNed.class;

    Ned create();
}
