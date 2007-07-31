package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.onion.layer.closure.TryCatchFinally;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class SpiderTryFinallyAtomicTest extends InteractionTestCase implements LazyFields, HasFixtures {
    TryCatchFinally subject;
    ResolvedThings resolvedThingsMock;

    public void setUpFixtures() {
        subject = new SpiderTryCatchFinally(resolvedThingsMock);
    }

    public void testIn() {
        expect.oneCall(resolvedThingsMock, MockExpectations.VOID, "clear");
        subject.theCore();
    }

    public void testOut() {
        expect.oneCall(resolvedThingsMock, MockExpectations.VOID, "clear");
        subject.theFinally();
    }
}
