package au.net.netstorm.boost.gunge.type;

import java.lang.reflect.Type;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.sniper.core.BoooostCase;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;

public class DefaultInterfaceAtomicTest extends BoooostCase {
    private static final Class NOT_AN_INTERFACE = Object.class;
    private final ClassTestChecker classer = new DefaultClassTestChecker();
    private final Interface line = new DefaultInterface(Line.class);
    private final Interface jester = new DefaultInterface(Jester.class);
    private final Interface soldier = new DefaultInterface(Soldier.class);
    private final Interface clown = new DefaultInterface(Clown.class);
    private final Interface mumbles = new DefaultInterface(Mumbles.class);

    private final TypeMaster typeMaster = new DefaultTypeMaster();

    public void testIsA() {
        checkIsA(true, clown);
        checkIsA(false, soldier);
    }

    public void testType() {
        checkType(jester, Jester.class);
        checkType(mumbles, Mumbles.class);
    }

    public void testReifiedType() {
        checkReifiedType(line, Line.class);
    }

    public void testFastHashCode() {
        checkFastHashCode(jester);
        checkFastHashCode(soldier);
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

    private void checkType(Interface iface, Class expected) {
        Class actual = iface.getType();
        assertEquals(expected, actual);
    }

    private void checkReifiedType(Interface iface, Type expected) {
        Type actual = iface.getReifiedType();
        assertEquals(expected, actual);
    }

    private void checkFastHashCode(Interface type) {
        Class cls = type.getType();
        int actual = type.hashCode();
        int expected = cls.hashCode();
        assertEquals(expected, actual);
    }

    private void checkIsA(boolean expected, Interface iface) {
        boolean result = typeMaster.extendz(jester, iface);
        assertEquals(expected, result);
    }
}
