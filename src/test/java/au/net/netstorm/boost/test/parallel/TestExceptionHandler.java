package au.net.netstorm.boost.test.parallel;

import java.util.List;

public interface TestExceptionHandler {
    void checkExceptions(List exceptions) throws Throwable;
}
