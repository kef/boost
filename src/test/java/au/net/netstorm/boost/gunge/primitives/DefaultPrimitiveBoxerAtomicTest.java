package au.net.netstorm.boost.gunge.primitives;

import java.util.List;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DefaultPrimitiveBoxerAtomicTest extends LifecycleTestCase implements InjectableTest {
    PrimitiveBoxer subject;

    public void testConvertToBoxed() {
        Class<?> boxed = subject.convertToBoxed(int.class);
        checkIsBoxed(true, boxed);
        Class<?> unboxed = subject.convertToBoxed(List.class);
        checkIsBoxed(false, unboxed);
    }

    public void testGetBoxed() {
        Class<?> boxed = subject.getBoxed(int.class);
        checkIsBoxed(true, boxed);
    }

    public void testGetBoxedFailure() {
        checkGetBoxedFailure(Integer.class);
        checkGetBoxedFailure(List.class);
    }

    public void testIsBoxed() {
        checkIsBoxed(true, Integer.class);
        checkIsBoxed(true, Double.class);
        checkIsBoxed(true, Boolean.class);
        checkIsBoxed(false, int.class);
        checkIsBoxed(false, List.class);
    }

    public void testIsPrimitive() {
        checkIsPrimitive(true, int.class);
        checkIsPrimitive(true, short.class);
        checkIsPrimitive(true, char.class);
        checkIsPrimitive(true, float.class);
        checkIsPrimitive(false, Boolean.class);
        checkIsPrimitive(false, Double.class);
        checkIsPrimitive(false, List.class);
    }

    private void checkIsBoxed(boolean expected, Class<?> c) {
        boolean result = subject.isBoxed(c);
        assertEquals(expected, result);
    }

    private void checkIsPrimitive(boolean expected, Class<?> c) {
        boolean result = subject.isPrimitive(c);
        assertEquals(expected, result);
    }

    private void checkGetBoxedFailure(Class<?> c) {
        try {
            subject.getBoxed(c);
        } catch (IllegalArgumentException expected) {}
    }
}
