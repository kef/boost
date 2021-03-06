package au.net.netstorm.boost.demo.automock;

import java.util.Map;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public final class WorkingMockDemoTest extends MockObjectTestCase {
    private Mock mockMap;
    private Map map;
    private Mock mockDelegate;
    private DelegateSubject delegate;
    private TestSubject subject;

    protected void setUp() throws Exception {
        mockMap = mock(Map.class);
        map = (Map) mockMap.proxy();
        mockDelegate = mock(DelegateSubject.class);
        delegate = (DelegateSubject) mockDelegate.proxy();
        subject = new WorkingTestSubject(delegate);
    }

    public void testInteraction() {
        CharSequence value = "Masters of Doom";
        mockMap.expects(once()).method("get").with(eq("quake")).will(returnValue(value));
        mockDelegate.expects(once()).method("operate").with(same(value));
        subject.executeGet(map);
    }
}
