package au.net.netstorm.boost.util.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultThrowableMasterAtomicTest extends LifecycleTestCase implements LazyFields {
    private static final Throwable EXCEPTION_1 = new Exception();
    private static final Throwable EXCEPTION_2 = new ClassNotFoundException();
    private static final Throwable THROWABLE_1 = new Throwable();
    private static final Throwable THROWABLE_2 = new DirectThrowableException();
    private static final Throwable RUNTIME_1 = new RuntimeException();
    private static final Throwable RUNTIME_2 = new IllegalArgumentException();
    private static final Throwable ERROR_1 = new Error();
    private static final Throwable ERROR_2 = new InternalError();
    ThrowableMaster subject = new DefaultThrowableMaster();
    String expectedTrace;
    private static final String DEFAULT_MESSAGE = "Default message";

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

    public void testTrace() {
        TestThrowable throwable = new TestThrowable(expectedTrace);
        String actualTrace = subject.trace(throwable);
        assertEquals(expectedTrace, actualTrace);
    }

    public void testRootCause() {
        Throwable ise = new IllegalStateException();
        Throwable ute = new UndeclaredThrowableException(ise);
        Throwable ite = new InvocationTargetException(ute);
        checkReal(ise, ise);
        checkReal(ise, ute);
        checkReal(ise, ite);
    }

    public void testBestMessage() {
        checkBestMessage(DEFAULT_MESSAGE, null, null);
        checkBestMessage("Root message", null, "Root message");
        checkBestMessage("Top message", "Top message", "Root message");
        checkBestMessage("Top message", "Top message", null);
    }

    public void testRealCause() {
        Throwable expected = new Exception();
        Throwable ite = makeInvocationTarget(expected);
        Throwable actual = subject.realCause(ite);
        assertEquals(expected, actual);
        actual = subject.realCause(expected);
        assertEquals(expected, actual);
    }

    private void checkBestMessage(String expected, String topMessage, String rootMessage) {
        Throwable e1 = new Exception(rootMessage, null);
        Throwable ite = makeInvocationTarget(e1);
        Throwable e2 = new Exception(topMessage, ite);
        String best = subject.realMessage(DEFAULT_MESSAGE, e2);
        assertEquals(expected, best);
    }

    private Throwable makeInvocationTarget(Throwable expected) {
        Throwable ute = new UndeclaredThrowableException(expected);
        InvocationTargetException ite = new InvocationTargetException(ute);
        return new EdgeException(ite);
    }

    private void checkReal(Throwable expected, Throwable actual) {
        Throwable cause = subject.rootCause(actual);
        assertEquals(expected, cause);
    }

    private void isChecked(boolean expected, Throwable throwable) {
        boolean result = subject.checked(throwable);
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
