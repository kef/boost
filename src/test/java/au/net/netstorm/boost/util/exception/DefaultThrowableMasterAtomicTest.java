package au.net.netstorm.boost.util.exception;

import java.lang.reflect.UndeclaredThrowableException;
import au.net.netstorm.boost.test.cases.BoooostCase;

public final class DefaultThrowableMasterAtomicTest extends BoooostCase {
    private static final Throwable EXCEPTION_1 = new Exception();
    private static final Throwable EXCEPTION_2 = new ClassNotFoundException();
    private static final Throwable THROWABLE_1 = new Throwable();
    private static final Throwable THROWABLE_2 = new DirectThrowableException();
    private static final Throwable RUNTIME_1 = new RuntimeException();
    private static final Throwable RUNTIME_2 = new IllegalArgumentException();
    private static final Throwable ERROR_1 = new Error();
    private static final Throwable ERROR_2 = new InternalError();
    private ThrowableMaster subject = new DefaultThrowableMaster();

    public void testChecked() {
        isChecked(true, EXCEPTION_1);
        isChecked(true, EXCEPTION_2);
        isChecked(true, THROWABLE_1);
        isChecked(true, THROWABLE_2);
        isChecked(false, RUNTIME_1);
        isChecked(false, RUNTIME_2);
        isChecked(false, ERROR_1);
        isChecked(false, ERROR_2);
    }

    public void testRethrow() {
        checkThrowsWrapped(EXCEPTION_1);
        checkThrowsOriginal(RUNTIME_1);
        checkThrowsOriginal(ERROR_2);
    }

    private void isChecked(boolean expected, Throwable throwable) {
        boolean result = subject.isChecked(throwable);
        assertEquals(expected, result);
    }

    private void checkThrowsOriginal(Throwable t) {
        try {
            subject.rethrow(t);
            fail();
        } catch (Throwable caught) {
            assertSame(t, caught);
        }
    }

    private void checkThrowsWrapped(Throwable exception) {
        try {
            subject.rethrow(exception);
        } catch (UndeclaredThrowableException caught) {
            Throwable actual = caught.getUndeclaredThrowable();
            assertSame(exception, actual);
        }
    }
}
