package au.net.netstorm.boost.test.exception;

import au.net.netstorm.boost.spider.flavour.FlavourMapException;
import au.net.netstorm.boost.spider.registry.UnresolvedDependencyException;
import au.net.netstorm.boost.util.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.util.exception.ThrowableMaster;

public final class WebThrowableSupport implements ThrowableSupport {
    private static final ThrowableMaster THROWABLE_MASTER = new DefaultThrowableMaster();
    private static final int NOT_FOUND = -1;

    public Throwable translate(Throwable t) {
        String trace = THROWABLE_MASTER.trace(t);
        if (contains(trace, UnresolvedDependencyException.class)) return suggestWeb(t);
        if (contains(trace, FlavourMapException.class)) return suggestWeb(t);
        return t;
    }

    private boolean contains(String trace, Class cls) {
        String className = cls.getName();
        return trace.indexOf(className) != NOT_FOUND;
    }

    private Throwable suggestWeb(Throwable t) {
        // FIX DEBT Come on ... some custom exception would be tres bon.
        return new Throwable("Looks like you need to put objects into a web!", t);
    }
}

