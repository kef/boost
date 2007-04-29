package au.net.netstorm.boost.util.exception;

public final class DefaultThrowableMaster implements ThrowableMaster {
    public boolean isChecked(Throwable t) {
        if (t instanceof RuntimeException) return false;
        if (t instanceof Error) return false;
        return true;
    }
}
