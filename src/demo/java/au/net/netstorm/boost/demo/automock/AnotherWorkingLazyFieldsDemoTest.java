package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class AnotherWorkingLazyFieldsDemoTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    TestSubject subject;
    DelegateSubject delegateMock;
    String[] strings1;
    String[] strings2;
    Integer integer1;
    Integer integer2;
    Simian[] monkeys;
    Simian[] apes;

    public void setUpFixtures() {
        subject = new AnotherWorkingTestSubject(delegateMock);
    }

    public void testMultipleCalls() {
        expect.manyCalls(delegateMock, VOID, "operate", "foo");
        subject.executeGet(null);
        subject.executeGet(null);
    }

    public void testRandomInteger() {
        assertNotEquals(integer1, integer2);
    }

    public void testArrays() {
        assertEquals(true, strings1[0] != null);
        assertNotEquals(strings1, strings2);
    }

    public void testInterfaces() {
        assertNotEquals(monkeys, apes);
        assertEquals(true, monkeys[0].equals(monkeys[0]));
    }
}
