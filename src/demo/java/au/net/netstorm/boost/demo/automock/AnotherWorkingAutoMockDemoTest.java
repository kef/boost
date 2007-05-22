package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class AnotherWorkingAutoMockDemoTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    TestSubject subject;
    DelegateSubject delegate;
    String[] strings1;
    String[] strings2;
    Integer integer1;
    Integer integer2;
    Simian[] monkeys;
    Simian[] apes;

    public void setupSubjects() {
        subject = new AnotherWorkingTestSubject(delegate);
    }

    public void testMultipleCalls() {
        expect.manyCalls(delegate, VOID, "operate", "foo");
        subject.executeGet(null);
        subject.executeGet(null);
    }

    public void testRandomInteger() {
        // FIX DEBT Reintroduce this check (once sufficiently random).  Ha Ha Ha
//        assertNotEquals(integer1, integer2);
    }

    public void testArrays() {
        assertEquals(true, strings1[0] != null);
        assertNotEquals(strings1, strings2);
    }

    public void testInterfaces() {
        assertNotEquals(monkeys, apes);
        // FIX BREADCRUMB 37874 Here we are.
//        assertEquals(monkeys[0].equals(monkeys[0]));
    }
}
