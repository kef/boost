package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.nursery.automock.MockExpectations;
import au.net.netstorm.boost.nursery.automock.PrimordialTestCase;
import au.net.netstorm.boost.nursery.automock.UsesMocks;

import java.util.Map;

public final class AutoMockDemoTest extends PrimordialTestCase implements UsesMocks {
    private Map map;
    private DelegateSubject delegate;
    private TestSubject subject;
    private MockExpectations expect;

    public void setupSubjects() {
        subject = new DefaultTestSubject(delegate);
    }

    public void testInteraction() {
        CharSequence value = "Masters of Doom";
        expect.oneCall(map, "get", value, "quake");
        expect.oneCall(delegate, "operate", VOID, value);
        subject.execute(map);
    }

    public void testExceptions() {
        // FIX SC525 This should fail at the moment.
        expect.throwsException(subject, "fails", new UnsupportedOperationException());
    }
}
