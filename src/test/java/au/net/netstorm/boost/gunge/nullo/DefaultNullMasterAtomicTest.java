package au.net.netstorm.boost.gunge.nullo;

import au.net.netstorm.boost.sniper.core.BoooostCase;

public final class DefaultNullMasterAtomicTest extends BoooostCase {
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
        checkRejectsNulls(null, "Parameters cannot be null");
        checkRejectsNulls(new Object[]{null}, msg("1"));
        checkRejectsNulls(new Object[]{this, null}, msg("2"));
        checkRejectsNulls(new Object[]{this, this, null}, msg("3"));
    }

    public void testAcceptsParameterList() {
        Object[] parameters = new Object[]{this};
        checkNoNulls(parameters);
        checkNoNulls(new Object[]{this, this});
        checkNoNulls(new Object[]{this, this, this});
    }

    public void testRejectsNestedObjectArrays() {
        Object[] parameters = new Object[]{this, new Object[]{null}};
        checkRejectsNulls(parameters, msg("2"));
    }

    // SUGGEST Remove this duplication.
    private void checkRejectsNulls(Object[] parameters, String msg) {
        try {
            checkNoNulls(parameters);
            fail();
        } catch (IllegalArgumentException expected) {
            assertEquals(msg, expected.getMessage());
        }
    }

    private String msg(String number) {
        return "Parameter " + number + " cannot be null";
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
            assertEquals(parameter + " parameter cannot be null", message);
        }
    }

    private void checkNoNulls(Object[] parameters) {
        nullMaster.check(parameters);
    }
}
