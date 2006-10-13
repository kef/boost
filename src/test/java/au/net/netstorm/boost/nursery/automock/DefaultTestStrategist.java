package au.net.netstorm.boost.nursery.automock;

import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultTestStrategist implements TestStrategist {
    public TestStrategy determineStrategy(Object testCase) {
        Class cls = testCase.getClass();
        if (is(MockTestCase.class, cls)) return new MockTestStrategy(cls);
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
