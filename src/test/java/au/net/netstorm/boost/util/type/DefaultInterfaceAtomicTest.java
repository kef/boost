package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public class DefaultInterfaceAtomicTest extends BoooostCase {
    private static final Class NOT_AN_INTERFACE = Object.class;
    private final ClassTestChecker classer = new DefaultClassTestChecker();
    private final Interface soldier = new DefaultInterface(Soldier.class);
    private final Interface clown = new DefaultInterface(Clown.class);

    // FIX 1715 Override assertTrue/assertFalse to barf in BoooostCase.
    // FIX 1715 Complete this guy.
    public void testIsA() {
        Interface jester = new DefaultInterface(Jester.class);
        assertEquals(true, jester.is(clown));
    }

    public void testTypeIsNotInterface() {
        try {
            new DefaultInterface(NOT_AN_INTERFACE);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testNullIllegal() {
        try {
            new DefaultInterface(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testPrimordial() {
        classer.checkSubclassOf(DefaultInterface.class, Primordial.class);
    }
}
