package au.net.netstorm.boost.pebble.create.fixture;

import au.net.netstorm.boost.pebble.create.Newer;

public interface NewTedImpl extends Newer {
    Class IMPLEMENTATION = TedImpl.class;

    Ted create();
}
