package au.net.netstorm.boost.test.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import au.net.netstorm.boost.spider.flavour.FlavourMapException;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;

public final class WebExceptionSupport implements ExceptionSupport {

    public RuntimeException translate(RuntimeException e) {
        String trace = getTrace(e);
        if (contains(trace, UnresolvedDependencyException.class)) return suggestWeb(e);
        if (contains(trace, FlavourMapException.class)) return suggestWeb(e);
        return e;
    }

    private boolean contains(String trace, Class cls) {
        return trace.contains(cls.getName());
    }

    private RuntimeException suggestWeb(RuntimeException e) {
        return new RuntimeException("Looks like you need to put objects into a web!", e);
    }

    private String getTrace(RuntimeException e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
        return stringWriter.toString();
    }
}

