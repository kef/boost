package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.onion.layer.closure.TryFinally;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class SpiderTryFinallyAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    TryFinally subject;

    public void setupSubjects() {
        subject = new SpiderTryFinally();
    }

    // FIX 54976 Complete.
    public void testTryFinally() {
        subject.in();
        subject.out();
    }
}
