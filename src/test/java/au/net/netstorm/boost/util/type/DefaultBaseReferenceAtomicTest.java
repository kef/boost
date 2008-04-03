package au.net.netstorm.boost.util.type;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.gunge.core.BoooostCase;
import au.net.netstorm.boost.gunge.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.gunge.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultBaseReferenceAtomicTest extends BoooostCase {
    private static final Map MAP = new HashMap();
    private static final Soldier SOLDIER = new BooostSoldier();
    private final ClassTestChecker classer = new DefaultClassTestChecker();

    public void testGet() {
        checkGet(MAP);
        checkGet(SOLDIER);
    }

    public void testNullIllegal() {
        try {
            new DefaultBaseReference(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void checkGet(Object ref) {
        Reference instance = new DefaultBaseReference(ref);
        Object actual = instance.getRef();
        assertEquals(ref, actual);
    }

    public void testPrimordial() {
        classer.checkSubclassOf(DefaultBaseReference.class, Primordial.class);
    }
}