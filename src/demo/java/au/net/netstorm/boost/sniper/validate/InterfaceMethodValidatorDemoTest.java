package au.net.netstorm.boost.sniper.validate;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class InterfaceMethodValidatorDemoTest extends LifecycleTestCase implements ExtendsAnInterface, LazyFields {
    InterfaceMethodValidator subject = new DefaultInterfaceMethodValidator();
    MethodMatcher testMethods = new TestMethodMatcher();

    public void testTooManyPublicMethodsFails() {
        try {
            subject.validate(this, new MethodMatcher[0]);
        } catch (RuntimeException actual) {}
    }

    public void testAllowingTestMethodsPasses() {
        subject.validate(this, testMethods);
    }

    public void aMethod() {
        doNothing();
    }

    public void anotherMethod() {
        doNothing();
    }

    private void doNothing() {
    }
}
