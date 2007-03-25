package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class AnotherWorkingAutoMockDemoTest extends InteractionTestCase {
    TestSubject subject;
    DelegateSubject delegate;
    String[] randomStrings;
    Integer integer1;
    Integer integer2;

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

//    public void testPrimitiveArrays() {
//        assertEquals(5, randomStrings.length);
//    }
}
