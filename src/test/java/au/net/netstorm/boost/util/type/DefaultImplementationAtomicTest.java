package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultImplementationAtomicTest extends InteractionTestCase {

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
