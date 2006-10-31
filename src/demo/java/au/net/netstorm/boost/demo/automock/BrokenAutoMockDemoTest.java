package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;
import junit.framework.AssertionFailedError;

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
        expect.oneCall(map, "return", "get", "key");
        try {
            subject.execute(map);
            verify();
            barf();
        } catch (AssertionFailedError expected) { }
        ensureVerifiesOkNow();
    }

    private void barf() {
        throw new RuntimeException("Test failed, however we cannot throw an AssertFailedError as this is what we are trying to test.");
    }

    private void ensureVerifiesOkNow() {
        map.get("key");
    }
}
