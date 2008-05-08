package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.instance.PartialInstances;
import au.net.netstorm.boost.spider.onion.layer.closure.TryFinally;

public final class SpiderTryFinallyAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    TryFinally subject;
    PartialInstances partialInstancesMock;

    public void setUpFixtures() {
        subject = new SpiderTryFinally(partialInstancesMock);
    }

    public void testIn() {
        subject.theCore();
    }

    public void testOut() {
        expect.oneCall(partialInstancesMock, VOID, "clear");
        subject.theFinally();
    }
}
