package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.InvocationTargetException;

// FIXME: SC050 What a pile of smelly rot.

public final class DefaultExceptionTestUtil implements ExceptionTestUtil {
    public Class getRealExceptionClass(Throwable t) {
        // FIXME: SC050 This certainly does not really work.  Sort this out!!!
        Throwable realException = t;
        if (realException.getClass() == RuntimeException.class) realException = (Throwable) realException.getCause();
        if (realException.getClass() == InvocationTargetException.class)
            realException = (Throwable) realException.getCause(); // FIXME: SC050 Bloody amateurs.  This should be getTargetInvocation ...
        return realException.getClass();
    }
}
