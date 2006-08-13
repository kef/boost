package au.net.netstorm.boost.test.reflect.checker;

public interface AssertException {
    Throwable assertWraps(Throwable wrapperException, Class expectedException);

    Throwable assertWraps(Throwable wrapperException, Class expectedException, String expectedMessage);

    Throwable assertWraps(Throwable wrapperException, Class expectedExceptionClass, int depthExceptionShouldAppearAt);

    Throwable assertWraps(Throwable wrapperException, String expectedMessage, Class expectedExceptionClass, int depthExceptionShouldAppearAt);

    void checkExceptionClass(Class expectedExceptionClass, Throwable throwable);

    void checkExceptionMessage(String expectedMessage, Throwable throwable);
}
