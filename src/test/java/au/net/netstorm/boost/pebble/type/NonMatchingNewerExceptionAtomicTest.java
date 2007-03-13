package au.net.netstorm.boost.pebble.type;

import java.util.Set;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class NonMatchingNewerExceptionAtomicTest extends TestCase {
    private static final Class NEWER_CLASS = Set.class;
    private static final Interface NEWER_INTERFACE = new DefaultInterface(NEWER_CLASS);
    private static final Class IMPL_CLASS = String.class;
    private static final String IMPL_CLASS_NAME = IMPL_CLASS.getName();
    private static final String NEWER_CLASS_NAME = NEWER_CLASS.getName();

    public void testException() {
        Exception exception = new NonMatchingNewerException(NEWER_INTERFACE, IMPL_CLASS);
        String msg = exception.getMessage();
        assertEquals("Newer " + NEWER_CLASS_NAME +
                " does not have single nu(...) method which matches " + IMPL_CLASS_NAME +
                " single constructor.", msg);
    }
}
