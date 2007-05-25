package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class DefaultTryFinallyClosureAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    TryFinallyClosure subject;
    Method method;
    Object irrelevant;

    public void setupSubjects() {
        subject = new DefaultTryFinallyClosure();
    }

    public void testSomething() throws Throwable {
        subject.invoke(irrelevant, method, null);
        // FIX 54976 Complete.
    }
}
