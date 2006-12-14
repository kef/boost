package au.net.netstorm.boost.nursery.reflect.checker;

public interface AssertException {
    Throwable assertWraps(Class expectedException, Throwable wrapperException);

    Throwable assertWraps(Class expectedException, String expectedMessage, Throwable wrapperException);

    Throwable assertWraps(Class expectedExceptionClass, Throwable wrapperException, int depthExceptionShouldAppearAt);

    Throwable assertWraps(Class expectedExceptionClass, String expectedMessage, Throwable wrapperException, int depthExceptionShouldAppearAt);

    void checkExceptionClass(Class expectedExceptionClass, Throwable actual);

    void checkExceptionMessage(String expectedMessage, Throwable actual);
}
