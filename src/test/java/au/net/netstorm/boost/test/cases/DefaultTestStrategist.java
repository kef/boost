package au.net.netstorm.boost.test.cases;

import au.net.netstorm.boost.test.automock.FieldInjectorTestStrategy;
import au.net.netstorm.boost.test.automock.UsesMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;

final class DefaultTestStrategist implements TestStrategist {
    public TestStrategy determineStrategy(Object testCase) {
        Class cls = testCase.getClass();
        if (is(UsesMocks.class, cls)) {
            return new FieldInjectorTestStrategy((UsesMocks) testCase);
        }
        throw new IllegalStateException("There is no supported test strategy for " + cls);
    }

    private boolean is(Class expected, Class actual) {
        checkIsInterface(expected);
        return expected.isAssignableFrom(actual);
    }

    private void checkIsInterface(Class matching) {
        new DefaultInterface(matching);
    }
}
