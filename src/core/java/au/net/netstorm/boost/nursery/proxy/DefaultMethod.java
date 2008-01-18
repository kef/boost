package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.util.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.util.exception.ThrowableMaster;

// FIX () FRED 12345 Move this out of edge or something, or sort it out.
public final class DefaultMethod implements Method {
    private final ThrowableMaster tosser = new DefaultThrowableMaster();
    private final java.lang.reflect.Method delegate;

    public DefaultMethod(java.lang.reflect.Method delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object ref, Object... args) {
        try {
            delegate.setAccessible(true);
            return delegate.invoke(ref, args);
        } catch (Throwable t) {
            Throwable real = tosser.realCause(t);
            return tosser.rethrow(real);
        }
    }

    public String getName() {
        return delegate.getName();
    }
}
