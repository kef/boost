package au.net.netstorm.boost.util.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.UndeclaredThrowableException;

public final class DefaultThrowableMaster implements ThrowableMaster {

    public void rethrow(Throwable t) {
        if (t instanceof Error)
            throw (Error) t;
        if (t instanceof RuntimeException)
            throw (RuntimeException) t;
        throw new UndeclaredThrowableException(t);
    }

    public boolean checked(Throwable t) {
        if (t instanceof RuntimeException) return false;
        if (t instanceof Error) return false;
        return true;
    }

    // SUGGEST: Does this really belong.
    public String trace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();
    }

    public Throwable real(Throwable t) {
        Throwable cause = t.getCause();
        if (cause == null) return t;
        return real(cause);
    }

    public String bestMessage(String defMessage, Throwable t) {
        String newMessage = tryCurrentMessage(defMessage, t);
        Throwable cause = t.getCause();
        if (cause == null) return newMessage;
        return bestMessage(newMessage, cause);
    }

    private String tryCurrentMessage(String oldMessage, Throwable t) {
        String message = t.getMessage();
        if (message != null) return message;
        return oldMessage;
    }
}