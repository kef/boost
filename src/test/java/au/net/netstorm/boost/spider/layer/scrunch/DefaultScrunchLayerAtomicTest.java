package au.net.netstorm.boost.spider.layer.scrunch;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultScrunchLayerAtomicTest extends InteractionTestCase {
    EdgeClass edgeClass = new DefaultEdgeClass();
    ScrunchLayer subject;
    Set next = new HashSet();
    Object irrelevant;
    Object value;
    Class[] addMethodTypes = {Object.class};

    public void setupSubjects() {
        subject = new DefaultScrunchLayer(next);
    }

    // FIX 1936 Complete.
    public void testUsable() throws Throwable {
        addThroughLayer();
        boolean callMade = next.contains(value);
        assertEquals(true, callMade);
    }

    public void testScrunch() throws Throwable {
        subject.scrunch();
        // FIX 1936 Reinstate.
/*
        try {
            addThroughLayer();
            fail();
        } catch (ScrunchException expected) { }
*/
    }

    private void addThroughLayer() throws Throwable {
        Method method = getMethod(next, "add", addMethodTypes);
        subject.invoke(irrelevant, method, new Object[]{value});
    }

    private Method getMethod(Object ref, String name, Class[] parameters) {
        Class cls = ref.getClass();
        return edgeClass.getMethod(cls, name, parameters);
    }
}
