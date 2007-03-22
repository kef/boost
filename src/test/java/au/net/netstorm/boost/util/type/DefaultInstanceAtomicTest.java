package au.net.netstorm.boost.util.type;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultInstanceAtomicTest extends BoooostCase {
    private static final Map MAP = new HashMap();
    private static final Soldier SOLDIER = new BooostSoldier();

    // FIX BREADCRUMB 1824 Come back here to finish testing!!!!
    public void testGet() {
        checkGet(MAP);
        checkGet(SOLDIER);
    }

    public void testNullIllegal() {
        try {
            new DefaultInstance(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void checkGet(Object ref) {
        Instance instance = new DefaultInstance(ref);
        Object actual = instance.getRef();
        assertEquals(ref, actual);
    }

//
//    public void testIsA() {
//        checkIsA(true, clown);
//        checkIsA(false, soldier);
//    }
//
//    public void testType() {
//        Class actual = jester.getType();
//        assertEquals(Jester.class, actual);
//    }
//
//    public void testTypeIsNotInterface() {
//        try {
//            new DefaultInterface(NOT_AN_INTERFACE);
//            fail();
//        } catch (IllegalArgumentException expected) { }
//    }
//
//    public void testNullIllegal() {
//        try {
//            new DefaultInterface(null);
//            fail();
//        } catch (IllegalArgumentException expected) { }
//    }
//
//    public void testPrimordial() {
//        classer.checkSubclassOf(DefaultInterface.class, Primordial.class);
//    }
//
//    private void checkIsA(boolean expected, Interface iface) {
//        boolean result = jester.is(iface);
//        assertEquals(expected, result);
//    }
}