package au.net.netstorm.boost.gunge.exception;

public interface ThrowableMaster {
    void rethrow(Throwable t);

    boolean checked(Throwable t);

    String trace(Throwable t);

    Throwable rootCause(Throwable t);

    Throwable realCause(Throwable t);
}
