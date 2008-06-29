package au.net.netstorm.boost.gunge.collection;

import java.util.concurrent.ConcurrentMap;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultIntegrityMapAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    IntegrityMap subject;
    FieldTestUtil fielder;
    ConcurrentMap delegateMock;
    Object keyDummy;
    Object valueDummy;
    Object oldDummy;
    Creator creatorMock;

    public void setUpFixtures() {
        fielder.setInstance(subject, "delegate", delegateMock);
    }

    public void testGet() {
        expectCached(valueDummy);
        Object actual = subject.getOrCreate(keyDummy, creatorMock);
        assertSame(valueDummy, actual);
    }

    public void testCreate() {
        expectCreateAndCache(VOID);
        Object actual = subject.getOrCreate(keyDummy, creatorMock);
        assertSame(valueDummy, actual);
    }

    public void testCreateConcurrent() {
        expectCreateAndCache(oldDummy);
        Object actual = subject.getOrCreate(keyDummy, creatorMock);
        assertSame(oldDummy, actual);
    }

    private void expectCached(Object cached) {
        expect.oneCall(delegateMock, cached, "get", keyDummy);
    }

    private void expectCreateAndCache(Object result) {
        expectCached(VOID);
        expect.oneCall(creatorMock, valueDummy, "create", keyDummy);
        expect.oneCall(delegateMock, result, "putIfAbsent", keyDummy, valueDummy);
    }
}
