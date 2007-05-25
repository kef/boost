package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.onion.layer.closure.TryFinally;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class SpiderTryFinallyAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    TryFinally subject;
    ResolvedThings resolvedThings;

    public void setupSubjects() {
        subject = new SpiderTryFinally(resolvedThings);
    }

    // FIX 54976 Complete out().
    public void testIn() {
        expect.oneCall(resolvedThings, VOID, "clear");
        subject.in();
    }
}
