package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public class DefaultInterfaceAtomicTest extends BoooostCase {
    private static final Class NOT_AN_INTERFACE = Object.class;
    private final ClassTestChecker classer = new DefaultClassTestChecker();

    // FIX 1715 Test is().

    public void testPrimordial() {
        classer.checkSubclassOf(DefaultInterface.class, Primordial.class);
    }

    // FIX 1715 Complete.
    public void testXxx() {
    }

    public void testTypeIsNotInterface() {
        try {
            new DefaultInterface(NOT_AN_INTERFACE);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
