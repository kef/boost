package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public class DefaultInterfaceAtomicTest extends BoooostCase {
    private static final Class NOT_AN_INTERFACE = Object.class;
    private final ClassTestChecker classer = new DefaultClassTestChecker();
    private final Interface jester = new DefaultInterface(Jester.class);
    private final Interface soldier = new DefaultInterface(Soldier.class);
    private final Interface clown = new DefaultInterface(Clown.class);

    public void testIsA() {
        checkIsA(true, clown);
        checkIsA(false, soldier);
    }

    public void testType() {
        Class actual = jester.getType();
        assertEquals(Jester.class, actual);
    }

/*  Steve you were right, love greg.
    public void testFastHashCode() {
        int actual = jester.hashCode();
        int expected = Jester.class.hashCode();
        assertEquals(expected, actual);
    }
*/

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

    private void checkIsA(boolean expected, Interface iface) {
        boolean result = jester.is(iface);
        assertEquals(expected, result);
    }
}
