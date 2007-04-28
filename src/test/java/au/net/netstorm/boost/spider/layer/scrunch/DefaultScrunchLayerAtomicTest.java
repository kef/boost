package au.net.netstorm.boost.spider.layer.scrunch;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultScrunchLayerAtomicTest extends InteractionTestCase {
    ScrunchLayer subject;
    Object next;

    public void setupSubjects() {
        subject = new DefaultScrunchLayer(next);
    }

    // FIX 1936 Complete.
    public void testScrunch() {
    }
}
