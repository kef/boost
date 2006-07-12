package au.net.netstorm.boost.util.nullo;

import au.net.netstorm.boost.test.checker.ClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.test.checker.ModifierTestChecker;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;

public class NullMasterAtomicTest extends PrimordialTestCase {
    // TODO: Move these into PrimordialTestCase?
    private final ClassTestChecker classChecker = new DefaultClassTestChecker();
    private final ModifierTestChecker modifierChecker = new DefaultModifierTestChecker();
    private NullMaster nullMaster = new DefaultNullMaster();

    public void testClassProperties() {
        classChecker.checkImplementsAndFinal(NullMaster.class,  DefaultNullMaster.class);
        modifierChecker.checkPublic(DefaultNullMaster.class);
        modifierChecker.checkPublic(NullMaster.class);
    }

    public void testNullMessageOk() {
        nullMaster.check(this, null);
    }

    // FIXME: SC523 Replace with normal test method.
    public void testNull() {
        checkFailNull("someParam");
        checkFailNull("someOtherParam");
    }

    private void checkFailNull(String parameter) {
        try {
            nullMaster.check(null, parameter);
            fail();
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            assertEquals(parameter + " parameter should not be null", message);
        }
    }
}
