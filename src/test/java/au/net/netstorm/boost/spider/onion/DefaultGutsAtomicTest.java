package au.net.netstorm.boost.spider.onion;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX 1936 Move to separate package.
public final class DefaultGutsAtomicTest extends InteractionTestCase {
    EdgeClass classer = new DefaultEdgeClass();
    Guts subject;
    List guts = new ArrayList();
    Method add = method("add", new Class[]{Object.class});
    Method size = method("size", new Class[]{});
    Object[] args = {this};

    public void setupSubjects() {
        subject = new DefaultGuts(guts);
    }

    // FIX 1936 Implement "add".
    // FIX 1936 Implement "size" to check return values.
    public void testGuts() {
        Object result = subject.invoke(add, args);
        assertEquals(true, result);
        assertEquals(this, guts.get(0));
    }

    private Method method(String name, Class[] parameters) {
        Class cls = guts.getClass();
        return classer.getMethod(cls, name, parameters);
    }
}
