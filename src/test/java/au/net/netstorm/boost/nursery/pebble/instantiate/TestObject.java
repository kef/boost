package au.net.netstorm.boost.nursery.pebble.instantiate;

import au.net.netstorm.boost.primordial.Primordial;

final class TestObject extends Primordial {
    private String name;

    // FIX 1665 Make this guy package private and get to work.
    TestObject(String name) {
        this.name = name;
    }
}
