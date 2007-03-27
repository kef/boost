package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class AnotherWorkingAutoMockDemoTest extends InteractionTestCase {
    TestSubject subject;
    DelegateSubject delegate;
    String[] strings1;
    String[] strings2;
    Integer integer1;
    Integer integer2;
    SomeInterface[] monkeys;
    SomeInterface[] apes;

    public void setupSubjects() {
        subject = new AnotherWorkingTestSubject(delegate);
    }

    public void testMultipleCalls() {
        expect.manyCalls(delegate, VOID, "operate", "foo");
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
    }
}
