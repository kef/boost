package au.net.netstorm.boost.gunge.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultThrowableMaster implements ThrowableMaster {
    // Never, ever change the return type or I will kill you.
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

    // FIX 2328 Work out whether difference between rootCause/realCause is justified.
    // FIX 2328 This definitely does not belong here.
    // SUGGEST: Does this really belong?
    public String trace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();
    }

    public Throwable rootCause(Throwable t) {
        Throwable cause = t.getCause();
        if (cause == null) return t;
        return rootCause(cause);
    }

    // FIX 2328 Remove this.  Find where it is hanging on.
    public String realMessage(String defaultMsg, Throwable t) {
        Throwable real = realCause(t);
        String currentMsg = real.getMessage();
        Throwable cause = real.getCause();
        String bestMsg = (currentMsg == null ? defaultMsg : currentMsg);
        if (cause == null) return bestMsg;
        if (currentMsg == null) return realMessage(bestMsg, cause);
        return bestMsg;
    }

    public Throwable realCause(Throwable t) {
        if (!noise(t)) return t;
        Throwable cause = t.getCause();
        return realCause(cause);
    }

    private boolean noise(Throwable t) {
        return t instanceof UndeclaredThrowableException ||
                t instanceof InvocationTargetException ||
                t instanceof EdgeException;
    }
}