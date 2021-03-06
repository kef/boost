package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.onion.core.Layer;

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
