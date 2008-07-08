package au.net.netstorm.boost.gunge.collection;

import java.util.Set;
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
    Set setMock;
    Object keyDummy;
    Object valueDummy;
    Object oldDummy;
    Creator creatorMock;

    public void setUpFixtures() {
        fielder.setInstance(subject, "delegate", delegateMock);
    }

    public void testGet() {
        expectCached(valueDummy);
        Object actual = subject.get(keyDummy, creatorMock);
        assertSame(valueDummy, actual);
    }

    public void testCreate() {
        expectCreateAndCache(VOID);
        Object actual = subject.get(keyDummy, creatorMock);
        assertSame(valueDummy, actual);
    }

    public void testCreateConcurrent() {
        expectCreateAndCache(oldDummy);
        Object actual = subject.get(keyDummy, creatorMock);
        assertSame(oldDummy, actual);
    }

    public void testKeySet() {
        expect.oneCall(delegateMock, setMock, "keySet");
        Set actual = subject.keySet();
        assertSame(setMock, actual);
    }

    public void testGetExisting() {
        expect.oneCall(delegateMock, valueDummy, "get", keyDummy);
        Object actual = subject.get(keyDummy);
        assertSame(valueDummy, actual);
    }

    public void testGetBomb() {
        expect.oneCall(delegateMock, VOID, "get", keyDummy);
        try {
            subject.get(keyDummy);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    public void testPut() {
        expect.oneCall(delegateMock, VOID, "putIfAbsent", keyDummy, valueDummy);
        subject.put(keyDummy, valueDummy);
    }

    public void testPutBomb() {
        expect.oneCall(delegateMock, valueDummy, "putIfAbsent", keyDummy, valueDummy);
        try {
            subject.put(keyDummy, valueDummy);
            fail();
        } catch (IllegalArgumentException expected) {}
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
