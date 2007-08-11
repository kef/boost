package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFlavouredMapAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    FlavouredMap subject;
    FlavouredMapEngine engineMock;
    FlavouredInterface flavoured;
    Interface iface;
    Flavour flavour;
    Object value;
    Boolean exists;

    public void setUpFixtures() {
        flavoured = new DefaultFlavouredInterface(iface, flavour);
        subject = new DefaultFlavouredMap(engineMock);
    }

    public void testGet() {
        expect.oneCall(engineMock, value, "get", flavoured);
        Object result = subject.get(iface, flavour);
        assertEquals(value, result);
    }

    public void testPut() {
        expect.oneCall(engineMock, VOID, "put", flavoured, value);
        subject.put(iface, flavour, value);
    }

    public void testExists() {
        expect.oneCall(engineMock, exists, "exists", flavoured);
        boolean result = subject.exists(iface, flavour);
        assertEquals(exists, result);
    }
}
