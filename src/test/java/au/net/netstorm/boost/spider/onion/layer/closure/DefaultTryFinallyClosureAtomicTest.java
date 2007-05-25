package au.net.netstorm.boost.spider.onion.layer.closure;

import java.lang.reflect.Method;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class DefaultTryFinallyClosureAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    TryFinallyClosure subject;
    Method method;
    Object irrelevant;
    Object delegate;
    TryFinally tryfinally;

    public void setupSubjects() {
        subject = new DefaultTryFinallyClosure(delegate, tryfinally);
    }

    // FIX 54976 1. Ensure in() is called.
    // FIX 54976 2. Ensure out() is called.
    // FIX 54976 3. Ensure out() is called even when an exception is thrown.
    // FIX 54976 Complete this test.
    public void testSomething() throws Throwable {
        Object result = subject.invoke(irrelevant, method, null);
    }
}
