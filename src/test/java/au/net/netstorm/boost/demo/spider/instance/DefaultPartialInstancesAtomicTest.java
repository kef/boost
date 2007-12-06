package au.net.netstorm.boost.demo.spider.instance;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultPartialInstancesAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    PartialInstances subject;
    Interface iface;
    BaseReference instance;
    Interface doesNotExist;
    FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void setUpFixtures() {
        subject = new DefaultPartialInstances();
        subject.clear();
        fielder.setInstance(doesNotExist, "type", String.class);
    }

    public void testExists() {
        checkExists(iface, false);
        checkPut(iface, instance);
        checkExists(iface, true);
    }

    public void testPutSuccess() {
        checkPut(iface, instance);
    }

    public void testGetFailure() {
        subject.put(iface, instance);
        try {
            subject.get(doesNotExist);
            fail();
        } catch (IllegalStateException expected) { }
    }

    public void testPutFailure() {
        subject.put(iface, instance);
        try {
            subject.put(iface, instance);
            fail();
        }
        catch (IllegalStateException expected) {
        }
    }

    public void testRemove() {
        subject.put(iface, instance);
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
        assertEquals(instance, actual);
    }
}