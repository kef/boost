package au.net.netstorm.boost.demo.automock;

import java.util.Map;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;
import junit.framework.AssertionFailedError;

public final class BrokenAutoMockDemoTest extends InteractionTestCase {
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
            subject.executeGet(map);
            verify();
            barf();
        } catch (AssertionFailedError expected) {
        }
        ensureVerifiesOkNow();
    }

    private void barf() {
        throw new RuntimeException("Test failed, however we cannot throw an AssertFailedError as this is what we are trying to test.");
    }

    private void ensureVerifiesOkNow() {
        map.get("key");
    }
}
