package au.net.netstorm.boost.util.array;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.checker.ClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.test.checker.ModifierTestChecker;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;

// FIXME: SC523 How does this handle types other than Object[]? Does it recurse?
public final class DefaultArrayFlattenerAtomicTest extends PrimordialTestCase {
    private static final ClassTestChecker CLASS_CHECKER = new DefaultClassTestChecker();
    private static final ModifierTestChecker MODIFIER_CHECKER = new DefaultModifierTestChecker();
    private ArrayFlattener flattener;

    public void testProperties() {
        CLASS_CHECKER.checkImplementsAndFinal(ArrayFlattener.class, DefaultArrayFlattener.class);
        CLASS_CHECKER.checkSubclassOf(Primordial.class, DefaultArrayFlattener.class);
        MODIFIER_CHECKER.checkFinal(DefaultArrayFlattener.class);
        MODIFIER_CHECKER.checkPublic(ArrayFlattener.class);
        MODIFIER_CHECKER.checkPublic(DefaultArrayFlattener.class);
    }

    public void testFlattenRejectsNulls() {
        try {
            flattener.flatten(null);
            fail();
        } catch (IllegalArgumentException expected) {
            assertEquals("unflattened parameter should not be null", expected.getMessage());
        }
    }

    public void testFlattenNoOp() {
        Object[] unflattened = new Object[]{"1", "2"};
        Object[] expected = new Object[]{"1", "2"};
        checkFlattening(expected, unflattened);
    }

    public void testNestedOneLevelFlatten() {
        Object[] unflattened = new Object[]{"1", "2", new Object[]{"3", "4"}};
        Object[] expected = new Object[]{"1", "2", "3", "4"};
        checkFlattening(expected, unflattened);
    }

    public void testNestedTwoLevelFlatten() {
        Object[] unflattened = new Object[]{"1", "2", new Object[]{"3", "4", new Object[]{"5", "6"}}};
        Object[] expected = new Object[]{"1", "2", "3", "4", "5", "6"};
        checkFlattening(expected, unflattened);
    }

    public void testNestedThreeLevelFlatten() {
        Object[] unflattened = new Object[]{"1", "2", new Object[]{"3", "4", new Object[]{"5", "6", new Object[]{"7", "8"}}}};
        Object[] expected = new Object[]{"1", "2", "3", "4", "5", "6", "7", "8"};
        checkFlattening(expected, unflattened);
    }

    private void checkFlattening(Object[] expectedFlattening, Object[] unflattened) {
        assertEquals(expectedFlattening, flattener.flatten(unflattened));
    }

    protected void setUp() throws Exception {
        flattener = new DefaultArrayFlattener();
    }
}
