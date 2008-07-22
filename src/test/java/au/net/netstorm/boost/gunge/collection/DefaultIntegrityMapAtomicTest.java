package au.net.netstorm.boost.gunge.collection;

import java.util.Collection;
import java.util.Iterator;
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
    Iterator iteratorMock;

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

    public void testGetAll() {
        expect.oneCall(delegateMock, setMock, "values");
        Collection actual = subject.getAll();
        assertSame(setMock, actual);
    }

    public void testReplaceBarf() {
        expect.oneCall(delegateMock, false, "containsKey", keyDummy);
        try {
            subject.replace(keyDummy, valueDummy);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    public void testReplace() {
        expect.oneCall(delegateMock, true, "containsKey", keyDummy);
        expect.oneCall(delegateMock, VOID, "put", keyDummy, valueDummy);
        subject.replace(keyDummy, valueDummy);
    }

    public void testIterator() {
        expect.oneCall(delegateMock, setMock, "keySet");
        expect.oneCall(setMock, iteratorMock, "iterator");
        Iterator actual = subject.iterator();
        assertSame(iteratorMock, actual);
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
        expect.oneCall(creatorMock, valueDummy, "apply", keyDummy);
        expect.oneCall(delegateMock, result, "putIfAbsent", keyDummy, valueDummy);
    }
}
