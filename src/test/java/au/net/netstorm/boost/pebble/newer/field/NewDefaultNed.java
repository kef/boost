package au.net.netstorm.boost.pebble.newer.field;

import au.net.netstorm.boost.pebble.newer.core.Newer;

interface NewDefaultNed extends Newer {
    Class IMPLEMENTATION = DefaultNed.class;

    Ned create();
}
