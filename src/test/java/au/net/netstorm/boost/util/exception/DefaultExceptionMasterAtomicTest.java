package au.net.netstorm.boost.util.exception;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultExceptionMasterAtomicTest extends BoooostCase {
    private static final RuntimeException RUNTIME_1 = new RuntimeException();
    private ExceptionMaster subject = new DefaultExceptionMaster();

    // FIX 1936 Complete this.
    // FIX 1936 Check Error.
    // FIX 1936 Check Exception.
    // FIX 1936 Check subclass of Exception.
    // FIX 1936 Check Throwable.
    // FIX 1936 Check Runtime.
    // FIX 1936 Check subclass of Runtime.
    public void testChecked() {
        isChecked(false, RUNTIME_1);
    }

    private void isChecked(boolean expected, Throwable throwable) {
        boolean result = subject.isChecked(throwable);
        assertEquals(expected, result);
    }
}
