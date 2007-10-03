package au.net.netstorm.boost.util.exception;

public interface ThrowableMaster {
    void rethrow(Throwable t);

    boolean checked(Throwable t);

    String trace(Throwable t);

    Throwable real(Throwable t);

    String bestMessage(String message, Throwable t);
}
