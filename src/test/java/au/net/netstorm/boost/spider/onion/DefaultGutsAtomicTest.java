package au.net.netstorm.boost.spider.onion;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// FIX 1936 Move to separate package.
public final class DefaultGutsAtomicTest extends InteractionTestCase {
    EdgeClass classer = new DefaultEdgeClass();
    Guts subject;
    Set guts = new HashSet();
    Method add = method("add", new Class[]{Object.class});
    Method size = method("size", new Class[]{});
    Object[] args = {this};

    public void setupSubjects() {
        subject = new DefaultGuts(guts);
    }

    public void testGuts() {
        Object result = subject.invoke(add, args);
    }

    private Method method(String name, Class[] parameters) {
        return classer.getMethod(HashSet.class, name, parameters);
    }
}
