package au.net.netstorm.boost.util.exception;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultThrowableMasterAtomicTest extends BoooostCase {
    private static final Throwable RUNTIME_1 = new RuntimeException();
    // FIX 1936 Incorporate #2.
    private static final Throwable RUNTIME_2 = new IllegalArgumentException();
    private static final Throwable EXCEPTION_1 = new Exception();
    private ThrowableMaster subject = new DefaultThrowableMaster();

    // FIX 1936 Complete this.
    // FIX 1936 Check Error.
    // FIX 1936 Check Exception.
    // FIX 1936 Check subclass of Exception.
    // FIX 1936 Check Throwable.
    // FIX 1936 Check Runtime.
    // FIX 1936 Check subclass of Runtime.
    public void testChecked() {
        isChecked(true, EXCEPTION_1);
        isChecked(false, RUNTIME_1);
        isChecked(false, RUNTIME_2);
    }

    private void isChecked(boolean expected, Throwable throwable) {
        boolean result = subject.isChecked(throwable);
        assertEquals(expected, result);
    }
}
