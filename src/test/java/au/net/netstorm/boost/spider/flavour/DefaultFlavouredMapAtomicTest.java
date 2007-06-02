package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFlavouredMapAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    FlavouredMap subject;
    FlavouredMapEngine engine;
    FlavouredInterface flavoured;
    Interface iface;
    Flavour flavour;
    Object value;

    public void setupSubjects() {
        flavoured = new DefaultFlavouredInterface(iface, flavour);
        subject = new DefaultFlavouredMap(engine);
    }

    public void testGet() {
        expect.oneCall(engine, value, "get", flavoured);
        Object result = subject.get(iface, flavour);
        assertEquals(value, result);
    }

    public void testPut() {
        expect.oneCall(engine, VOID, "put", flavoured, value);
        subject.put(iface, flavour, value);
    }
}
