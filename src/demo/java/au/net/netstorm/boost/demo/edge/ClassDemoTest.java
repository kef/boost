package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.scalpel.core.AutoEdger;
import demo.edge.java.lang.Class;

// FIX 2328 Ensure satisfactory message when an "instance" interface is used where "static" should be
// FIX 2328 and vice-versa.

public class ClassDemoTest extends EdgeDemooooTest {
    AutoEdger edger;

    public void testNewInstance() {
        // FIX 2328 unchecked cast - handling generic classes in edge method should take same approach as Nu, see SC 2363
        Class<String> subject = edger.edge(Class.class, String.class);
        String result = subject.newInstance();
        assertEquals("", result);
    }
}
