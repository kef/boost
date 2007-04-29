package au.net.netstorm.boost.spider.layer.scrunch;

import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.layer.core.Layer;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultScrunchLayerAtomicTest extends InteractionTestCase {
    EdgeClass edgeClass = new DefaultEdgeClass();
    ScrunchLayer subject;
    Layer next;
    Object value;
    Object returned;
    Object[] parameters = new Object[]{value};
    Method method;

    public void setupSubjects() {
        subject = new DefaultScrunchLayer(next);
    }

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
}
