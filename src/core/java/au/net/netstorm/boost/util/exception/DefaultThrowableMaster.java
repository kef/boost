package au.net.netstorm.boost.util.exception;

public final class DefaultThrowableMaster implements ThrowableMaster {

/*
    public void rethrow(Throwable t) {
        if (t instanceof RuntimeException) throw (RuntimeException) t;
        if (t instanceof Error) throw (Error) t;
        throw new UndeclaredThrowableException(t);
    }
*/

    public boolean isChecked(Throwable t) {
        if (t instanceof RuntimeException) return false;
        if (t instanceof Error) return false;
        return true;
    }
}
