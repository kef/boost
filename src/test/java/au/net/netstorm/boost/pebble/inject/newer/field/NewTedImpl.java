package au.net.netstorm.boost.pebble.inject.newer.field;

import au.net.netstorm.boost.pebble.inject.newer.core.Newer;

interface NewTedImpl extends Newer {
    Class IMPLEMENTATION = TedImpl.class;

    Ted create();
}
