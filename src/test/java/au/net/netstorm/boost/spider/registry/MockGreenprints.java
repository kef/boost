package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.Interface;

public final class MockGreenprints extends BoooostCase implements Greenprints {
    private final Blueprint blueprint;
    private final boolean exists;
    private final Interface iface;

    public MockGreenprints(Blueprint blueprint, boolean exists, Interface iface) {
        this.blueprint = blueprint;
        this.exists = exists;
        this.iface = iface;
    }

    public Blueprint get(Interface iface) {
        check(iface);
        return blueprint;
    }

    public boolean exists(Interface iface) {
        check(iface);
        return exists;
    }

    private void check(Interface iface) {
        assertEquals(this.iface, iface);
    }
}
