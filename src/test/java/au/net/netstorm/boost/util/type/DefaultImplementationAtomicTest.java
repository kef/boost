package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;

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
