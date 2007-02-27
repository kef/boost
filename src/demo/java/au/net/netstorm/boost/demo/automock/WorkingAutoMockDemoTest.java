package au.net.netstorm.boost.demo.automock;

import java.util.Map;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class WorkingAutoMockDemoTest extends PrimordialTestCase implements UsesMocks {
    private Map map;
    private DelegateSubject delegate;
    private TestSubject subject;
    private MockExpectations expect;
    // FIX BREADCRUMB 35058 Make this private.
//    private DataInput[] dataInputs;

    public void setupSubjects() {
        subject = new WorkingTestSubject(delegate);
    }

    public void testInteraction() {
        String value = "Masters of Doom";
        expect.oneCall(map, value, "get", "quake");
        expect.oneCall(delegate, VOID, "operate", value);
        subject.executeGet(map);
    }

    public void testNullValue() {
        String value = null;
        expect.oneCall(map, value, "get", "quake");
        expect.oneCall(delegate, VOID, "operate", value);
        subject.executeGet(map);
    }

    public void testExceptions() {
        String value = "bad value";
        expect.oneCall(map, value, "get", "quake");
        expect.oneCall(delegate, new IllegalStateException(), "operate", value);
        try {
            subject.executeGet(map);
            fail();
        } catch (IllegalArgumentException e) { }
    }

//    public void testArray() {
//        expect.oneCall(map, VOID, "put", "streetfighter", dataInputs);
//        subject.executePut(map, dataInputs);
//    }
}
