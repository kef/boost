package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class DefaultTryFinallyClosureAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    TryFinallyClosure subject;

    public void setupSubjects() {
        subject = new DefaultTryFinallyClosure();
    }

    public void testSomething() {
        // FIX 54976 Complete.
    }
}
