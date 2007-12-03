package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.PartialInstances;
import au.net.netstorm.boost.spider.onion.layer.closure.TryCatchFinally;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class SpiderTryFinallyAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    TryCatchFinally subject;
    PartialInstances partialInstancesMock;

    public void setUpFixtures() {
        subject = new SpiderTryCatchFinally(partialInstancesMock);
    }

    public void testIn() {
        expect.oneCall(partialInstancesMock, VOID, "clear");
        subject.theCore();
    }

    public void testOut() {
        expect.oneCall(partialInstancesMock, VOID, "clear");
        subject.theFinally();
    }
}
