package au.net.netstorm.boost.nursery.pebble;

import java.util.Set;
import junit.framework.TestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class NonMatchingCreatorExceptionAtomicTest extends TestCase {
    private static final Class CREATOR_CLASS = Set.class;
    private static final Interface CREATOR_INTERFACE = new DefaultInterface(CREATOR_CLASS);
    private static final Class IMPL_CLASS = String.class;
    private static final String IMPL_CLASS_NAME = IMPL_CLASS.getName();
    private static final String CREATOR_CLASS_NAME = CREATOR_CLASS.getName();

    public void testException() {
        Exception exception = new NonMatchingCreatorException(CREATOR_INTERFACE, IMPL_CLASS);
        String msg = exception.getMessage();
        // OK LineLength {
        assertEquals("Creator "+ CREATOR_CLASS_NAME + " does not have single _(...) method which matches "+ IMPL_CLASS_NAME +" single constructor.", msg);
        // } OK
    }
}
