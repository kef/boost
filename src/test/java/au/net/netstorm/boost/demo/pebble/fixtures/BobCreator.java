package au.net.netstorm.boost.demo.pebble.fixtures;

import au.net.netstorm.boost.nursery.pebble.create.Creator;

public interface BobCreator extends Creator {
    Bob create(String comment);
}
