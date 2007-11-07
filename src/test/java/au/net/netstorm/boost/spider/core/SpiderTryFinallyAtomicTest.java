package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.PartialInstances;
import au.net.netstorm.boost.spider.onion.layer.closure.TryCatchFinally;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;

public final class SpiderTryFinallyAtomicTest extends InteractionTestCase implements LazyFields, HasFixtures {
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
