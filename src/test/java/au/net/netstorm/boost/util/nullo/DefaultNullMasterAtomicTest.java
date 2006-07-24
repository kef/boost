package au.net.netstorm.boost.util.nullo;

import au.net.netstorm.boost.test.checker.ClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultModifierTestChecker;
import au.net.netstorm.boost.test.checker.ModifierTestChecker;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;

public final class DefaultNullMasterAtomicTest extends PrimordialTestCase {
    // TODO: Move these into PrimordialTestCase?
    private final ClassTestChecker classChecker = new DefaultClassTestChecker();
    private final ModifierTestChecker modifierChecker = new DefaultModifierTestChecker();
    private NullMaster nullMaster = new DefaultNullMaster();

    // FIXME: SC523 Do we need to do this. Or is it maybe just part of test driving up (ie. remove when done).
    public void testClassProperties() {
        classChecker.checkImplementsAndFinal(NullMaster.class, DefaultNullMaster.class);
        modifierChecker.checkPublic(DefaultNullMaster.class);
        modifierChecker.checkPublic(NullMaster.class);
    }

    public void testNullMessageIsOk() {
        nullMaster.check(this, null);
    }

    // FIXME: SC523 Replace with normal test method. (TJA: Why? Not sure what this means...)
    public void testNullParamThrowsException() {
        checkNullParamThrowsException("someParamName");
        checkNullParamThrowsException("someOtherParamName");
    }

    public void testRejectsANullParameterList() {
        checkRejectsNulls(null, "1");
        checkRejectsNulls(new Object[]{null}, "1");
        checkRejectsNulls(new Object[]{this, null}, "2");
        checkRejectsNulls(new Object[]{this, this, null}, "3");
    }

    public void testAcceptsParameterList() {
        Object[] parameters = new Object[]{this};
        checkNoNulls(parameters);
        checkNoNulls(new Object[]{this, this});
        checkNoNulls(new Object[]{this, this, this});
    }

    // FIXME: SC523 Gee I wish I had a way to remove this duplication... ;)
    private void checkRejectsNulls(Object[] parameters, String badParamNumber) {
        try {
            checkNoNulls(parameters);
            fail();
        } catch (IllegalArgumentException expected) {
            assertEquals("Parameter " + badParamNumber + " should not be null", expected.getMessage());
        }
    }

    private void checkNullParamThrowsException(String parameter) {
        try {
            nullMaster.check(null, parameter);
            fail();
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            assertEquals(parameter + " parameter should not be null", message);
        }
    }

    private void checkNoNulls(Object[] parameters) {
        nullMaster.check(parameters);
    }
}
