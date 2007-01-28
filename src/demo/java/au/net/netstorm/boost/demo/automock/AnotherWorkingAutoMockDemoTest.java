package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class AnotherWorkingAutoMockDemoTest extends PrimordialTestCase implements UsesMocks {
    private TestSubject subject;
    private DelegateSubject delegate;
    private MockExpectations expect;

    public void setupSubjects() {
        subject = new AnotherWorkingTestSubject(delegate);
    }

    public void testMultipleCalls() {
        expect.manyCalls(delegate, VOID, "operate", "foo");
        subject.execute(null);
        subject.execute(null);
    }
}
