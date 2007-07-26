package au.net.netstorm.boost.spider.onion.layer.scrunch;

import java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;

public final class DefaultScrunchLayerAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
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
