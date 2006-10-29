package au.net.netstorm.boost.demo.automock;


import org.jmock.MockObjectTestCase;
import org.jmock.Mock;

import java.util.Map;

// FIX SC525 Remove.  Just a spike
public final class FooTest extends MockObjectTestCase {
    public void testXxx() {
        DelegateSubject delegate = null;
        BrokenTestSubject testSubject = new BrokenTestSubject(delegate);
        Mock mockMap = mock(Map.class);
        mockMap.expects(once()).method("get").with(eq("key")).will(returnValue("foo"));
//        mockSubscriber.expects(once()).method("receive").with( eq(message) );
        Map map = (Map) mockMap.proxy();
        testSubject.execute(map);
    }
}
