package au.net.netstorm.boost.pebble.inject.newer.field;

import au.net.netstorm.boost.pebble.inject.newer.core.Newer;

interface NewDefaultNed extends Newer {
    Class IMPLEMENTATION = DefaultNed.class;

    Ned create();
}
