package au.net.netstorm.boost.util.exception;

public interface ThrowableMaster {
    void rethrow(Throwable t);

    boolean isChecked(Throwable t);

    String getTrace(Throwable t);

    Throwable root(Throwable t);
}
