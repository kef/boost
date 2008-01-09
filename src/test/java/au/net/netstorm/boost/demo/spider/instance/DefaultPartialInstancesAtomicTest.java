package au.net.netstorm.boost.demo.spider.instance;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultPartialInstancesAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    PartialInstances subject;
    Implementation impl;
    BaseReference instance;
    Implementation doesNotExist;

    public void setUpFixtures() {
        subject = new DefaultPartialInstances();
        subject.clear();
        fielder.setInstance(doesNotExist, "impl", String.class);
    }

    public void testExists() {
        checkExists(impl, false);
        checkPut(impl, instance);
        checkExists(impl, true);
    }

    public void testPutSuccess() {
        checkPut(impl, instance);
    }

    public void testGetFailure() {
        subject.put(impl, instance);
        try {
            subject.get(doesNotExist);
            fail();
        } catch (IllegalStateException expected) { }
    }

    public void testPutFailure() {
        subject.put(impl, instance);
        try {
            subject.put(impl, instance);
            fail();
        }
        catch (IllegalStateException expected) {
        }
    }

    public void testRemove() {
        subject.put(impl, instance);
        subject.remove(impl);
        checkExists(impl, false);
    }

    private void checkExists(Implementation myimpl, boolean myexpected) {
        boolean actual = subject.exists(myimpl);
        assertEquals(myexpected, actual);
    }

    private void checkPut(Implementation implementation, BaseReference baseReference) {
        subject.put(implementation, baseReference);
        ResolvedInstance actual = subject.get(impl);
        assertEquals(instance, actual);
    }
}
