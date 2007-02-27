package au.net.netstorm.boost.demo.automock;

import java.util.List;
import java.util.Map;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.test.automock.PrimordialTestCase;
import au.net.netstorm.boost.test.automock.UsesMocks;

public final class WorkingAutoMockDemoTest extends PrimordialTestCase implements UsesMocks {
    private Map map;
    private DelegateSubject delegate;
    private TestSubject subject;
    private MockExpectations expect;
    private List[] lists;

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

    public void testArray() {
        setupArrayExpectations();
        subject.executePut(map, lists);
    }

    private void setupArrayExpectations() {
        expect.oneCall(map, VOID, "put", "streetfighter", lists);
        Integer dummySize = new Integer(2);
        for (int i = 0; i < lists.length; i++) {
            expect.oneCall(lists[i], dummySize, "size");
        }
    }
}
