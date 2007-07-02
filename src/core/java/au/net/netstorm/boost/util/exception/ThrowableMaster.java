package au.net.netstorm.boost.util.exception;

public interface ThrowableMaster {
    boolean isChecked(Throwable t);

    void rethrow(Throwable t);
}
