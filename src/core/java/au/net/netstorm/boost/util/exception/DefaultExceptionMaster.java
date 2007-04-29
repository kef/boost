package au.net.netstorm.boost.util.exception;

// FIX 1936 Rename to ThrowableMaster.
public final class DefaultExceptionMaster implements ExceptionMaster {
    public boolean isChecked(Throwable t) {
        // FIX 1936 Complete.
        return false;
    }
}
