package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.Interface;

public final class MockGreenprints extends BoooostCase implements Greenprints {
    private final Blueprint blueprint;
    private final boolean exists;
    private final Interface iface;
    private final Flavour flavour;

    public MockGreenprints(Blueprint blueprint, boolean exists, Interface iface, Flavour flavour) {
        this.blueprint = blueprint;
        this.exists = exists;
        this.iface = iface;
        this.flavour = flavour;
    }

    public Blueprint get(Interface iface, Flavour flavour) {
        check(iface, flavour);
        return blueprint;
    }

    public boolean exists(Interface iface, Flavour flavour) {
        check(iface, flavour);
        return exists;
    }

    private void check(Interface iface, Flavour flavour) {
        assertEquals(this.iface, iface);
        assertEquals(this.flavour, flavour);
    }
}
