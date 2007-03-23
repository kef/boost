package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class AnotherWorkingAutoMockDemoTest extends InteractionTestCase {
    private TestSubject subject;
    private DelegateSubject delegate;
    private String[] randomStrings;

    public void setupSubjects() {
        subject = new AnotherWorkingTestSubject(delegate);
    }

    public void testMultipleCalls() {
        expect.manyCalls(delegate, VOID, "operate", "foo");
        subject.executeGet(null);
        subject.executeGet(null);
    }

    // FIX 1676 Write a test to check that we are randomizing dummies.
//    public void testPrimitiveArrays() {
//        assertEquals(5, randomStrings.length);
//    }
}
