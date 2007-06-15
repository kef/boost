package au.net.netstorm.boost.demo.automock;

import java.util.List;
import java.util.Map;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class WorkingAutoMockDemoTest extends InteractionTestCase implements HasFixtures, UsesAutoMocks {
    TestSubject subject;
    Map map;
    DelegateSubject delegate;
    List list2;
    List list1;
    List[] lists;

    public void setUpFixtures() {
        lists = new List[]{list1, list2};
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
        setUpArrayExpectations();
        subject.executePut(map, lists);
    }

    private void setUpArrayExpectations() {
        expect.oneCall(map, VOID, "put", "streetfighter", lists);
        Integer dummySize = new Integer(2);
        for (int i = 0; i < lists.length; i++) {
            expect.oneCall(lists[i], dummySize, "size");
        }
    }
}
