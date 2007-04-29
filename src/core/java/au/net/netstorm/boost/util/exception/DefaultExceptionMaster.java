package au.net.netstorm.boost.util.exception;

// FIX 1936 Rename to ThrowableMaster.
public final class DefaultExceptionMaster implements ExceptionMaster {
    public boolean isChecked(Throwable t) {
        if (t instanceof RuntimeException) return false;
        return true;
    }
}
