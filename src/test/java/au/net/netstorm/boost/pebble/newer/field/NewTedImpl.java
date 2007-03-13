package au.net.netstorm.boost.pebble.newer.field;

import au.net.netstorm.boost.pebble.newer.core.Newer;

interface NewTedImpl extends Newer {
    Class IMPLEMENTATION = TedImpl.class;

    Ted create();
}
