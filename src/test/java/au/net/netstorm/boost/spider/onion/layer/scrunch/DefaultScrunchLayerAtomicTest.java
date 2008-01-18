package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class DefaultScrunchLayerAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    ScrunchLayer subject;
    Layer nextMock;
    Object returned;
    Method method;
    Object[] parameters;

    public void setUpFixtures() {
        subject = new DefaultScrunchLayer(nextMock);
    }

    public void testUsable() {
        expect.oneCall(nextMock, returned, "invoke", method, parameters);
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
