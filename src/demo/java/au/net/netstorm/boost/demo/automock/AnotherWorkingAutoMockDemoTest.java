package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class AnotherWorkingAutoMockDemoTest extends InteractionTestCase {
    private TestSubject subject;
    private DelegateSubject delegate;
    private int randomInt1;
    private int randomInt2;
    private String[] randomStrings;

    public void setupSubjects() {
        subject = new AnotherWorkingTestSubject(delegate);
    }

    public void testMultipleCalls() {
        expect.manyCalls(delegate, VOID, "operate", "foo");
        subject.executeGet(null);
        subject.executeGet(null);
    }

    public void testRandomizationOfInts() {
        assertNotEquals(randomInt1, randomInt2);
    }

//    public void testPrimitiveArrays() {
//        assertEquals(5, randomStrings.length);
//    }
}
