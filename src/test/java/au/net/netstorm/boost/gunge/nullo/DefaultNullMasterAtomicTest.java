package au.net.netstorm.boost.gunge.nullo;

import au.net.netstorm.boost.sniper.core.BoooostCase;

public final class DefaultNullMasterAtomicTest extends BoooostCase {
    private NullMaster nullMaster = new DefaultNullMaster();

    public void testNoNulls() {
        nullMaster.check(this);
    }

    public void testNullParamThrowsException() {
        try {
            nullMaster.check((Object) null);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    public void testRejectsANullParameterList() {
        checkRejectsNullArray(null);
        checkRejectsNullArray(new Object[]{null});
        checkRejectsNullArray(new Object[]{this, null});
        checkRejectsNullArray(new Object[]{this, this, null});
        checkRejectsNullArray(new Object[]{this, null, this});
    }

    public void testAcceptsParameterList() {
        Object[] parameters = new Object[]{this};
        nullMaster.check(parameters);
        Object[] parameters2 = new Object[]{this, this};
        nullMaster.check(parameters2);
        Object[] parameters1 = new Object[]{this, this, this};
        nullMaster.check(parameters1);
    }

    private void checkRejectsNullArray(Object[] parameters) {
        try {
            nullMaster.check(parameters);
            fail();
        } catch (IllegalArgumentException expected) {}
    }
}
