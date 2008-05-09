package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.core.AutoEdger;
import demo.edge.java.lang.Class;

//FIX 2328 reinstate when default package mapping implemented
public class ClassDemoTest extends EdgeDemooooTest {
    AutoEdger edger;

    public void testNewInstance() {
        // FIX 2328 unchecked cast - handling generic classes in edge method should
        // FIX 2328 take same approach as Nu, see gunge.generics.TypeToken
        Class<String> subject = edger.edge(Class.class, String.class);
        String result = subject.newInstance();
        assertEquals("", result);
    }
}
