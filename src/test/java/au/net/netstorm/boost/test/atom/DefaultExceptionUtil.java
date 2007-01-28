package au.net.netstorm.boost.test.atom;

import java.lang.reflect.InvocationTargetException;
import au.net.netstorm.boost.edge.EdgeException;

final class DefaultExceptionUtil implements ExceptionUtil {
    public boolean threw(Throwable throwable, Class contains) {
        if (throwable instanceof EdgeException) {
            return deEdgify((EdgeException) throwable, contains);
        }
        if (throwable instanceof InvocationTargetException) {
            return deTarget((InvocationTargetException) throwable, contains);
        }
        return (same(throwable, contains));
    }

    private boolean deEdgify(EdgeException edgeException, Class contains) {
        Throwable cause = edgeException.getCause();
        return threw(cause, contains);
    }

    private boolean deTarget(InvocationTargetException targetException, Class contains) {
        Throwable cause = targetException.getTargetException();
        return threw(cause, contains);
    }

    private boolean same(Throwable throwable, Class contains) {
        Class throwableClass = throwable.getClass();
        return throwableClass.equals(contains);
    }
}
