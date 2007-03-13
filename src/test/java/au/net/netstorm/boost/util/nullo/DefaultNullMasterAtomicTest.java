package au.net.netstorm.boost.util.nullo;

import au.net.netstorm.boost.test.automock.BoooostTestCase;

public final class DefaultNullMasterAtomicTest extends BoooostTestCase {
    private NullMaster nullMaster = new DefaultNullMaster();

    public void testNullMessageIsOk() {
        nullMaster.check(this, null);
    }

    public void testNoNulls() {
        nullMaster.check(this);
    }

    public void testNullParamThrowsException() {
        checkNullParamThrowsException();
        checkNullParamThrowsException();
    }

    public void testNullParamThrowsExceptionWithMessage() {
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

    public void testRejectsNestedObjectArrays() {
        Object[] parameters = new Object[]{this, new Object[]{null}};
        checkRejectsNulls(parameters, "2");
    }

    // SUGGEST Remove this duplication.
    private void checkRejectsNulls(Object[] parameters, String badParamNumber) {
        try {
            checkNoNulls(parameters);
            fail();
        } catch (IllegalArgumentException expected) {
            assertEquals("Parameter " + badParamNumber + " should not be null", expected.getMessage());
        }
    }

    // SUGGEST Remove this duplication.
    private void checkNullParamThrowsException() {
        try {
            nullMaster.check((Object) null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }
    }

    // SUGGEST Remove this duplication.
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
