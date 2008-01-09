package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class MockBlueprintsRead extends BoooostCase implements BlueprintsRead {
    private final Blueprint blueprint;
    private final boolean exists;
    private final Interface iface;

    public MockBlueprintsRead(Blueprint blueprint, boolean exists, Interface iface) {
        this.blueprint = blueprint;
        this.exists = exists;
        this.iface = iface;
    }

    public Blueprint get(Implementation host, Interface iface) {
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
