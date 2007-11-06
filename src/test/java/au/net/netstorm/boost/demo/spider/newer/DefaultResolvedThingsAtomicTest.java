package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolvedThingsAtomicTest extends InteractionTestCase implements LazyFields, HasFixtures {
    ResolvedThings subject;
    Interface iface;
    BaseReference expected;
    Interface doesNotExist;
    FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void setUpFixtures() {
        subject = new DefaultResolvedThings();
        fielder.setInstance(doesNotExist, "type", String.class);
    }

    public void testExists() {
        checkExists(iface, false);
        checkPut(iface, expected);
        checkExists(iface, true);
    }

    public void testPutSuccess() {
        checkPut(iface, expected);
    }

    public void testPutFailure() {
        subject.put(iface, expected);
        try {
            subject.get(doesNotExist);
            fail();
        } catch (IllegalStateException expected) { }
    }

    public void testRemove() {
        subject.put(iface, expected);
        subject.remove(iface);
        checkExists(iface, false);
    }

    private void checkExists(Interface myimpl, boolean myexpected) {
        boolean actual = subject.exists(myimpl);
        assertEquals(myexpected, actual);
    }

    private void checkPut(Interface implementation, BaseReference baseReference) {
        subject.put(implementation, baseReference);
        ResolvedInstance actual = subject.get(iface);
        assertEquals(expected, actual);
    }
}
