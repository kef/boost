package au.net.netstorm.boost.util.exception;

import java.lang.reflect.UndeclaredThrowableException;

public final class DefaultThrowableMaster implements ThrowableMaster {

    public void rethrow(Throwable t) {
        if (t instanceof Error)
            throw (Error) t;
        if (t instanceof RuntimeException)
            throw (RuntimeException) t;
        throw new UndeclaredThrowableException(t);
    }

    public boolean isChecked(Throwable t) {
        if (t instanceof RuntimeException) return false;
        if (t instanceof Error) return false;
        return true;
    }
}
