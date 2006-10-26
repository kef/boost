package au.net.netstorm.boost.demo.automock;

import au.net.netstorm.boost.nursery.automock.PrimordialTestCase;
import au.net.netstorm.boost.nursery.automock.UsesMocks;
import au.net.netstorm.boost.nursery.automock.MockExpectations;

import java.util.Map;
import java.util.HashMap;

public final class AutoMockDemoTest extends PrimordialTestCase implements UsesMocks {
    // Auto mocking for these.
    private Map map;
    private DelegateSubject delegate;
    // This is the thing we are actually testing.
    private TestSubject subject;

    // Provided to us because we implement UsesMocks and need to perform expectations.
    private MockExpectations expect;

    // These are left alone because they are non-null.
    private Map anotherMap = new HashMap();
    private static final String CONSTANT = "Some Constant";

    public void testInteraction() {
        // FIX SC525 Get this to work.
        CharSequence value = "Masters of Doom";
        expect.call(map, "get", value, "quake");
//        expect.call(delegate, "operate", null, value);
    }

    public void wireFixtures() {
        subject = new DefaultTestSubject(delegate);
    }
}
