package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;

public final class DefaultImplementationAtomicTest extends LifecycleTestCase implements LazyFields {
    public void testFailsWithInterface() {
        try {
            new DefaultImplementation(MyInterface.class);
            fail();
        } catch (IllegalArgumentException expected) {
        }
    }

    public void testOkWithImplementation() {
        new DefaultImplementation(MyClass.class);
    }

    private static interface MyInterface {
    }

    private static class MyClass {
    }
}
