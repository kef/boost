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

    public boolean isChecked(Throwable t) {
        if (t instanceof RuntimeException) return false;
        if (t instanceof Error) return false;
        return true;
    }

    // SUGGEST: Does this really belong.
    public String getTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();
    }
}
