package au.net.netstorm.boost.pebble.create.fixture;

import au.net.netstorm.boost.pebble.create.core.Creator;

public interface NewTedImpl extends Creator {
    Class IMPLEMENTATION = TedImpl.class;

    Ted create();
}
