package au.net.netstorm.boost.test.parallel;

import java.util.List;

public class DefaultTestExceptionHandler implements TestExceptionHandler {

    public void checkExceptions() throws Throwable {
        List exceptions = DefaultRunnableTest.exceptions;
        if (hasExceptions(exceptions)) rethrow(exceptions);
    }

    private boolean hasExceptions(List exceptions) {
        return exceptions.size() > 0;
    }

    private void rethrow(List exceptions) throws Throwable {
        // SUGGEST: log out all exceptions
        Throwable exception = (Throwable) exceptions.get(0);
        exceptions.clear();
        throw new Throwable(exception);
    }
}