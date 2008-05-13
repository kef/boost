package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.core.AutoEdger;
import demo.edge.java.lang.Class;

public class ClassDemoTest extends EdgeDemooooTest {
    AutoEdger edger;

    public void testNewInstance() {
        // FIX 2328 unchecked cast - handling generic classes in edge method should take same approach as Nu, see SC 2363
        Class<String> subject = edger.edge(Class.class, String.class);
        String result = subject.newInstance();
        assertEquals("", result);
    }
}
