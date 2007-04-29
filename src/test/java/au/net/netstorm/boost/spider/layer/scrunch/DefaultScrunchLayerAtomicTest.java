package au.net.netstorm.boost.spider.layer.scrunch;

import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.layer.core.Layer;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultScrunchLayerAtomicTest extends InteractionTestCase {
    private static final Class[] NO_ARGS = {};
    EdgeClass edgeClass = new DefaultEdgeClass();
    ScrunchLayer subject;
    Layer next;
    Object irrelevant;
    Object value;
    Object returned;
    Object[] parameters = new Object[]{value};
    Method method = mockMethod(); // FIX BREADCRUMB 1936 AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA Automock should mock "Method".

    // FIX 1936 Testing this becomes a whole lot easier when ONION w/ outside/inside is complete.
    public void setupSubjects() {
        subject = new DefaultScrunchLayer(next);
    }

    // FIX 1936 Complete.
    public void testUsable() {
        expect.oneCall(next, returned, "invoke", method, parameters);
        Object result = subject.invoke(method, parameters);
        assertEquals(returned, result);
    }

    public void testScrunch() {
        subject.scrunch();
        try {
            subject.invoke(method, parameters);
            fail();
        } catch (ScrunchException expected) { }
    }

    private Method mockMethod() {
        Class cls = getClass();
        return edgeClass.getMethod(cls, "setupSubjects", NO_ARGS);
    }
}
