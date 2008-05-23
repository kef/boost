package au.net.netstorm.boost.spider.instance;

import au.net.netstorm.boost.gunge.type.BaseReference;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.core.Destroyable;

public final class DefaultPartialInstancesAtomicTest extends LifecycleTestCase implements Destroyable, LazyFields, HasFixtures {
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    PartialInstances subject;
    Implementation implMock;
    BaseReference instanceMock;
    Implementation doesNotExist;

    public void setUpFixtures() {
        subject = new DefaultPartialInstances();
        subject.clear();
        fielder.setInstance(doesNotExist, "impl", String.class);
    }

    public void destroy() {
        subject.clear();
    }

    public void testExists() {
        checkExists(implMock, false);
        checkPut(implMock, instanceMock);
        checkExists(implMock, true);
    }

    public void testPutSuccess() {
        checkPut(implMock, instanceMock);
    }

    public void testGetFailure() {
        subject.put(implMock, instanceMock);
        try {
            subject.get(doesNotExist);
            fail();
        } catch (IllegalStateException expected) { }
    }

    public void testPutFailure() {
        subject.put(implMock, instanceMock);
        try {
            subject.put(implMock, instanceMock);
            fail();
        }
        catch (IllegalStateException expected) {
        }
    }

    public void testRemove() {
        subject.put(implMock, instanceMock);
        subject.remove(implMock);
        checkExists(implMock, false);
    }

    private void checkExists(Implementation myimpl, boolean myexpected) {
        boolean actual = subject.exists(myimpl);
        assertEquals(myexpected, actual);
    }

    private void checkPut(Implementation implementation, BaseReference baseReference) {
        subject.put(implementation, baseReference);
        ResolvedInstance actual = subject.get(implMock);
        assertEquals(instanceMock, actual);
    }
}
