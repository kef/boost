package au.net.netstorm.boost.util.nullo;

import au.net.netstorm.boost.test.checker.AssertThrows;
import au.net.netstorm.boost.test.checker.Block;
import au.net.netstorm.boost.test.checker.DefaultAssertThrows;
import au.net.netstorm.boost.test.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;

public class NullMasterAtomicTest extends PrimordialTestCase {
    // TODO: Move these into PrimordialTestCase?
    private static final DefaultClassTestChecker CLASS_CHECKER = new DefaultClassTestChecker();
    private static final DefaultModifierTestChecker MODIFIER_CHECKER = new DefaultModifierTestChecker();
    private static final AssertThrows THROWS = new DefaultAssertThrows();
    private NullMaster nullMaster = new DefaultNullMaster();

    public void testClassProperties() {
        CLASS_CHECKER.checkImplementsAndFinal(NullMaster.class,  DefaultNullMaster.class);
        MODIFIER_CHECKER.checkPublic(DefaultNullMaster.class);
        MODIFIER_CHECKER.checkPublic(NullMaster.class);
    }

    public void testNoExceptionWhenNullMessageIsPassed() {
        nullMaster.check(this, null);
    }

    // FIXME: SC523 Replace with normal test method.
    public void testNull() {
        checkFailNull("someParam");
        checkFailNull("someOtherParam");
    }

    private void checkFailNull(final String parameter) {
        final String expectedMessage = " parameter should not be null";
        THROWS.assertThrows(IllegalArgumentException.class, parameter + expectedMessage, new Block() {
            public void execute() throws Throwable {
                nullMaster.check(null, parameter);
            }
        });
    }
}
