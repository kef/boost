package au.net.netstorm.boost.spider.onion.layer.scrunch;

import java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultScrunchLayerAtomicTest extends InteractionTestCase {
    ScrunchLayer subject;
    Layer next;
    Object returned;
    Method method;
    Object[] parameters;

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
