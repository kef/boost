package au.net.netstorm.boost.test.exception;

import au.net.netstorm.boost.spider.flavour.FlavourMapException;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;
import au.net.netstorm.boost.util.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.util.exception.ThrowableMaster;

public final class WebExceptionSupport implements ExceptionSupport {
    private static final ThrowableMaster THROWABLE_MASTER = new DefaultThrowableMaster();
    private static final int NOT_FOUND = -1;

    public RuntimeException translate(RuntimeException e) {
        String trace = THROWABLE_MASTER.getTrace(e);
        if (contains(trace, UnresolvedDependencyException.class)) return suggestWeb(e);
        if (contains(trace, FlavourMapException.class)) return suggestWeb(e);
        return e;
    }

    private boolean contains(String trace, Class cls) {
        String className = cls.getName();
        return trace.indexOf(className) != NOT_FOUND;
    }

    private RuntimeException suggestWeb(RuntimeException e) {
        return new RuntimeException("Looks like you need to put objects into a web!", e);
    }
}

