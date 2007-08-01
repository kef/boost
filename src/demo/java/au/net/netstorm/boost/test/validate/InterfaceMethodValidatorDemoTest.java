package au.net.netstorm.boost.test.validate;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class InterfaceMethodValidatorDemoTest extends InteractionTestCase implements ExtendsAnInterface {
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
