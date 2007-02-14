package au.net.netstorm.boost.demo.pebble.create;

import au.net.netstorm.boost.pebble.create.Newer;

interface NewDefaultBob extends Newer {
    Class IMPLEMENTATION = DefaultBob.class;

    Bob create(String comment);
}
