package au.net.netstorm.boost.gunge.array;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.sniper.core.BoooostCase;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.ModifierTestChecker;

public final class DefaultArrayFlattenerAtomicTest extends BoooostCase {
    private static final ClassTestChecker CLASS_CHECKER = new DefaultClassTestChecker();
    private static final ModifierTestChecker MODIFIER_CHECKER = new DefaultModifierTestChecker();
    private ArrayFlattener flattener = new DefaultArrayFlattener();

    public void testProperties() {
        CLASS_CHECKER.checkImplementsAndFinal(ArrayFlattener.class, DefaultArrayFlattener.class);
        CLASS_CHECKER.checkSubclassOf(DefaultArrayFlattener.class, Primordial.class);
        MODIFIER_CHECKER.checkFinal(DefaultArrayFlattener.class);
        MODIFIER_CHECKER.checkPublic(ArrayFlattener.class);
        MODIFIER_CHECKER.checkPublic(DefaultArrayFlattener.class);
    }

    public void testFlattenRejectsNulls() {
        checkFlatteningFailure(null);
        checkFlatteningFailure(new Object[] {null});
        checkFlatteningFailure(new Object[] {"a", null});
    }

    public void testFlattenNoOp() {
        checkFlattening(new Object[]{"1", "2"}, new Object[]{"1", "2"});
        checkFlattening(new String[]{"1", "2"}, new String[]{"1", "2"});
    }

    public void testNestedOneLevelFlatten() {
        Object[] unflattened = {"1", "2", new Object[]{"3", "4"}};
        Object[] expected = {"1", "2", "3", "4"};
        checkFlattening(expected, unflattened);
    }

    public void testNestedTwoLevelFlatten() {
        Object[] unflattened = {"1", "2", new Object[]{"3", "4", new Object[]{"5", "6"}}};
        Object[] expected = {"1", "2", "3", "4", "5", "6"};
        checkFlattening(expected, unflattened);
    }

    public void testNestedThreeLevelFlatten() {
        Object[] unflattened = {"1", "2", new Object[]{"3", "4", new Object[]{"5", "6", new Object[]{"7", "8"}}}};
        Object[] expected = {"1", "2", "3", "4", "5", "6", "7", "8"};
        checkFlattening(expected, unflattened);
    }

    public void testMixedTypeFlatten() {
        Object[] unflattened = {getClass(), this, new Number[]{new Long(1), new Integer(3)}, new Class[]{Object.class}};
        Object[] expected = {getClass(), this, new Long(1), new Integer(3), Object.class};
        checkFlattening(expected, unflattened);
    }

    private void checkFlattening(Object[] expectedFlattening, Object[] unflattened) {
        assertEquals(expectedFlattening, flattener.flatten(unflattened));
    }

    private void checkFlatteningFailure(Object[] unflattened) {
        try {
            flattener.flatten(unflattened);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
