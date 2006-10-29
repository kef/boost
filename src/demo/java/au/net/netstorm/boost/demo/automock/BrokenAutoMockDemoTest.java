package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.test.automock.MockExpectations;

import java.util.Map;

public final class BrokenAutoMockDemoTest extends PrimordialTestCase implements UsesMocks {
    private DelegateSubject delegate;
    private TestSubject subject;
    private Map map;
    private MockExpectations expect;

    public void setupSubjects() {
        subject = new BrokenTestSubject(delegate);
    }

    public void testBroken() {
        // FIX SC525 Assert an exception is thrown.
        expect.oneCall(map, "get", "return", "key");
        subject.execute(map);
    }
}
