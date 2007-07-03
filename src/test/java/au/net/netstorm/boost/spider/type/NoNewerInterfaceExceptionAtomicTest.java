package au.net.netstorm.boost.spider.type;

import au.net.netstorm.boost.test.core.BoooostCase;

public final class NoNewerInterfaceExceptionAtomicTest extends BoooostCase {
    private static final Class CLASS = Yabby.class;
    private static final String EXCEPTION_MESSAGE =
            "No newer interface yabadabadoo found for class " + CLASS.getName();

    public void testException() {
        Exception exception = new NoNewerInterfaceException("yabadabadoo", CLASS);
        String message = exception.getMessage();
        assertEquals(EXCEPTION_MESSAGE, message);
    }
}
