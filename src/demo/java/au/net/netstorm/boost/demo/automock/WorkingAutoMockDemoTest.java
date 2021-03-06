package au.net.netstorm.boost.demo.automock;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import org.jmock.util.NotImplementedException;

public final class WorkingAutoMockDemoTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    TestSubject subject;
    Map mapMock;
    DelegateSubject delegateMock;
    List[] lists;
    List listDummy;
    SomeData someDataMock;
    SomeData someData;

    public void setUpFixtures() {
        subject = new WorkingTestSubject(delegateMock);
    }

    public void testMockOverridesDataStubs() {
        assertEquals(true, Proxy.isProxyClass(someDataMock.getClass()));
        assertEquals(DefaultSomeData.class, someData.getClass());
    }

    public void testDummyInjection() {
        try {
            listDummy.size();
            fail();
        } catch (NotImplementedException expected) {}
    }

    public void testInteraction() {
        String value = "Masters of Doom";
        expect.oneCall(mapMock, value, "get", "quake");
        expect.oneCall(delegateMock, VOID, "operate", value);
        subject.executeGet(mapMock);
    }

    public void testNullValue() {
        String value = null;
        expect.oneCall(mapMock, value, "get", "quake");
        expect.oneCall(delegateMock, VOID, "operate", value);
        subject.executeGet(mapMock);
    }

    public void testExceptions() {
        String value = "bad value";
        expect.oneCall(mapMock, value, "get", "quake");
        expect.oneCall(delegateMock, new IllegalStateException(), "operate", value);
        try {
            subject.executeGet(mapMock);
            fail();
        } catch (IllegalArgumentException e) { }
    }

    public void testArray() {
        setUpArrayExpectations();
        subject.executePut(mapMock, lists);
    }

    private void setUpArrayExpectations() {
        expect.oneCall(mapMock, VOID, "put", "streetfighter", lists);
        Integer dummySize = new Integer(2);
        for (int i = 0; i < lists.length; i++) {
            expect.oneCall(lists[i], dummySize, "size");
        }
    }
}
