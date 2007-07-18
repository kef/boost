package au.net.netstorm.boost.spider.onion.guts;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultGutsAtomicTest extends InteractionTestCase implements HasFixtures {
    EdgeClass classer = new DefaultEdgeClass();
    Guts subject;
    List guts = new ArrayList();
    Method add = method("add", new Class[]{Object.class});
    Method size = method("size", new Class[]{});
    Method toarray = method("toArray", new Class[]{});
    Object[] args = {this};
    Object[] noargs = {};
    Object[] elements = {this, this};

    public void setUpFixtures() {
        subject = new DefaultGuts(guts);
    }

    public void testGuts() {
        add();
        add();
        size();
        toarray();
    }

    private void add() {
        Object result = subject.invoke(add, args);
        assertEquals(Boolean.TRUE, result);
    }

    private void size() {
        Object result = subject.invoke(size, noargs);
        assertEquals(new Integer(2), result);
    }

    private void toarray() {
        Object[] result = (Object[]) subject.invoke(toarray, noargs);
        assertEquals(elements, result);
    }

    private Method method(String name, Class[] parameters) {
        Class cls = guts.getClass();
        return classer.getMethod(cls, name, parameters);
    }
}
