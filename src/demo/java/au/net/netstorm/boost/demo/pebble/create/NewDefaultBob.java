package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.pebble.create.Creator;

interface NewDefaultBob extends Creator {
    Class IMPLEMENTATION = DefaultBob.class;

    Bob create(String comment);
}
