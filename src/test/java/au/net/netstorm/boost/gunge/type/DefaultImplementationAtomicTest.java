package au.net.netstorm.boost.gunge.type;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultImplementationAtomicTest extends LifecycleTestCase implements LazyFields {
    public void testFailsWithInterface() {
        checkFailure(MyInterface.class);
    }

    public void testFailsWithNull() {
        checkFailure(null);
    }

    public void testOkWithImplementation() {
        new DefaultImplementation(MyClass.class);
    }

    public void testHashCodeShortCircuit() {
        Implementation subject = new DefaultImplementation(MyClass.class);
        int expected = MyClass.class.hashCode();
        assertEquals(expected, subject.hashCode());
    }

    private void checkFailure(Class<?> c) {
        try {
            new DefaultImplementation(c);
            fail();
        } catch (IllegalArgumentException expected) {}
    }

    private static interface MyInterface {

    }

    private static class MyClass {
    }
}
