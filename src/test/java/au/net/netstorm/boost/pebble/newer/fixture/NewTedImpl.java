package au.net.netstorm.boost.pebble.newer.fixture;

import au.net.netstorm.boost.pebble.newer.core.Newer;

public interface NewTedImpl extends Newer {
    Class IMPLEMENTATION = TedImpl.class;

    Ted create();
}
