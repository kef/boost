package au.net.netstorm.boost.test.checker;

public interface AssertException {
    Throwable assertWraps(Throwable wrapperException, Class expectedException);

    Throwable assertWraps(Throwable wrapperException, Class expectedException, String message);

    Throwable assertWraps(Throwable wrapperException, Class exceptionClass, int depthExceptionShouldAppearAt);

    Throwable assertWraps(Throwable wrapperException, String message, Class exceptionClass, int depthExceptionShouldAppearAt);

    void checkExceptionClass(Class exceptionClass, Throwable throwable);

    void checkExceptionMessage(String expectedMessage, Throwable throwable);
}
