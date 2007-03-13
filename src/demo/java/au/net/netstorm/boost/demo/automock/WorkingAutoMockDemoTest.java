package au.net.netstorm.boost.demo.automock;

import java.util.List;
import java.util.Map;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class WorkingAutoMockDemoTest extends InteractionTestCase {
    private Map map;
    private DelegateSubject delegate;
    private TestSubject subject;
    private MockExpectations expect;
    private List list1;
    private List list2;
    private final List[] lists = new List[2];

    public void setupSubjects() {
        lists[0] = list1;
        lists[1] = list2;
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
