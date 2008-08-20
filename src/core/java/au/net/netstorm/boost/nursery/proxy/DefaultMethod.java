package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.gunge.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

// FIX 2248 Move this out of edge or something, or sort it out.
public final class DefaultMethod implements Method {
    private static final Object NEVER = null;
    private final ThrowableMaster tosser = new DefaultThrowableMaster();
    private final java.lang.reflect.Method delegate;

    public DefaultMethod(java.lang.reflect.Method delegate) {
        this.delegate = delegate;
    }

    public String getName() {
        return delegate.getName();
    }

    public Object invoke(Object ref, Object... args) {
        try {
            delegate.setAccessible(true);
            return delegate.invoke(ref, args);
        } catch (Throwable t) {
            Throwable real = tosser.realCause(t);
            tosser.rethrow(real);
            return NEVER;
        }
    }

    public Class<?> getDeclaringClass() {
        return delegate.getDeclaringClass();
    }
}
