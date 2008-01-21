package au.net.netstorm.boost.util.exception;

public interface ThrowableMaster {
    void rethrow(Throwable t);

    boolean checked(Throwable t);

    String trace(Throwable t);

    Throwable rootCause(Throwable t);

    String realMessage(String defaultMsg, Throwable t);

    Throwable realCause(Throwable t);
}
