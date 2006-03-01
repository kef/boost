package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.InvocationTargetException;

public final class DefaultExceptionTestUtil implements ExceptionTestUtil {
    public Class getRealExceptionClass(Throwable t) {
        // FIXME: SC050 This certainly does not really work.  Sort this out!!!
        // FIXME: SC042 Early returns fellas.
        Throwable realException = t;
        if (realException.getClass() == RuntimeException.class) realException = (Throwable) realException.getCause();
        if (realException.getClass() == InvocationTargetException.class)
            realException = (Throwable) realException.getCause();
        return realException.getClass();
    }
}
